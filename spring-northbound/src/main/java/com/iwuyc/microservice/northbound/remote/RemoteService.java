package com.iwuyc.microservice.northbound.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteService
{

    private static final RemoteService INSTANCE = new RemoteService();

    public static RemoteService instance()
    {
        return INSTANCE;
    }

    @Autowired
    private RestTemplate restTemplate;

    public RestTemplate restTemplate()
    {
        return restTemplate;
    }

}
