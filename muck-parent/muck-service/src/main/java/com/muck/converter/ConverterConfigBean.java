package com.muck.converter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
* @Description: 注册全局类型转换器
* @version: v1.0.0
* @author: 展昭
* @date: 2018年4月19日 下午3:18:32
 */
@Configuration
public class ConverterConfigBean {

	@Autowired
    private RequestMappingHandlerAdapter handlerAdapter;
	
	@PostConstruct
    public void initEditableAvlidation() {

        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if(initializer.getConversionService()!=null) {
            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();           
            
            // 注册日期类型转换器
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }
}
