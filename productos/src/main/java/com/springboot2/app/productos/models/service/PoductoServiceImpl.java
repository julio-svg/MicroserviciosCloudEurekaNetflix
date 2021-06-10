package com.springboot2.app.productos.models.service;

import com.springboot2.app.productos.models.dao.ProductoRepository;
import com.springboot2.app.productos.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service()
public class PoductoServiceImpl implements IProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

}
