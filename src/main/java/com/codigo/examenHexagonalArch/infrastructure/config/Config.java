package com.codigo.examenHexagonalArch.infrastructure.config;

import com.codigo.examenHexagonalArch.application.service.FacturaCabeceraService;
import com.codigo.examenHexagonalArch.application.service.ProductoService;
import com.codigo.examenHexagonalArch.application.useCase.FacturaCabeceraServiceImpl;
import com.codigo.examenHexagonalArch.application.useCase.ProductoServiceImpl;
import com.codigo.examenHexagonalArch.domain.ports.out.FacturaCabeceraOut;
import com.codigo.examenHexagonalArch.domain.ports.out.ProductoOut;
import com.codigo.examenHexagonalArch.infrastructure.repository.FacturaCabeceraJPARepositoryAdapter;
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
}
