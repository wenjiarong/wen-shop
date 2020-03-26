package com.w.api.spike.service;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 查询秒杀记录
 */
public interface OrderSeckillService {

	@RequestMapping("/getOrder")
	public BaseResponse<JSONObject> getOrder(String phone, Long seckillId);

}
