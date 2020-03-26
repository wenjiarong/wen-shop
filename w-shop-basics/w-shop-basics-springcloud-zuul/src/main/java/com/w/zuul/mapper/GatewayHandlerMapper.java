package com.w.zuul.mapper;

import com.w.zuul.mapper.entity.GatewayHandlerEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 网关handler数据库访问
 */
@Component
public interface GatewayHandlerMapper {

	/**
	 * 获取第一个GatewayHandler
	 * 
	 * @return
	 */
	@Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid  ,is_open AS ISOPEN FROM gateway_handler WHERE is_open ='1' and prev_handler_id is null;;")
	public GatewayHandlerEntity getFirstGatewayHandler();

	@Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid  ,is_open AS ISOPEN FROM gateway_handler WHERE is_open ='1' and handler_id=#{handlerId}")
	public GatewayHandlerEntity getByHandler(String handlerId);

}
