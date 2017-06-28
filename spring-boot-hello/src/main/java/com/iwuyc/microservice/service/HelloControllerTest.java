package com.iwuyc.microservice.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerTest
{

    @RequestMapping("hellotest")
    public String index()
    {
        return "hello world";
    }
}
