package com.iwuyc.microservice.manager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Bootstrap
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(Bootstrap.class).web(true).run(args);
    }
}
