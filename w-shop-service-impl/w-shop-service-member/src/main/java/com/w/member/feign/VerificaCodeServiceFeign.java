package com.w.member.feign;

import com.w.weixin.service.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-w-weixin")
public interface VerificaCodeServiceFeign extends VerificaCodeService{
}
