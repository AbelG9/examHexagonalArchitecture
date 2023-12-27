package com.codigo.examenHexagonalArch.domain.ports.out;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraOut {
    FacturaCabecera createFacturaCabecera(FacturaCabecera facturaCabecera);
    List<FacturaCabecera> getFacturasCabeceras();
    Optional<FacturaCabecera> getFacturaCabecera(Long id);
    Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera);
    boolean deleteFacturaCabecera(Long id);
}
