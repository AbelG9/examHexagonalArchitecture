package com.codigo.examenHexagonalArch.infrastructure.repository;

import com.codigo.examenHexagonalArch.domain.models.FacturaCabecera;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaCabeceraOut;
import com.codigo.examenHexagonalArch.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FacturaCabeceraJPARepositoryAdapter implements FacturaCabeceraOut {
    private FacturaCabeceraJPARepository facturaCabeceraJPARepository;

    public FacturaCabeceraJPARepositoryAdapter(FacturaCabeceraJPARepository facturaCabeceraJPARepository) {
        this.facturaCabeceraJPARepository = facturaCabeceraJPARepository;
    }

    @Override
    public FacturaCabecera createFacturaCabecera(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
        return facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel();
    }

    @Override
    public List<FacturaCabecera> getFacturasCabeceras() {
        List<FacturaCabecera> facturaCabeceras = new ArrayList<>();
        facturaCabeceraJPARepository.findAll().forEach(facturaCabecera -> {
            facturaCabeceras.add(facturaCabecera.toDomainModel());
        });
        return facturaCabeceras;
    }

    @Override
    public Optional<FacturaCabecera> getFacturaCabecera(Long id) {
        if (facturaCabeceraJPARepository.existsById(id)) {
            return facturaCabeceraJPARepository.findById(id).map(FacturaCabeceraEntity::toDomainModel);
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaCabecera> updateFacturaCabecera(Long id, FacturaCabecera facturaCabecera) {
        if (facturaCabeceraJPARepository.existsById(id)) {
            facturaCabecera.setFactura_id(id);
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromDomainModel(facturaCabecera);
            return Optional.of(facturaCabeceraJPARepository.save(facturaCabeceraEntity).toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteFacturaCabecera(Long id) {
        if (facturaCabeceraJPARepository.existsById(id)) {
            facturaCabeceraJPARepository.deleteById(id);
            return true;
        }
        return false;
    }
}
