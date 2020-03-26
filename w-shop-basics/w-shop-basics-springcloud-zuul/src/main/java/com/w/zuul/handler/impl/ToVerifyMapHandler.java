package com.w.zuul.handler.impl;

import com.netflix.zuul.context.RequestContext;
import com.w.zuul.handler.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * api验证签名Handler
 */
@Component
@Slf4j
public class ToVerifyMapHandler extends BaseHandler implements GatewayHandler {

	@Override
	public void service(RequestContext ctx, HttpServletRequest req, HttpServletResponse response) {
		log.info(">>>>>>>第三关api验证签名Handler执行>>>>");
		nextGatewayHandler.service(ctx, req, response);
	}

}
