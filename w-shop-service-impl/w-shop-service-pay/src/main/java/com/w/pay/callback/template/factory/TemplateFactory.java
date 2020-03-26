package com.w.pay.callback.template.factory;

import com.w.core.utils.SpringContextUtil;
import com.w.pay.callback.template.AbstractPayCallbackTemplate;

/**
 * 获取具体实现的模版工厂方案
 */
public class TemplateFactory {

	public static AbstractPayCallbackTemplate getPayCallbackTemplate(String beanId) {
		return (AbstractPayCallbackTemplate) SpringContextUtil.getBean(beanId);
	}

}
