package com.w.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseApiService;
import com.w.base.BaseResponse;
import com.w.constants.Constants;
import com.w.core.token.GenerateToken;
import com.w.core.transaction.RedisDataSoureceTransaction;
import com.w.core.utils.MD5Util;
import com.w.member.MemberLoginService;
import com.w.member.input.dto.UserLoginInpDTO;
import com.w.member.mapper.UserMapper;
import com.w.member.mapper.UserTokenMapper;
import com.w.member.mapper.entity.UserDo;
import com.w.member.mapper.entity.UserTokenDo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用户登录接口实现类
 */
@RestController
public class MemberLoginServiceImpl extends BaseApiService<JSONObject> implements MemberLoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GenerateToken generateToken;
    @Autowired
    private UserTokenMapper userTokenMapper;
    /**
     *  redis 与 数据库同步事务
     */
    @Autowired
    private RedisDataSoureceTransaction redisDataSoureceTransaction;


    @Override
    public BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO) {
        // 1.验证参数
        String mobile = userLoginInpDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = userLoginInpDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        // 设备信息
        String deviceInfor = userLoginInpDTO.getDeviceInfor();
        if (StringUtils.isEmpty(deviceInfor)) {
            return setResultError("设备信息不能为空!");
        }
        // 判断登录类型
        String loginType = userLoginInpDTO.getLoginType();
        if (StringUtils.isEmpty(loginType)) {
            return setResultError("登陆类型不能为空!");
        }
        // 目的是限制范围
        if (!(loginType.equals(Constants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(Constants.MEMBER_LOGIN_TYPE_IOS)
                || loginType.equals(Constants.MEMBER_LOGIN_TYPE_PC))) {
            return setResultError("登陆类型出现错误!");
        }
        // 2.对登录密码实现加密
        String newPassWord = MD5Util.MD5(password);
        // 3.使用手机号码+密码查询数据库 判断用户是否存在
        UserDo userDo = userMapper.login(mobile, newPassWord);
        if(userDo==null){
            return setResultError("用户名称或者密码错误！");
        }
        TransactionStatus transactionStatus = null;
        try {
            // 每户每一个端登录成功之后，会对应生成一个token令牌（临时且唯一）存放在redis中作为rediskey  valueL:userId
            // 4.获取userId
            Long userId = userDo.getUserId();
            // 5.根据userId + loginType 查询当前登录类型账号之前是否登录过,如果登录过 清除之前redisToken
            UserTokenDo userTokenDo = userTokenMapper.selectByUserIdAndLoginType(userId, loginType);
            // 开启 redis与数据库 同步事务
            transactionStatus = redisDataSoureceTransaction.begin();
            if(userTokenDo != null){
                //  如果登录过 清除之前redisToken
                String token = userTokenDo.getToken();
                //  如果开启redis事务的话，删除的时候方法会返回false
                Boolean isRemoveToken = generateToken.removeToken(token);
                // 把该token的状态改为1
                int updateTokenAvailability = userTokenMapper.updateTokenAvailability(token);
                if (!toDaoResult(updateTokenAvailability)){
                    redisDataSoureceTransaction.rollback(transactionStatus);
                    return setResultError("系统错误！");
                }
            }
            UserTokenDo userToken = new UserTokenDo();
            userToken.setUserId(userId);
            userToken.setLoginType(loginType);
            userToken.setDeviceInfor(deviceInfor);

            //  如果有传递openid参数，修改到数据中
            String qqOpenId = userLoginInpDTO.getQqOpenId();
            if (!StringUtils.isEmpty(qqOpenId)) {
                userMapper.updateUserOpenId(qqOpenId, userId);
            }

            // 6.生成对应用户令牌存放在redis中,插入新的token
            String keyPrefix = Constants.MEMBER_TOKEN_KEYPREFIX + loginType;
            String newToken = generateToken.createToken(keyPrefix, userId + "");
            userToken.setToken(newToken);
            int insertUserToken = userTokenMapper.insertUserToken(userToken);
            if(!toDaoResult(insertUserToken)){
                redisDataSoureceTransaction.rollback(transactionStatus);
                setResultError("系统错误！");
            }
            JSONObject data = new JSONObject();
            data.put("token" , newToken);
            redisDataSoureceTransaction.commit(transactionStatus);
            return setResultSuccess(data);
        }catch (Exception e){
            try {
                redisDataSoureceTransaction.rollback(transactionStatus);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return setResultError("系统错误！");
        }
    }

}
