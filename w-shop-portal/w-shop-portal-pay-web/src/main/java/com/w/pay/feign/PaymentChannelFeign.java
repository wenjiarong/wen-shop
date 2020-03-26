package com.w.pay.feign;

import com.w.pay.service.PaymentChannelService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-w-pay")
public interface PaymentChannelFeign extends PaymentChannelService {

}
