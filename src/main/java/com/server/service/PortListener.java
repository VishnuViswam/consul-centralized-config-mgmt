package com.server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener {
    private int port;

    private static final Logger logger = LoggerFactory.getLogger(PortListener.class);
    @EventListener
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
        logger.info("################ Service Application is started !! and running under port {} ################", port);

    }

    public int getPort() {
        return port;
    }
}

