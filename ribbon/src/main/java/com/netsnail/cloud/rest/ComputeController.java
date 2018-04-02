package com.netsnail.cloud.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=1&b=9", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }

}