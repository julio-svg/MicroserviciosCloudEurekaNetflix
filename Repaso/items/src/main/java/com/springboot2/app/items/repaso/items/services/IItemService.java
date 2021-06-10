package com.springboot2.app.items.repaso.items.services;

import com.springboot2.app.items.repaso.items.model.entities.Item;

import java.util.List;

public interface IItemService {

    Item findById(Long id,Integer cantidad);

    List<Item> findAll();

}
