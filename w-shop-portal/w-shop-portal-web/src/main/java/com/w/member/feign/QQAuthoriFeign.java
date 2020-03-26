package com.w.member.feign;

import com.w.member.QQAuthoriService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-w-member")
public interface QQAuthoriFeign extends QQAuthoriService {
}
