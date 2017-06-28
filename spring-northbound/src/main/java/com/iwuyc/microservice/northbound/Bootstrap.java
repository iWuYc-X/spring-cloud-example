package com.iwuyc.microservice.northbound;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class Bootstrap
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}
