package com.springboot2.app.items.repaso.items.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Producto implements Serializable {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer port;
    private Date createAt;


}
