package com.iwuyc.microservice.northbound.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iwuyc.microservice.northbound.util.RequestUtil;

@RestController
@RequestMapping("/order")
public class NorthboundController
{
    private static final Logger LOG = LoggerFactory.getLogger(NorthboundController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/{subsystem}/**", method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("subsystem") String subsystem, HttpServletRequest request)
    {
        String serviceUrl = serviceUrlGenerator(subsystem, request);

        ResponseEntity<String> result = restTemplate.getForEntity(serviceUrl, String.class);
        ResponseEntity<Object> response = ResponseEntity.ok(result.getBody());
        return response;
    }

    @RequestMapping(path = "/{subsystem}/**", method = RequestMethod.POST)
    public ResponseEntity<Object> post(@PathVariable("subsystem") String subsystem, HttpServletRequest request,
            @RequestBody String body)
    {
        String serviceUrl = serviceUrlGenerator(subsystem, request);

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, RequestUtil.POST_HEADERS);

        ResponseEntity<String> result = restTemplate.postForEntity(serviceUrl, requestEntity, String.class);
        ResponseEntity<Object> response = ResponseEntity.ok(result.getBody());
        return response;
    }

    private String serviceUrlGenerator(@PathVariable("subsystem") String subsystem, HttpServletRequest request)
    {
        String method = RequestUtil.getPathParameter(request);
        StringBuilder serviceUrlBuilder = new StringBuilder("http://");
        serviceUrlBuilder.append(subsystem).append("/").append(method);
        String serviceUrl = serviceUrlBuilder.toString();
        LOG.info("Request url:{}", serviceUrl);
        return serviceUrl;
    }

}
