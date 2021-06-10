package com.springboot2.app.items.repaso.items.services;

import com.springboot2.app.items.repaso.items.model.entities.Item;
import com.springboot2.app.items.repaso.items.model.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("ItemRestTemplateService")
public class ItemServiceRestTemplateImpl implements IItemService{

    @Autowired
    RestTemplate clientRest;

    @Override
    public Item findById(Long id,Integer cantidad) {
        Map<String, String> pathVariables = new HashMap();
        pathVariables.put("id", id.toString());
        Producto p = clientRest.getForObject("http://servicio-producto/ver/{id}", Producto.class, pathVariables);
        return new Item(p,cantidad);

    }

    @Override
    public List<Item> findAll() {
        return Arrays.stream(clientRest.getForObject("http://servicio-producto/listar", Producto[].class))
                .map(p -> new Item(p,1))
                .collect(Collectors.toList());
    }
}
