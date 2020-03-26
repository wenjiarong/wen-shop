package com.w;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
@EnableApolloConfig
@EnableFeignClients
@MapperScan(basePackages = "com.w.zuul.mapper")
public class AppGateWay {
	
	// 开启阿波罗config,手动获取阿波罗配置文件
	@ApolloConfig
	private Config config;

	public static void main(String[] args) {
		SpringApplication.run(AppGateWay.class, args);
	}
	
	/**
	 * 获取swaggerDocument配置
	 * 
	 * @return
	 */
	private String swaggerDocument() {
		//第二个参数：如果没有获取到w.zuul.swagger.document，应该指定默认参数
		String property = config.getProperty("w.zuul.swagger.document", "");
		return property;
	}
	
	/**
	 * 从阿波罗服务器中获取resources
	 * 
	 * @return
	 */
	private List<SwaggerResource> resources() {

		List resources = new ArrayList<>();
		// app-w-order
		// 网关使用服务别名获取远程服务的SwaggerApi
		String swaggerDocJson = swaggerDocument();
		JSONArray jsonArray = JSONArray.parseArray(swaggerDocJson);
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			String name = jsonObject.getString("name");
			String location = jsonObject.getString("location");
			String version = jsonObject.getString("version");
			resources.add(swaggerResource(name, location, version));
		}
		return resources;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

	// 添加文档来源
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		
		// 访问swagger-ui页面的时候每次都会访问一下get方法
		@Override
		public List<SwaggerResource> get() {
			// app-w-order
			return resources();
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}

	}

}
