package com.iwuyc.microservice.northbound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Bootstrap
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Bootstrap
{

    public static void main(String[] args)
    {
        SpringApplication.run(Bootstrap.class, args);
    }
}
