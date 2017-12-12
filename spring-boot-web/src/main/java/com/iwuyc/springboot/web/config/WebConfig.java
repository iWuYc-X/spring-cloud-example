package com.iwuyc.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import javax.servlet.ServletException;

@EnableWebMvc
@Configuration
@ComponentScan("com.iwuyc")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*.jpg","/**/*.png").addResourceLocations("classpath:/WebRoot/static/img/");

        registry.addResourceHandler("/**/*.css").addResourceLocations("classpath:/WebRoot/static/css/");
        registry.addResourceHandler("/**/*.js").addResourceLocations("classpath:/WebRoot/static/js/");

        super.addResourceHandlers(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

//        registry.viewResolver(viewResolver);
        super.configureViewResolvers(registry);
    }

    @Bean
    public ViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Resource(name="dispatcherServlet")
    public DispatcherServlet dispatcherServlet(DispatcherServlet dispatcherServlet) throws ServletException {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        dispatcherServlet.init();
        return dispatcherServlet;
    }
}
