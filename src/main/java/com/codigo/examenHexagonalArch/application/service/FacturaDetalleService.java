package com.codigo.examenHexagonalArch.application.service;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;
import com.codigo.examenHexagonalArch.domain.ports.in.FacturaDetalleIn;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleIn {
    private final FacturaDetalleIn facturaDetalleIn;

    public FacturaDetalleService(FacturaDetalleIn facturaDetalleIn) {
        this.facturaDetalleIn = facturaDetalleIn;
    }

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.crearFacturaDetalle(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> obtenerFacturasDetalles() {
        return facturaDetalleIn.obtenerFacturasDetalles();
    }

    @Override
    public Optional<FacturaDetalle> obtenerFacturaDetalle(Long id) {
        return facturaDetalleIn.obtenerFacturaDetalle(id);
    }

    @Override
    public Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleIn.actualizarFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public boolean borrarFacturaDetalle(Long id) {
        return facturaDetalleIn.borrarFacturaDetalle(id);
    }
}
