package com.springboot2.app.items.repaso.items.controller;

import com.springboot2.app.items.repaso.items.model.entities.Item;

import com.springboot2.app.items.repaso.items.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ItemController {

    @Autowired
    @Qualifier("itemfeignclient")
    IItemService itemsService;

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item obtenerPorducto(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemsService.findById(id,cantidad);
    }

    @GetMapping("/listar")
    public List<Item> listarPorductos(){
        return itemsService.findAll();
    }
}
