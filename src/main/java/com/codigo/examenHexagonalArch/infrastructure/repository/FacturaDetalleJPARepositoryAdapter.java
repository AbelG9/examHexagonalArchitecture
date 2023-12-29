package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.domain.models.FacturaDetalle;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaDetalleOut;
import com.codigo.examenHexagonalArch.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FacturaDetalleJPARepositoryAdapter implements FacturaDetalleOut {
    private FacturaDetalleJPARepository facturaDetalleJPARepository;

    public FacturaDetalleJPARepositoryAdapter(FacturaDetalleJPARepository facturaDetalleJPARepository) {
        this.facturaDetalleJPARepository = facturaDetalleJPARepository;
    }

    @Override
    public FacturaDetalle createFacturaDetalle(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
        return facturaDetalleJPARepository.save(facturaDetalleEntity).toDomainModel();
    }

    @Override
    public List<FacturaDetalle> getFacturasDetalles() {
        List<FacturaDetalle> facturaDetalles = new ArrayList<>();
        facturaDetalleJPARepository.findAll().forEach(facturaDetalle -> {
            facturaDetalles.add(facturaDetalle.toDomainModel());
        });
        return facturaDetalles;
    }

    @Override
    public Optional<FacturaDetalle> getFacturaDetalle(Long id) {
        if (facturaDetalleJPARepository.existsById(id)) {
             return facturaDetalleJPARepository.findById(id).map(FacturaDetalleEntity::toDomainModel);
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaDetalle> updateFacturaDetalle(Long id, FacturaDetalle facturaDetalle) {
        if (facturaDetalleJPARepository.existsById(id)) {
            facturaDetalle.setDetalle_id(id);
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromDomainModel(facturaDetalle);
            return Optional.of(facturaDetalleJPARepository.save(facturaDetalleEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteFacturaDetalle(Long id) {
        if (facturaDetalleJPARepository.existsById(id)) {
            facturaDetalleJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
