package com.w.member.feign;

import com.w.member.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-w-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {
}
