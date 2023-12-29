package com.codigo.examenHexagonalArch.application.useCase;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;
import com.codigo.examenHexagonalArch.domain.ports.in.FacturaDetalleIn;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaDetalleOut;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleIn {
    private final FacturaDetalleOut facturaDetalleOut;

    public FacturaDetalleServiceImpl(FacturaDetalleOut facturaDetalleOut) {
        this.facturaDetalleOut = facturaDetalleOut;
    }

    @Override
    public FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.createFacturaDetalle(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> obtenerFacturasDetalles() {
        return facturaDetalleOut.getFacturasDetalles();
    }

    @Override
    public Optional<FacturaDetalle> obtenerFacturaDetalle(Long id) {
        return facturaDetalleOut.getFacturaDetalle(id);
    }

    @Override
    public Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOut.updateFacturaDetalle(id, facturaDetalle);
    }

    @Override
    public boolean borrarFacturaDetalle(Long id) {
        return facturaDetalleOut.deleteFacturaDetalle(id);
    }
}
