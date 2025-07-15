package com.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RefreshScope
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final PortListener portListener;

    public Controller(PortListener portListener) {
        this.portListener = portListener;
    }


    @Value("${message:Default}")
    String testMessage;
    @Value("${sample.config.1:Default}")
    String sampleConfig1;
    @Value("${sample.config.2:Default}")
    String sampleConfig2;
    @Value("${sample.config.3:Default}")
    String sampleConfig3;
    @Value("${sample.config.4:Default}")
    String sampleConfig4;

    // config from the common config of all apps
    @Value("${global.config:Default}")
    String globalConfig;

    @GetMapping(value = "getStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Object>> healthCheck() {
        logger.info("<--- Service to get status request : received --->");

        List<String> stringList = new ArrayList<>();
        stringList.add("Message: "+testMessage);
        stringList.add("Application is running under port: "+portListener.getPort());
        stringList.add("Global :"+globalConfig);
        stringList.add(sampleConfig1);
        stringList.add(sampleConfig2);
        stringList.add(sampleConfig3);
        stringList.add(sampleConfig4);
        logger.info("<--- Service to get status response : given --->");

        return Mono.just(ResponseEntity.ok(stringList));
    }
}
