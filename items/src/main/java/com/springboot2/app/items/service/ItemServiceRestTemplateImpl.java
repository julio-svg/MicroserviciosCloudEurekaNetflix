package com.springboot2.app.items.service;

import com.springboot2.app.items.model.entity.Item;
import com.springboot2.app.items.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("restTemplateClient")
public class ItemServiceRestTemplateImpl implements IItemService{

    @Autowired
    RestTemplate clientRest;


    @Override
    public Item findOne(Long id,Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());
        Producto producto = clientRest.getForObject("http://servicio-productos/ver/{id}",Producto.class,pathVariables);
        return new Item(producto,cantidad);
    }

    @Override
    public List<Item> findAll() {
        List<Producto> listProductos = Arrays.asList(clientRest.getForObject("http://servicio-productos/listar" ,Producto[].class));
        return listProductos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }
}
