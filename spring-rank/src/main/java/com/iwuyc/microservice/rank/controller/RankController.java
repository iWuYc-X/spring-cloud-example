package com.iwuyc.microservice.rank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iwuyc.microservice.rank.bean.TableInfo;

@RestController
@RequestMapping(path = "/rank")
public class RankController
{
    private static final Logger LOG = LoggerFactory.getLogger(RankController.class);

    @SuppressWarnings("unused")
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/ticket", method = RequestMethod.POST)
    public ResponseEntity<?> ticket()
    {

        return null;
    }

    @RequestMapping(path = "/tables/add", method = RequestMethod.POST)
    public ResponseEntity<?> addTableInfo(@RequestBody TableInfo tableInfo)
    {
        LOG.info(String.valueOf(tableInfo));
        return ResponseEntity.ok("Call table info method:Success!");
    }
}
