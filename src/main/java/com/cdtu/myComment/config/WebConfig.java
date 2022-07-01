package com.cdtu.myComment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private Interceptor interceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path="C:/JavaWeb/Comment/src/main/resources/static/img/";
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
