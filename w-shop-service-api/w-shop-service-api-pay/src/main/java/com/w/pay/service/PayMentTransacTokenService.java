package com.w.pay.service;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.weixin.input.dto.PayCratePayTokenDto;
import com.w.base.BaseResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 支付交易服务接口
 */
public interface PayMentTransacTokenService {

	/**
	 * 创建支付令牌
	 * 
	 * @return
	 */
	@RequestMapping("/cratePayToken")
	public BaseResponse<JSONObject> cratePayToken(@Validated PayCratePayTokenDto payCratePayTokenDto);

}
