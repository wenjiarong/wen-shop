package com.w.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseResponse;
import com.w.member.controller.req.vo.RegisterVo;
import com.w.member.feign.MemberRegisterServiceFeign;
import com.w.member.input.dto.UserInpDTO;
import com.w.web.base.BaseWebController;
import com.w.web.bean.MeiteBeanUtils;
import com.w.web.utils.RandomValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * 跳转到注册页面
 */
@Controller
public class RegisterController extends BaseWebController {

    private static final String MB_REGISTER_FTL = "member/register";
    private static final String MB_LOGIN_FTL = "member/login";
    @Autowired
    private MemberRegisterServiceFeign memberRegisterServiceFeign;

    @GetMapping("/register")
    public String getRegister() {
        return MB_REGISTER_FTL;
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute("registerVo") @Validated RegisterVo registerVo,
                               BindingResult bindingResult, Model model , HttpSession httpSession) {
        //  1.接受表单参数（验证码）创建对象接受参数 vo do dto
        if(bindingResult.hasErrors()){
            //  如果参数有错误的话
            //  获取第一个错误！
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            setErrorMsg(model,errorMsg);
            return MB_REGISTER_FTL;
        }
        //  2.判断图形验证码是否正确
        String graphicCode = registerVo.getGraphicCode();
        Boolean checkVerify = RandomValidateCodeUtil.checkVerify(graphicCode, httpSession);
        if(!checkVerify){
            setErrorMsg(model,"图形验证码不正确！");
            return MB_REGISTER_FTL;
        }
        //  3.调用会员服务接口实现注册  将前端提交vo 转换dto
        UserInpDTO userInpDTO = MeiteBeanUtils.voToDto(registerVo, UserInpDTO.class);
        BaseResponse<JSONObject> register = memberRegisterServiceFeign.register(userInpDTO, registerVo.getRegistCode());
        if(!isSuccess(register)){
            setErrorMsg(model,register.getMsg());
            return MB_REGISTER_FTL;
        }
        //  4.跳转到登录页面
        return MB_LOGIN_FTL;
    }


}
