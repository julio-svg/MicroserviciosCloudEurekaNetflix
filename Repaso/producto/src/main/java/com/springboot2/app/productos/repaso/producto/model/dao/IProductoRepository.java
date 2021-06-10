package com.springboot2.app.productos.repaso.producto.model.dao;

import com.springboot2.app.productos.repaso.producto.model.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepository extends CrudRepository<Producto,Long> {
}
