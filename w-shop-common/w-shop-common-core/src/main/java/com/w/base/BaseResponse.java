package com.w.base;

import lombok.Data;

/**
 * 微服务接口统一返回状态码
 * @param <T>
 */
@Data
public class BaseResponse<T> {

	/**
	 * 返回码
	 */
	private Integer code;
	/**
	 * 消息
	 */
	private String msg;
	/**
	 * 返回数据
	 */
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
}
