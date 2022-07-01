package com.cdtu.myComment.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path="C:/JavaWeb/Comment/src/main/resources/static/img/";
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+path);
    }
}
