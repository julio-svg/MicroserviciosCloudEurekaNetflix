package com.springboot2.app.items.repaso.items.services;

import com.springboot2.app.items.repaso.items.clients.ItemFeignClient;
import com.springboot2.app.items.repaso.items.model.entities.Item;
import com.springboot2.app.items.repaso.items.model.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;

@Service("itemfeignclient")
public class ItemServiceFeignClientImpl implements IItemService{

    @Autowired
    ItemFeignClient clientFeign;

    @Override
    public Item findById(Long id, Integer cantidad) {

        Producto p = clientFeign.obtenerProducto(id);
        return new Item(p,cantidad);

    }

    @Override
    public List<Item> findAll() {
        return (clientFeign.listarProductos()).stream()
                .map(p -> new Item(p,1))
                .collect(Collectors.toList());
    }
}
