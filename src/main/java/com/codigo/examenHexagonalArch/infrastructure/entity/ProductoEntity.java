package com.codigo.examenHexagonalArch.infrastructure.entity;

import com.codigo.examenHexagonalArch.domain.models.Producto;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Productos")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;

    public static ProductoEntity fromDomainModel(Producto producto) {
        return new ProductoEntity(
                producto.getProducto_id(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    public Producto toDomainModel() {
        return new Producto(
                producto_id,
                nombre,
                descripcion,
                precio,
                stock
        );
    }
}
