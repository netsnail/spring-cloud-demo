package com.netsnail.cloud.rest;

import org.springframework.stereotype.Component;

@Component
public class ComputeClientHytrix implements ComputeClient {
    @Override
    public Integer add(Integer a, Integer b) {
        return -999;
    }
}
