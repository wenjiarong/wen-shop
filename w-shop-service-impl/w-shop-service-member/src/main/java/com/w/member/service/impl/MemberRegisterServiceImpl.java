package com.w.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseApiService;
import com.w.base.BaseResponse;
import com.w.constants.Constants;
import com.w.core.bean.MeiteBeanUtils;
import com.w.core.utils.MD5Util;
import com.w.member.MemberRegisterService;
import com.w.member.feign.VerificaCodeServiceFeign;
import com.w.member.input.dto.UserInpDTO;
import com.w.member.mapper.UserMapper;
import com.w.member.mapper.entity.UserDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员注册接口实现类
 */
@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VerificaCodeServiceFeign verificaCodeServiceFeign;

    @Override
    @Transactional
    public BaseResponse<JSONObject> register(@RequestBody UserInpDTO userInpDTO, String registCode) {
        //1、参数验证
        /*String userName = userInpDTO.getUserName();
        if(StringUtils.isEmpty(userName)){
            return setResultError("用户名名称不能为空!");
        }*/
        String mobile = userInpDTO.getMobile();
        if(StringUtils.isEmpty(mobile)){
            return setResultError("手机号码不能为空!");
        }
        String password = userInpDTO.getPassword();
        if(StringUtils.isEmpty(password)){
            return setResultError("密码不能为空!");
        }
        //2、验证注册码是否正确  会员调用微信接口实现注册码验证
        BaseResponse<JSONObject> verificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile, registCode);
        if(!verificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)){
            return setResultError(verificaWeixinCode.getMsg());
        }
        //3、对用户的密码进行加密
        String newPassword = MD5Util.MD5(password);
        userInpDTO.setPassword(newPassword);
        //4、调用数据库插入数据  将请求的dto参数转换DO
        UserDo userDo = MeiteBeanUtils.dtoToDo(userInpDTO, UserDo.class);
        return userMapper.register(userDo)>0?setResultSuccess("注册成功"):setResultError("该用户已存在，注册失败");
    }

}
