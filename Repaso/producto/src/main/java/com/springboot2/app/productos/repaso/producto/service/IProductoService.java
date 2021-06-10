package com.springboot2.app.productos.repaso.producto.service;

import com.springboot2.app.productos.repaso.producto.model.entities.Producto;

import java.util.List;

public interface IProductoService {
    Producto findProductoById(Long id);

    List<Producto> findAllProductos();
}
