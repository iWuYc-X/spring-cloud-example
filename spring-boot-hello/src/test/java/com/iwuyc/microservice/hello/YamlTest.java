package com.iwuyc.microservice.hello;

import java.io.InputStream;
import java.net.URL;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import com.iwuyc.microservice.service.HelloController;

public class YamlTest
{
    @Test
    public void test() throws Exception
    {
        URL yamlUrl = HelloController.class.getResource("/Test.yaml");
        InputStream is = yamlUrl.openStream();
        Yaml yaml = new Yaml();
        Object obj = yaml.load(is);
        System.out.println(obj);
    }
}
