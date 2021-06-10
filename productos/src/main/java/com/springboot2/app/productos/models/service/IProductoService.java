package com.springboot2.app.productos.models.service;

import com.springboot2.app.productos.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();


    Producto findOne(Long id);
}
