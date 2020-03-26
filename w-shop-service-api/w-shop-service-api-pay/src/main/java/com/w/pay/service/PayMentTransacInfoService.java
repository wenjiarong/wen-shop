package com.w.pay.service;

import com.w.base.BaseResponse;
import com.w.weixin.out.dto.PayMentTransacDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @description:PayMentTransacInfo 服务接口
 */
public interface PayMentTransacInfoService {
	@GetMapping("/tokenByPayMentTransac")
	public BaseResponse<PayMentTransacDTO> tokenByPayMentTransac(@RequestParam("token") String token);
}
