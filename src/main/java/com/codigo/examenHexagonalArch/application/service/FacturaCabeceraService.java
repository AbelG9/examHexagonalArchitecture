package com.codigo.examenHexagonalArch.application.service;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;
import com.codigo.examenHexagonalArch.domain.ports.in.FacturaCabeceraIn;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraIn {
    private final FacturaCabeceraIn facturaCabeceraIn;

    public FacturaCabeceraService(FacturaCabeceraIn facturaCabeceraIn) {
        this.facturaCabeceraIn = facturaCabeceraIn;
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.crearFacturaCabecera(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> obtenerFacturasCabeceras() {
        return facturaCabeceraIn.obtenerFacturasCabeceras();
    }

    @Override
    public Optional<FacturaCabecera> obtenerFacturaCabecera(Long id) {
        return facturaCabeceraIn.obtenerFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraIn.actualizarFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        return facturaCabeceraIn.borrarFacturaCabecera(id);
    }
}
