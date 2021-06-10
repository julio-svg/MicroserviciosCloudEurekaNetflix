package com.springboot2.app.items.repaso.items.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

@RibbonClient( name = "servicio-producto")
public class AppConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate clientRestTemplate(){
        return new RestTemplate();
    }

}
