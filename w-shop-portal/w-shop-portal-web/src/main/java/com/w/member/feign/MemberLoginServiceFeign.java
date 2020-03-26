package com.w.member.feign;

import com.w.member.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-w-member")
public interface MemberLoginServiceFeign extends MemberLoginService {
}
