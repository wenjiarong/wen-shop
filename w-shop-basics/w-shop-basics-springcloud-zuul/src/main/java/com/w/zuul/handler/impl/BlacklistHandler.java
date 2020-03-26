package com.w.zuul.handler.impl;

import com.netflix.zuul.context.RequestContext;
import com.w.zuul.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 黑名单Handler
 */
@Component
@Slf4j
public class BlacklistHandler extends BaseHandler implements GatewayHandler {

	@Override
	public void service(RequestContext ctx, HttpServletRequest req, HttpServletResponse response) {
		log.info(">>>>>>>第二关黑名单Handler执行>>>>");
		// 执行下一个handler执行
		nextGatewayHandler.service(ctx, req, response);
	}

	// 有多种 可以使用模版方案设计模式或者 base

}
