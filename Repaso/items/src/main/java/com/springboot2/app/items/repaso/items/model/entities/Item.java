package com.springboot2.app.items.repaso.items.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Producto producto;
    private Integer cantidad;
    private Double total;

    public Item() {
    }

    public Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        total = obtenerTotal();

    }

    private Double obtenerTotal() {
        return producto.getPrecio() * cantidad;
    }


}
