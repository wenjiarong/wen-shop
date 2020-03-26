package com.w.pay.strategy.impl;


import com.w.pay.entity.PaymentChannelEntity;
import com.w.pay.strategy.PayStrategy;
import com.w.weixin.out.dto.PayMentTransacDTO;

public class XiaoPayStrategy implements PayStrategy {

	@Override
	public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {

		return "小米支付from表单提交";
	}
	//com.mayikt.pay.strategy.impl.XiaoPayStrategy

}
