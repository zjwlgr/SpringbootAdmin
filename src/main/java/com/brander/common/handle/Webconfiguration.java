package com.brander.common.handle;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 添加并触发拦截器的类
 */
@SpringBootConfiguration
public class Webconfiguration extends WebMvcConfigurerAdapter{

    /*
    * 覆盖父类addInterceptors方法，来添加拦截器类
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandleInterceptor());
    }
}
