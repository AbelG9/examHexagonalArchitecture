package com.codigo.examenHexagonalArch.domain.ports.out;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleOut {
    FacturaDetalle createFacturaDetalle(FacturaDetalle facturaDetalle);
    List<FacturaDetalle> getFacturasDetalles();
    Optional<FacturaDetalle> getFacturaDetalle(Long id);
    Optional<FacturaDetalle> updateFacturaDetalle(Long id,FacturaDetalle facturaDetalle);
    boolean deleteFacturaDetalle(Long id);
}
