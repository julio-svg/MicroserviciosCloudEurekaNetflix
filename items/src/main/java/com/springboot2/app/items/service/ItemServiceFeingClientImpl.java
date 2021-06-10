package com.springboot2.app.items.service;

import com.springboot2.app.items.clients.NetflixFeignClient;
import com.springboot2.app.items.model.entity.Item;
import com.springboot2.app.items.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("feingClient")
public class ItemServiceFeingClientImpl implements IItemService{

    @Autowired
    NetflixFeignClient feignClient;

   @Override
    public Item findOne(Long id, Integer cantidad) {

       return new Item(feignClient.obtenerItem(id),cantidad);

    }

    @Override
    public List<Item> findAll() {

        List <Producto> listaProduct = feignClient.obtenerItems();
        return listaProduct.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }
}
