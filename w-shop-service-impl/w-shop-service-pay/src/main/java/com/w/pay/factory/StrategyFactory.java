package com.w.pay.factory;

import com.w.pay.mapper.PaymentChannelMapper;
import com.w.pay.strategy.PayStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 初始化不同的策略行为
 */
public class StrategyFactory {
    private static Map<String, PayStrategy> strategyBean = new ConcurrentHashMap<String, PayStrategy>();

    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    public static PayStrategy getPayStrategy(String classAddres){
        try{
            if(StringUtils.isEmpty(classAddres)){
                return null;
            }
            PayStrategy beanPayStrategy = strategyBean.get(classAddres);
            if( beanPayStrategy != null){
                return beanPayStrategy;
            }
            // 1.使用java的反射机制初始化子类
            Class<?> forName = Class.forName(classAddres);
            // 2.反射机制初始化对象
            PayStrategy payStrategy = (PayStrategy) forName.newInstance();
            strategyBean.put(classAddres,payStrategy);
            return payStrategy;
        }catch (Exception e){
            return null;
        }
    }

}
