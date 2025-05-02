package com.trabalho.trabalho.config;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.entities.InsumoUtilizado;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.repository.InsumoRepository;
import com.trabalho.trabalho.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DesperdicioRepository Desperdiciorepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private PratoRepository pratoRepository;


    @Override
    public void run(String... args) throws Exception {
        Insumo i1 = new Insumo(null, "tomate", 5.0);
        Insumo i2 = new Insumo(null, "laranja", 5.0);
        insumoRepository.saveAll(Arrays.asList(i1, i2));

        Prato p1 = new Prato(null, "prato simples");
        pratoRepository.saveAll(Arrays.asList(p1));
        InsumoUtilizado is1 = new InsumoUtilizado(null,i1,p1,2.0);
        InsumoUtilizado is2 = new InsumoUtilizado(null,i2,p1,2.0);

        p1.getInsumoUtilizados().addAll(Arrays.asList(is1,is2));
        pratoRepository.saveAll(Arrays.asList(p1));

        Desperdicio d1 = new Desperdicio(null, "12/02/2024", 3.0, "desperdicio na cozinha");
        Desperdicio d2 = new Desperdicio(null, "13/02/2024", 3.0, "insumo vencido");
        Desperdiciorepository.saveAll(Arrays.asList(d1,d2));

        d1.getPratos().addAll(Arrays.asList(p1));
        d2.getInsumos().addAll(Arrays.asList(i1));
        Desperdiciorepository.saveAll(Arrays.asList(d1,d2));

    }
}
