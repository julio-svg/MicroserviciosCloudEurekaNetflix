package com.springboot2.app.productos.models.dao;

import com.springboot2.app.productos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto,Long> {

}
