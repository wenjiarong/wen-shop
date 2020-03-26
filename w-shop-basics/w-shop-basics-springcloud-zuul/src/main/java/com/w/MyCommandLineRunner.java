package com.w;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;

/**
 * 阿波罗分布式配置中心方法监听
 * @author 63104
 *
 */

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {
	@ApolloConfig
	private Config config;

	@Override
	public void run(String... args) throws Exception {
		log.info("##################MyCommandLineRunner启动成功########################");
		// 阿波罗方法监听
		config.addChangeListener(new ConfigChangeListener() {
			@Override
			public void onChange(ConfigChangeEvent changeEvent) {
				log.info("####分布式配置中心监听#####" + changeEvent.changedKeys().toString());
			}
		});
	}

}
