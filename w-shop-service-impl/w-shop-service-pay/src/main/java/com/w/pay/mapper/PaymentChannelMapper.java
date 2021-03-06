package com.w.pay.mapper;

import com.w.pay.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentChannelMapper {

	@Select("SELECT channel_Name  AS channelName , channel_Id AS channelId, merchant_Id AS merchantId,sync_Url AS syncUrl, asyn_Url AS asynUrl,public_Key AS publicKey, private_Key AS privateKey,channel_State AS channelState ,class_ADDRES as classAddres ,retry_beanid as retryBeanId     FROM payment_channel WHERE CHANNEL_STATE='0';")
	public List<PaymentChannelEntity> selectAll();

	@Select("SELECT channel_Name  AS channelName , channel_Id AS channelId, merchant_Id AS merchantId,sync_Url AS syncUrl, asyn_Url AS asynUrl,public_Key AS publicKey, private_Key AS privateKey,channel_State AS channelState ,class_ADDRES as classAddres   ,retry_beanid as retryBeanId    FROM payment_channel WHERE CHANNEL_STATE='0'  AND channel_Id=#{channelId} ;")
	PaymentChannelEntity selectBychannelId(String channelId);
}
