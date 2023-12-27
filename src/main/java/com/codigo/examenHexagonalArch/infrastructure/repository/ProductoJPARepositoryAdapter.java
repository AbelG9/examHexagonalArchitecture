package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.domain.models.Producto;
import com.codigo.examenHexagonalArch.domain.ports.out.ProductoOut;
import com.codigo.examenHexagonalArch.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoJPARepositoryAdapter implements ProductoOut {
    private ProductoJPARepository productoJPARepository;

    public ProductoJPARepositoryAdapter(ProductoJPARepository productoJPARepository) {
        this.productoJPARepository = productoJPARepository;
    }

    @Override
    public Producto createProducto(Producto producto) {
        ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
        return productoJPARepository.save(productoEntity).toDomainModel();
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        productoJPARepository.findAll().forEach(product -> {
            productos.add(product.toDomainModel());
        });
        return productos;
    }

    @Override
    public Optional<Producto> getProducto(Long id) {
        if (productoJPARepository.existsById(id)) {
            return productoJPARepository.findById(id).map(ProductoEntity::toDomainModel);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        if (productoJPARepository.existsById(id)) {
            producto.setProducto_id(id);
            ProductoEntity productoEntity = ProductoEntity.fromDomainModel(producto);
            return Optional.of(productoJPARepository.save(productoEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteProducto(Long id) {
        if (productoJPARepository.existsById(id)) {
            productoJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
