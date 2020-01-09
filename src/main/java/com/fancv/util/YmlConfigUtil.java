package com.fancv.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * date 2020年1月9日
 *
 *
 *
 *
 */

@Component
public  class YmlConfigUtil implements ApplicationContextAware{
	
	
	
	
	private static ApplicationContext applicationContext = null;
    
    private static Map<String, String> propertiesMap =null;


    /*

     * 实现了ApplicationContextAware 接口，必须实现该方法；

     *通过传递applicationContext参数初始化成员变量applicationContext

     */

    public YmlConfigUtil() {
    }

    public static String getConfigByKey(String key) {
        if (propertiesMap ==null){
            YmlConfig ymlConfig = applicationContext.getBean(YmlConfig.class);
            propertiesMap = ymlConfig.getUrl();
        }
        return propertiesMap.get(key);
    }

    public static YmlConfig getConfig() {
        if (propertiesMap ==null){
            YmlConfig ymlConfig = applicationContext.getBean(YmlConfig.class);
            propertiesMap = ymlConfig.getUrl();
            return ymlConfig;
        }else{
            return null;
        }

    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(YmlConfigUtil.applicationContext == null){
        	YmlConfigUtil.applicationContext  = applicationContext;
        }
    }
}
