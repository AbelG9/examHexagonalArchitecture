package com.codigo.examenHexagonalArch.infrastructure.controller;

import com.codigo.examenHexagonalArch.application.service.ProductoService;
import com.codigo.examenHexagonalArch.domain.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
        Producto product = productoService.crearProducto(producto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> productos = productoService.obtenerProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProduct(@PathVariable Long id) {
        return productoService.obtenerProducto(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProductById(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}