package com.w.zuul.feign;

import com.w.auth.service.api.AuthorizationService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-w-auth")
public interface AuthorizationServiceFeign extends AuthorizationService {

}
