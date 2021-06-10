package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.commons.commons.models.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
