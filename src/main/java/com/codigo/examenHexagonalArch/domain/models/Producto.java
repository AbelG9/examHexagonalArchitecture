package com.codigo.examenHexagonalArch.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long producto_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
}
