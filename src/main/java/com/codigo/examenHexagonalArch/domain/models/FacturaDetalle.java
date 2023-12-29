package com.codigo.examenHexagonalArch.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalle {
    private Long detalle_id;
    private FacturaCabecera facturaCabecera;
    private Producto producto;
    private int cantidad;
    private Double precio_unitario;
    private Double subtotal;
}
