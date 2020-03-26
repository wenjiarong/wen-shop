package com.w.pay.feign;

import com.w.pay.service.PayMentTransacInfoService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-w-pay")
public interface PayMentTransacInfoFeign extends PayMentTransacInfoService {

}
