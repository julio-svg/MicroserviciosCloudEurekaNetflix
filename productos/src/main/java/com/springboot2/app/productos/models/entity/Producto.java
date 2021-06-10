package com.springboot2.app.productos.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    @Transient
    private Integer port;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
}
