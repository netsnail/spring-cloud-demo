package com.netsnail.cloud.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ComputeClientHytrix.class)
public interface ComputeClient {

    @GetMapping("/add")
    Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
