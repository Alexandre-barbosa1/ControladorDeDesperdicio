package com.trabalho.trabalho.services;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoService {
    @Autowired
    private PratoRepository repository;


    public List<Prato> findAll() {
        return repository.findAll();
    }


    public Prato findByiD(Long id) {
        Optional<Prato> obj = repository.findById((long) id);
        return obj.get();
    }

    public Prato insert(Prato obj) {
        return obj =  repository.save(obj);
    }


}
