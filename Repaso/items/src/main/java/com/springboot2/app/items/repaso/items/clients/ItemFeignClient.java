package com.springboot2.app.items.repaso.items.clients;

import com.springboot2.app.items.repaso.items.model.entities.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient("servicio-producto")
public interface ItemFeignClient {

    @GetMapping("/ver/{id}")
    Producto obtenerProducto(@PathVariable Long id);



    @GetMapping("/listar")
    List<Producto> listarProductos();



}
