package com.w.weixin.feign;

import com.w.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 微信使用feign客户端调用会员接口
 */
@FeignClient("app-w-member")
public interface MemberServiceFeign extends MemberService {
}
