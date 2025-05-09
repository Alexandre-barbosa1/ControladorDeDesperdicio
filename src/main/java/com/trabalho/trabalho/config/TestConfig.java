package com.trabalho.trabalho.config;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.entities.InsumoUtilizado;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.repository.InsumoRepository;
import com.trabalho.trabalho.repository.PratoRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DesperdicioRepository desperdicioRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private PratoRepository pratoRepository;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        desperdicioRepository.deleteAll();
        insumoRepository.deleteAll();
        pratoRepository.deleteAll();


        Insumo i1 = new Insumo(null, "tomate", 5.0);
        Insumo i2 = new Insumo(null, "laranja", 5.0);
        Insumo i3 = new Insumo(null, "cenoura", 8.0);
        Insumo i4 = new Insumo(null, "feijao", 10.0);
        Insumo i5 = new Insumo(null, "alface", 6.0);
        Insumo i6 = new Insumo(null, "cebola", 4.0);
        Insumo i7 = new Insumo(null, "batata", 7.0);
        Insumo i8 = new Insumo(null, "alho", 3.0);
        insumoRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8));

        Prato p1 = new Prato(null, "prato simples");
        Prato p2 = new Prato(null, "prato vegetariano");
        Prato p3 = new Prato(null, "prato feijão com arroz");
        pratoRepository.saveAll(Arrays.asList(p1, p2, p3));


        InsumoUtilizado is1 = new InsumoUtilizado(null, 2.0, i1, p1);
        InsumoUtilizado is2 = new InsumoUtilizado(null, 2.0, i2, p1);
        InsumoUtilizado is3 = new InsumoUtilizado(null, 3.0, i3, p2);
        InsumoUtilizado is4 = new InsumoUtilizado(null, 1.5, i5, p2);
        InsumoUtilizado is5 = new InsumoUtilizado(null, 2.0, i4, p3);
        InsumoUtilizado is6 = new InsumoUtilizado(null, 1.0, i7, p3);
        InsumoUtilizado is7 = new InsumoUtilizado(null, 1.0, i8, p3);

        p1.getInsumoUtilizados().addAll(Arrays.asList(is1, is2));
        pratoRepository.save(p1);
        p2.getInsumoUtilizados().addAll(Arrays.asList(is3, is4));
        pratoRepository.save(p2);
        p3.getInsumoUtilizados().addAll(Arrays.asList(is5, is6,is7));
        pratoRepository.save(p3);
        Desperdicio d1 = new Desperdicio(null, sdf.parse("12/02/2024"), 3.0, "desperdicio na cozinha");
        Desperdicio d2 = new Desperdicio(null, sdf.parse("13/02/2024"), 3.0, "insumo vencido");
        Desperdicio d3 = new Desperdicio(null, sdf.parse("14/02/2024"), 1.5, "sobras de prato vegetariano");
        desperdicioRepository.saveAll(Arrays.asList(d1, d2, d3));

        d1.getPratos().addAll(Arrays.asList(p1, p3));
        d2.getInsumos().addAll(Arrays.asList(i1));
        d3.getPratos().addAll(Arrays.asList(p2));
        desperdicioRepository.saveAll(Arrays.asList(d1, d2, d3));
    }
}
