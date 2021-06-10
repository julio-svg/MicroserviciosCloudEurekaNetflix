package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.commons.commons.models.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
