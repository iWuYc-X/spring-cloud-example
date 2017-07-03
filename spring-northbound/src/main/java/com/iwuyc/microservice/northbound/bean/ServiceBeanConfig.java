package com.iwuyc.microservice.northbound.bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.iwuyc.microservice.northbound.remote.RemoteService;

@Component
public class ServiceBeanConfig
{
    @Bean
    public RemoteService remoteService()
    {
        return RemoteService.instance();
    }

    private RestTemplate restTemplate = new RestTemplate();

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return restTemplate;
    }
}
