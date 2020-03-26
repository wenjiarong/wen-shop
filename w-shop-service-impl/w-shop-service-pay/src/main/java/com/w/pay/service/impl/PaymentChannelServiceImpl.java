package com.w.pay.service.impl;

import com.w.base.BaseApiService;
import com.w.mapper.MapperUtils;
import com.w.pay.entity.PaymentChannelEntity;
import com.w.pay.mapper.PaymentChannelMapper;
import com.w.pay.service.PaymentChannelService;
import com.w.weixin.out.dto.PaymentChannelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentChannelServiceImpl extends BaseApiService<List<PaymentChannelDTO>>
		implements PaymentChannelService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;

	@Override
	public List<PaymentChannelDTO> selectAll() {
		List<PaymentChannelEntity> paymentChanneList = paymentChannelMapper.selectAll();
		return MapperUtils.mapAsList(paymentChanneList, PaymentChannelDTO.class);
	}

}
