package com.codigo.examenHexagonalArch.infrastructure.controller;

import com.codigo.examenHexagonalArch.application.service.FacturaDetalleService;
import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facturaDetalle")
public class FacturaDetalleController {
    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }

    @PostMapping
    public ResponseEntity<FacturaDetalle> createFacturaDetalle(@RequestBody FacturaDetalle facturaDetalle) {
        FacturaDetalle facturaDet = facturaDetalleService.crearFacturaDetalle(facturaDetalle);
        return new ResponseEntity<>(facturaDet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> getAllFacturaDetalles() {
        List<FacturaDetalle> facturaDetalles = facturaDetalleService.obtenerFacturasDetalles();
        return new ResponseEntity<>(facturaDetalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDetalle> getFacturaDetalle(@PathVariable Long id) {
        return facturaDetalleService.obtenerFacturaDetalle(id)
                .map(facturaDetalle -> new ResponseEntity<>(facturaDetalle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDetalle> updateFacturaDetalle(@PathVariable Long id, @RequestBody FacturaDetalle facturaDetalle) {
        return facturaDetalleService.actualizarFacturaDetalle(id, facturaDetalle)
                .map(facturaDetalle1 -> new ResponseEntity<>(facturaDetalle1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaDetalle> deleteFacturaDetalleById(@PathVariable Long id) {
        facturaDetalleService.borrarFacturaDetalle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
