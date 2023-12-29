package com.codigo.examenHexagonalArch.domain.ports.in;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleIn {
    FacturaDetalle crearFacturaDetalle(FacturaDetalle facturaDetalle);
    List<FacturaDetalle> obtenerFacturasDetalles();
    Optional<FacturaDetalle> obtenerFacturaDetalle(Long id);
    Optional<FacturaDetalle> actualizarFacturaDetalle(Long id, FacturaDetalle facturaDetalle);
    boolean borrarFacturaDetalle(Long id);
}
