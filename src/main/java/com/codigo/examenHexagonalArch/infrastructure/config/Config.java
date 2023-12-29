package com.codigo.examenHexagonalArch.infrastructure.config;

import com.codigo.examenHexagonalArch.application.service.FacturaCabeceraService;
import com.codigo.examenHexagonalArch.application.service.FacturaDetalleService;
import com.codigo.examenHexagonalArch.application.service.ProductoService;
import com.codigo.examenHexagonalArch.application.useCase.FacturaCabeceraServiceImpl;
import com.codigo.examenHexagonalArch.application.useCase.FacturaDetalleServiceImpl;
import com.codigo.examenHexagonalArch.application.useCase.ProductoServiceImpl;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaCabeceraOut;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaDetalleOut;
import com.codigo.examenHexagonalArch.domain.ports.out.ProductoOut;
import com.codigo.examenHexagonalArch.infrastructure.repository.FacturaCabeceraJPARepositoryAdapter;
import com.codigo.examenHexagonalArch.infrastructure.repository.FacturaDetalleJPARepository;
import com.codigo.examenHexagonalArch.infrastructure.repository.FacturaDetalleJPARepositoryAdapter;
import com.codigo.examenHexagonalArch.infrastructure.repository.ProductoJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ProductoService productoService(ProductoOut productoOut) {
        return new ProductoService(new ProductoServiceImpl(productoOut));
    }

    @Bean
    public ProductoOut productoOut(ProductoJPARepositoryAdapter productoJPARepositoryAdapter) {
        return productoJPARepositoryAdapter;
    }

    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOut facturaCabeceraOut) {
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOut));
    }

    @Bean
    public FacturaCabeceraOut facturaCabeceraOut(FacturaCabeceraJPARepositoryAdapter facturaCabeceraJPARepositoryAdapter) {
        return facturaCabeceraJPARepositoryAdapter;
    }

    @Bean
    public FacturaDetalleService facturaDetalleService(FacturaDetalleOut facturaDetalleOut) {
        return new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleOut));
    }

    @Bean
    public FacturaDetalleOut facturaDetalleOut(FacturaDetalleJPARepositoryAdapter facturaDetalleJPARepositoryAdapter) {
        return facturaDetalleJPARepositoryAdapter;
    }
}
