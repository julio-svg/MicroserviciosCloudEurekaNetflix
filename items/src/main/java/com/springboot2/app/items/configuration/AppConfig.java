package com.springboot2.app.items.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("clientTemplate")
    @LoadBalanced
    public RestTemplate obtenerCliente(){
        return new RestTemplate();
    }
}
