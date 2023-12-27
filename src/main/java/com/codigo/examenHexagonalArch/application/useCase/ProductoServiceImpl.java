package com.codigo.examenHexagonalArch.application.useCase;

import com.codigo.examenHexagonalArch.domain.models.Producto;
import com.codigo.examenHexagonalArch.domain.ports.in.ProductoIn;
import com.codigo.examenHexagonalArch.domain.ports.out.ProductoOut;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoIn {
    private final ProductoOut productoOut;

    public ProductoServiceImpl(ProductoOut productoOut) {
        this.productoOut = productoOut;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoOut.createProducto(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoOut.getProductos();
    }

    @Override
    public Optional<Producto> obtenerProducto(Long id) {
        return productoOut.getProducto(id);
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        return productoOut.updateProducto(id, producto);
    }

    @Override
    public boolean borrarProducto(Long id) {
        return productoOut.deleteProducto(id);
    }
}
