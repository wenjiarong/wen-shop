package com.xxl.sso.server.feign;

import com.w.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-w-member")
public interface MemberServiceFeign extends MemberService {

}
