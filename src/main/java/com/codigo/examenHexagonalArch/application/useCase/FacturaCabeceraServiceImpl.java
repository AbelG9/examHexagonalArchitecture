package com.codigo.examenHexagonalArch.application.useCase;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;
import com.codigo.examenHexagonalArch.domain.ports.in.FacturaCabeceraIn;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaCabeceraOut;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraIn {
    private final FacturaCabeceraOut facturaCabeceraOut;

    public FacturaCabeceraServiceImpl(FacturaCabeceraOut facturaCabeceraOut) {
        this.facturaCabeceraOut = facturaCabeceraOut;
    }

    @Override
    public FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.createFacturaCabecera(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> obtenerFacturasCabeceras() {
        return facturaCabeceraOut.getFacturasCabeceras();
    }

    @Override
    public Optional<FacturaCabecera> obtenerFacturaCabecera(Long id) {
        return facturaCabeceraOut.getFacturaCabecera(id);
    }

    @Override
    public Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOut.updateFacturaCabecera(id, facturaCabecera);
    }

    @Override
    public boolean borrarFacturaCabecera(Long id) {
        return facturaCabeceraOut.deleteFacturaCabecera(id);
    }
}
