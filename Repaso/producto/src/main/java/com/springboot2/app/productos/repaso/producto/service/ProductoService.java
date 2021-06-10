package com.springboot2.app.productos.repaso.producto.service;

import com.springboot2.app.productos.repaso.producto.model.dao.IProductoRepository;
import com.springboot2.app.productos.repaso.producto.model.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service()
public class ProductoService implements IProductoService {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public Producto findProductoById(Long id) {
        Producto p = productoRepository.findById(id).orElse(null);
        p.setPort(port);
        return p;
    }

    @Override
    public List<Producto> findAllProductos() {
        return ((List<Producto>) productoRepository.findAll()).stream()
                .map(p -> {
                    p.setPort(port);
                    return p;
                })
                .collect(Collectors.toList());
    }
}
