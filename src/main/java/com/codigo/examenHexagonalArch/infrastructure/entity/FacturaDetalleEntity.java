package com.codigo.examenHexagonalArch.infrastructure.entity;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Facturadetalle")
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalle_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "factura_id")
    private FacturaCabeceraEntity facturaCabecera;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    private int cantidad;
    private Double precio_unitario;
    private Double subtotal;

    public static FacturaDetalleEntity fromDomainModel(FacturaDetalle facturaDetalle) {
        return new FacturaDetalleEntity(
                facturaDetalle.getDetalle_id(),
                FacturaCabeceraEntity.fromDomainModel(facturaDetalle.getFacturaCabecera()),
                ProductoEntity.fromDomainModel(facturaDetalle.getProducto()),
                facturaDetalle.getCantidad(),
                facturaDetalle.getPrecio_unitario(),
                facturaDetalle.getSubtotal()
        );
    }

    public FacturaDetalle toDomainModel() {
        return new FacturaDetalle(
                detalle_id,
                facturaCabecera.toDomainModel(),
                producto.toDomainModel(),
                cantidad,
                precio_unitario,
                subtotal
        );
    }
}
