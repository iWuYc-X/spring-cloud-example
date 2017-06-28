package com.iwuyc.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(value = { "com.iwuyc.microservice" })
public class Bootstrap
{
    public static void main(String[] args)
    {
        SpringApplication.run(Bootstrap.class, args);
    }
}
