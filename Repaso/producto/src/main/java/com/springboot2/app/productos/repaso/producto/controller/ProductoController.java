package com.springboot2.app.productos.repaso.producto.controller;

import com.springboot2.app.productos.repaso.producto.model.entities.Producto;
import com.springboot2.app.productos.repaso.producto.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @GetMapping("/ver/{id}")
    public Producto obtenerProducto(@PathVariable Long id){
        return productoService.findProductoById(id);
    }

    @GetMapping("/listar")
    public List<Producto> listarProductos(){
        return productoService.findAllProductos();
    }
}
