package com.w.pay.strategy;

import com.w.pay.entity.PaymentChannelEntity;
import com.w.weixin.out.dto.PayMentTransacDTO;

/**
 * @description: 支付接口共同实现行为算法
 */
public interface PayStrategy {

    /**
     *
     * @param pymentChannel
     *            渠道参数
     * @param payMentTransacDTO
     *            支付参数
     * @return
     */
    public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO);

}