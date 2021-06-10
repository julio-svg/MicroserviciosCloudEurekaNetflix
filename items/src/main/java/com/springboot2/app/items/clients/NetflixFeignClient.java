package com.springboot2.app.items.clients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.springboot2.app.items.model.entity.Item;


import com.springboot2.app.items.model.entity.Producto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "servicio-productos")
public interface NetflixFeignClient {

    @GetMapping("/listar")
    List<Producto> obtenerItems();



    @GetMapping("/ver/{id}")
    Producto obtenerItem(@PathVariable Long id);

}
