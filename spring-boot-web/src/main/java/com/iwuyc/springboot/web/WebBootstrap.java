package com.iwuyc.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBootstrap {
    public static void main(String[] args) {
        args = new String[]{"--debug"};
        SpringApplication.run(WebBootstrap.class, args);
    }
}
