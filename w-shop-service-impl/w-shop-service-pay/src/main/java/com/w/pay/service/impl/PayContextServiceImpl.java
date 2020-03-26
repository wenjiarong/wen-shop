package com.w.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.w.base.BaseApiService;
import com.w.base.BaseResponse;
import com.w.pay.entity.PaymentChannelEntity;
import com.w.pay.factory.StrategyFactory;
import com.w.pay.mapper.PaymentChannelMapper;
import com.w.pay.service.PayContextService;
import com.w.pay.service.PayMentTransacInfoService;
import com.w.pay.strategy.PayStrategy;
import com.w.weixin.out.dto.PayMentTransacDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayContextServiceImpl extends BaseApiService<JSONObject> implements PayContextService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;
	@Autowired
	private PayMentTransacInfoService payMentTransacInfoService;

	@Override
	public BaseResponse<JSONObject> toPayHtml(String channelId, String payToken) {
		// 1.使用渠道id获取渠道信息 classAddres
		PaymentChannelEntity pymentChannel = paymentChannelMapper.selectBychannelId(channelId);
		if (pymentChannel == null) {
			return setResultError("没有查询到该渠道信息");
		}
		// 2.使用payToken获取支付参数
		BaseResponse<PayMentTransacDTO> tokenByPayMentTransac = payMentTransacInfoService
				.tokenByPayMentTransac(payToken);
		if (!isSuccess(tokenByPayMentTransac)) {
			return setResultError(tokenByPayMentTransac.getMsg());
		}
		PayMentTransacDTO payMentTransacDTO = tokenByPayMentTransac.getData();
		// 3.执行具体的支付渠道的算法获取html表单数据 策略设计模式 使用java反射机制 执行具体方法
		String classAddres = pymentChannel.getClassAddres();
		PayStrategy payStrategy = StrategyFactory.getPayStrategy(classAddres);
		String payHtml = payStrategy.toPayHtml(pymentChannel, payMentTransacDTO);
		// 4.直接返回html
		JSONObject data = new JSONObject();
		data.put("payHtml", payHtml);
		return setResultSuccess(data);
	}

}
