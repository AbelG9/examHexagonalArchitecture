package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaCabeceraJPARepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
