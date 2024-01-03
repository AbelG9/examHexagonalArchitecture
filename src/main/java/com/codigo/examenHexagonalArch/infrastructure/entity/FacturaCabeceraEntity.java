package com.codigo.examenHexagonalArch.infrastructure.entity;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Facturacabecera")
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Double total;

    @OneToMany(mappedBy = "facturaCabecera")
    private Set<FacturaDetalleEntity> facturaDetalleSet = new HashSet<>();

    public static FacturaCabeceraEntity fromDomainModel(FacturaCabecera facturaCabecera) {
        return new FacturaCabeceraEntity(
                facturaCabecera.getFactura_id(),
                facturaCabecera.getCliente_nombre(),
                facturaCabecera.getCliente_num_documento(),
                facturaCabecera.getFecha_emision(),
                facturaCabecera.getTotal(),
                facturaCabecera.getFacturaDetalleSet()
        );
    }

    public FacturaCabecera toDomainModel() {
        return new FacturaCabecera(
                factura_id,
                cliente_nombre,
                cliente_num_documento,
                fecha_emision,
                total,
                facturaDetalleSet
        );
    }
}
