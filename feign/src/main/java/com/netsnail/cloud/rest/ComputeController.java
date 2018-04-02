package com.netsnail.cloud.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ComputeController {
    private static final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Autowired ComputeClient computeClient;

    @Value("${from}") String from;

    @GetMapping("/add")
    public Integer add() {
        logger.info("reading from config-server, from={}", from);
        return computeClient.add(10, 20);
    }
}
