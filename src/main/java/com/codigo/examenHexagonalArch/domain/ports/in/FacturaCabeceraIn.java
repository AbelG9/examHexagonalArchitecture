package com.codigo.examenHexagonalArch.domain.ports.in;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraIn {
    FacturaCabecera crearFacturaCabecera(FacturaCabecera facturaCabecera);
    List<FacturaCabecera> obtenerFacturasCabeceras();
    Optional<FacturaCabecera> obtenerFacturaCabecera(Long id);
    Optional<FacturaCabecera> actualizarFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean borrarFacturaCabecera(Long id);
}
