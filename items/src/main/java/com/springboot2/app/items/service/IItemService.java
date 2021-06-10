package com.springboot2.app.items.service;

import com.springboot2.app.items.model.entity.Item;
import com.springboot2.app.items.model.entity.Producto;

import java.util.List;

public interface IItemService {
    Item findOne(Long id,Integer cantidad);

    List<Item> findAll();
}
