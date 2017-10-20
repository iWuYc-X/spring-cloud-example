package com.iwuyc.springboot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*.jpg").addResourceLocations("classpath:/WebRoot/static/img/");
        registry.addResourceHandler("/**/*.css").addResourceLocations("classpath:/WebRoot/static/css/");
        registry.addResourceHandler("/**/*.js").addResourceLocations("classpath:/WebRoot/static/js/");

        super.addResourceHandlers(registry);
    }
}
