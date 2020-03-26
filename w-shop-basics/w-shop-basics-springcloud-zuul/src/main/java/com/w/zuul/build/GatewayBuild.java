package com.w.zuul.build;

import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 网关权限Build
 */
public interface GatewayBuild {
	/**
	 * 黑名单拦截
	 */
	Boolean blackBlock(RequestContext ctx, String ipAddres, HttpServletResponse response);

	/**
	 * 参数验证
	 */
	Boolean toVerifyMap(RequestContext ctx, String ipAddres, HttpServletRequest request);

	/**
	 * api权限控制
	 * 
	 * @return
	 */
	Boolean apiAuthority(RequestContext ctx, HttpServletRequest request);
}
