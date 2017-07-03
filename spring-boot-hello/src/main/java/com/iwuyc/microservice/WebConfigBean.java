package com.iwuyc.microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.iwuyc.microservice.filter.HTTPBasicAuthorizeAttribute;
import com.iwuyc.microservice.filter.HTTPBasicAuthorizeAttribute2;

@Component
public class WebConfigBean
{
    @Bean(name = "myFilter")
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrator = new FilterRegistrationBean();
        filterRegistrator.setFilter(new HTTPBasicAuthorizeAttribute());
        return filterRegistrator;
    }

    @Bean(name = "myFilter")
    @ConditionalOnMissingBean
    public FilterRegistrationBean filterRegistrationBean1()
    {
        FilterRegistrationBean filterRegistrator = new FilterRegistrationBean();
        filterRegistrator.setFilter(new HTTPBasicAuthorizeAttribute2());
        return filterRegistrator;
    }
}
