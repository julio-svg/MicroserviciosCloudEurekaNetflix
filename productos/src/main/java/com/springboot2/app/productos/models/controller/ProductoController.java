package com.springboot2.app.productos.models.controller;


import com.springboot2.app.productos.models.entity.Producto;
import com.springboot2.app.productos.models.service.IProductoService;
import org.springframework.beans.factory.annotation
        .Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    Environment env;

    @Value("${server.port}")
    public Integer port;

    @Autowired
    IProductoService productoService;

    @GetMapping("/listar")
    List<Producto> listarProductos() {
        return productoService.findAll().stream()
                /*.map(p -> {
                    p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                    return p;
                })*/
                .map(p -> {
                    p.setPort(port);
                return  p;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("ver/{id}")
    Producto buscarProductPorId(@PathVariable Long id) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Producto p = productoService.findOne(id);
        //p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        p.setPort(port);
        return p;
    }
}
