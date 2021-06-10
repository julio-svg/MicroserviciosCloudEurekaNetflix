package com.springboot2.app.items.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot2.app.items.model.entity.Item;
import com.springboot2.app.items.model.entity.Producto;
import com.springboot2.app.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

@RestController
public class ItemController {

    @Autowired
    @Qualifier("restTemplateClient")
    IItemService iItemService;

    @GetMapping("/listar")
    public List<Item> obtenerItems() {
        return iItemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "errorMethod")
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item obtenerItem(@PathVariable Long id, @PathVariable Integer cantidad) {
        return iItemService.findOne(id, cantidad);
    }

    public Item errorMethod(@PathVariable Long id, @PathVariable Integer cantidad) {
        Producto p = new Producto();
        p.setNombre("producto Erroneo");
        p.setPrecio(0D);
        return new Item(p,cantidad);
    }

}
