package com.codigo.examenHexagonalArch.application.service;

import com.codigo.examenHexagonalArch.domain.models.Producto;
import com.codigo.examenHexagonalArch.domain.ports.in.ProductoIn;
import com.codigo.examenHexagonalArch.domain.ports.out.ProductoOut;

import java.util.Optional;

public class ProductoService implements ProductoIn {
    private final ProductoIn productoIn;

    public ProductoService(ProductoIn productoIn) {
        this.productoIn = productoIn;
    }
    @Override
    public Producto crearProducto(Producto producto) {
        return productoIn.crearProducto(producto);
    }

    @Override
    public Optional<Producto> obtenerProducto(Long id) {
        return productoIn.obtenerProducto(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return productoIn.actualizarProducto(id, producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return productoIn.borrarProducto(id);
    }
}
