package com.trabalho.trabalho.config;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DesperdicioRepository Desperdiciorepository;

    @Autowired
    private InsumoRepository insumoRepository;


    @Override
    public void run(String... args) throws Exception {
        Insumo i1 = new Insumo(null, "tomate", 5.0);
        Insumo i2 = new Insumo(null, "laranja", 5.0);
        insumoRepository.saveAll(Arrays.asList(i1, i2));

        Desperdicio d1 = new Desperdicio(null, "12/02/2024", 3.0);
        Desperdicio d2 = new Desperdicio(null, "12/02/2024", 4.0);
        d1.getInsumos().add(i1);
        d2.getInsumos().add(i2);
        Desperdiciorepository.saveAll(Arrays.asList(d1, d2));

    }
}
