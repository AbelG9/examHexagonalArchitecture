package com.codigo.examenHexagonalArch.domain.ports.in;

import com.codigo.examenHexagonalArch.domain.models.Producto;

import java.util.Optional;

public interface ProductoIn {
    Producto crearProducto(Producto producto);
    Optional<Producto> obtenerProducto(Long id);
    Optional<Producto> actualizarProducto(Long id, Producto producto);
    boolean borrarProducto(Long id);
}
