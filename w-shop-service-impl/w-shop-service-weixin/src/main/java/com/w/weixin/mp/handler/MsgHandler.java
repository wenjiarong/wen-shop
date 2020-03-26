package com.w.weixin.mp.handler;

import com.w.base.BaseResponse;
import com.w.constants.Constants;
import com.w.core.utils.RedisUtil;
import com.w.core.utils.RegexUtils;
import com.w.member.output.dto.UserOutDTO;
import com.w.weixin.feign.MemberServiceFeign;
import com.w.weixin.mp.builder.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    /**
     * 发送验证码消息
     */
    @Value("${w.weixin.registration.code.message}")
    private String registrationCodeMessage;
    /**
     * 默认回复消息
     */
    @Value("${w.weixin.default.registration.code.message}")
    private String defaultRegistrationCodeMessage;


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        //1、获取微信客户端发送的消息
        String fromContent = wxMessage.getContent();
        //2、使用正则表达式验证消息是否为手机号码格式
        if(RegexUtils.checkMobile(fromContent)){
            //3、根据手机号码调用会员服务接口查询用户信息是否存在
            BaseResponse<UserOutDTO> resultUserInfo = memberServiceFeign.existMobile(fromContent);
            if(resultUserInfo.getCode().equals(Constants.HTTP_RES_CODE_200)){
                return new TextBuilder().build("该手机号码"+fromContent+"已经存在！", wxMessage, weixinService);
            }
            if(!resultUserInfo.getCode().equals(Constants.HTTP_RES_CODE_EXISTMOBILE_203)){
                return new TextBuilder().build(resultUserInfo.getMsg(), wxMessage, weixinService);
            }
            //4、如果是手机号码格式的话，随机生产4位数字注册码
            int registCode = registCode();
            String content = registrationCodeMessage.format(registrationCodeMessage, registCode);
            // 将注册码存入在redis中  key为手机号码
            redisUtil.setString(Constants.WEIXINCODE_KEY + fromContent,registCode+"",Constants.WEIXINCODE_TIMEOUT);
            return new TextBuilder().build(content, wxMessage, weixinService);
        }
        // 否则情况下返回默认消息 调用第三方机器人接口
        return new TextBuilder().build(defaultRegistrationCodeMessage, wxMessage, weixinService);
    }

    // 获取注册码
    private int registCode() {
        int registCode = (int) (Math.random() * 9000 + 1000);
        return registCode;
    }


}
