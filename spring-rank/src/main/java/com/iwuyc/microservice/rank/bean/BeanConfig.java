package com.iwuyc.microservice.rank.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig
{
    private RestTemplate restTemplate = new RestTemplate();

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return restTemplate;
    }
}
