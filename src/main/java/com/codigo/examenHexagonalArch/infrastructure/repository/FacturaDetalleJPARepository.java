package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleJPARepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
