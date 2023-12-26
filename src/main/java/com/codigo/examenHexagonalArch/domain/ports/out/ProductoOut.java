package com.codigo.examenHexagonalArch.domain.ports.out;

import com.codigo.examenHexagonalArch.domain.models.Producto;

import java.util.Optional;

public interface ProductoOut {
    Producto createProducto(Producto producto);
    Optional<Producto> getProducto(Long id);
    Optional<Producto> updateProducto(Long id, Producto producto);
    boolean deleteProducto(Long id);
}
