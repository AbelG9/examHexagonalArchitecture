package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJPARepository extends JpaRepository<ProductoEntity, Long> {
}
