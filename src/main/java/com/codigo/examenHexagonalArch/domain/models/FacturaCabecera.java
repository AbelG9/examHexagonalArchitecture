package com.codigo.examenHexagonalArch.domain.models;

import com.codigo.examenHexagonalArch.infrastructure.entity.FacturaDetalleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCabecera {
    private Long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Double total;
    private Set<FacturaDetalleEntity> facturaDetalleSet;
}
