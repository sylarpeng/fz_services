package com.example.fz_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter exporter(){
        ServerEndpointExporter exporter=new ServerEndpointExporter();
        return exporter;
    }
}
