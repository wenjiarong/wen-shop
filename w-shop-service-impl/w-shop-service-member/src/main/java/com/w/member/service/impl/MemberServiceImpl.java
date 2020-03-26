package com.w.member.service.impl;

import com.w.base.BaseApiService;
import com.w.base.BaseResponse;
import com.w.constants.Constants;
import com.w.core.bean.MeiteBeanUtils;
import com.w.core.token.GenerateToken;
import com.w.core.type.TypeCastHelper;
import com.w.core.utils.MD5Util;
import com.w.member.MemberService;
import com.w.member.input.dto.UserLoginInpDTO;
import com.w.member.mapper.UserMapper;
import com.w.member.mapper.entity.UserDo;
import com.w.member.output.dto.UserOutDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 会员服务接口实现
 * @author 63104
 *
 */

@RestController
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<UserOutDTO> existMobile(String mobile) {
		//1、验证参数
		if(StringUtils.isEmpty(mobile)){
			return setResultError("手机号码不能为空！");
		}
		//2、根据手机号码查询用户信息  单独定义code 表示是用户信息不存在
		UserDo userDo = userMapper.existMobile(mobile);
		if(userDo == null){
			return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203,"用户信息不存在");
		}
		//3、将do转换成dto
		return setResultSuccess(MeiteBeanUtils.doToDto(userDo , UserOutDTO.class));
	}

	@Override
	public BaseResponse<UserOutDTO> getInfo(String token) {
		// 1.验证token参数
		if(StringUtils.isEmpty(token)){
			return setResultError("token不能为空！");
		}
		// 2.使用token查询redis中的userId
		String redisUserId = generateToken.getToken(token);
		if(StringUtils.isEmpty(redisUserId)){
			return setResultError("token已经失效或者token错误！");
		}
		// 3.使用userId查询数据库用户信息
		Long userId = TypeCastHelper.toLong(redisUserId);
		UserDo userDo = userMapper.findByUserId(userId);
		if(userDo == null){
			return setResultError("用户不存在");
		}
		return setResultSuccess(MeiteBeanUtils.doToDto(userDo,UserOutDTO.class));
	}

	@Override
	public BaseResponse<UserOutDTO> ssoLogin(@RequestBody UserLoginInpDTO userLoginInpDTO) {
		// 1.验证参数
		String mobile = userLoginInpDTO.getMobile();
		if (StringUtils.isEmpty(mobile)) {
			return setResultError("手机号码不能为空!");
		}
		String password = userLoginInpDTO.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		// 判断登陆类型
		String loginType = userLoginInpDTO.getLoginType();
		if (StringUtils.isEmpty(loginType)) {
			return setResultError("登陆类型不能为空!");
		}
		// 目的是限制范围
		if (!(loginType.equals(Constants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(Constants.MEMBER_LOGIN_TYPE_IOS)
				|| loginType.equals(Constants.MEMBER_LOGIN_TYPE_PC))) {
			return setResultError("登陆类型出现错误!");
		}
		// 设备信息
		String deviceInfor = userLoginInpDTO.getDeviceInfor();
		if (StringUtils.isEmpty(deviceInfor)) {
			return setResultError("设备信息不能为空!");
		}
		// 2.对登陆密码实现加密
		String newPassWord = MD5Util.MD5(password);
		// 3.使用手机号码+密码查询数据库 ，判断用户是否存在
		UserDo userDo = userMapper.login(mobile, newPassWord);
		if (userDo == null) {
			return setResultError("用户名称或者密码错误!");
		}
		return setResultSuccess(MeiteBeanUtils.doToDto(userDo, UserOutDTO.class));
	}

	// token存放在PC端 cookie token 存放在安卓 或者IOS端 存放在本地文件中
	// 当前存在那些问题？ 用户如果退出或者修改密码、忘记密码的情况 对token状态进行标识
	// token 如何防止伪造 真正其实很难防御伪造 尽量实现在安全体系 xss 只能在一些某些业务模块上加上必须验证本人操作
}
