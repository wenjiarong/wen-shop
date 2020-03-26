package com.w.member.feign;

import com.w.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-w-member")
public interface MemberServiceFeign extends MemberService {
}
