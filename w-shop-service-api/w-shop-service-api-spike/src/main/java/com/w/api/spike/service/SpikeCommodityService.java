package com.w.api.spike.service;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 秒杀商品服务接口
 */
public interface SpikeCommodityService {

	/**
	 * 用户秒杀接口 phone和userid都可以的
	 * 
	 * @phone 手机号码<br>
	 * @seckillId 库存id
	 * @return
	 */
	@RequestMapping("/spike")
	public BaseResponse<JSONObject> spike(String phone, Long seckillId);

	/**
	 * 新增对应商品库存令牌桶
	 * 
	 * @seckillId 商品库存id
	 */
	@RequestMapping("/addSpikeToken")
	public BaseResponse<JSONObject> addSpikeToken(Long seckillId, Long tokenQuantity);

}
