package com.w.pay.feign;

import com.w.pay.service.PayContextService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-w-pay")
public interface PayContextFeign extends PayContextService {

}
