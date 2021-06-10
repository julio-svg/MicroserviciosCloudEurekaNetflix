package com.springboot2.app.items.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
        total = calcularTotal();
    }



    public Double calcularTotal(){
        return this.producto.getPrecio() * this.cantidad.doubleValue();
    }
}
