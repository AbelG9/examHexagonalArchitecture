package com.codigo.examenHexagonalArch.infrastructure.controller;

import com.codigo.examenHexagonalArch.application.service.FacturaCabeceraService;
import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;
import com.codigo.examenHexagonalArch.domain.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/facturaCabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }

    @PostMapping
    public ResponseEntity<FacturaCabecera> createFacturaCabecera(@RequestBody FacturaCabecera facturaCabecera) {
        FacturaCabecera facturaCab = facturaCabeceraService.crearFacturaCabecera(facturaCabecera);
        return new ResponseEntity<>(facturaCab, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FacturaCabecera>> getAllFacturaCabeceras() {
        List<FacturaCabecera> facturaCabeceras = facturaCabeceraService.obtenerFacturasCabeceras();
        return new ResponseEntity<>(facturaCabeceras, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaCabecera> getFacturaCabecera(@PathVariable Long id) {
        return facturaCabeceraService.obtenerFacturaCabecera(id)
                .map(facturaCabecera -> new ResponseEntity<>(facturaCabecera, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaCabecera> updateFacturaCabecera(@PathVariable Long id, @RequestBody FacturaCabecera facturaCabecera) {
        return facturaCabeceraService.actualizarFacturaCabecera(id, facturaCabecera)
                .map(facturaCab -> new ResponseEntity<>(facturaCab, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteFacturaCabeceraById(@PathVariable Long id) {
        facturaCabeceraService.borrarFacturaCabecera(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
