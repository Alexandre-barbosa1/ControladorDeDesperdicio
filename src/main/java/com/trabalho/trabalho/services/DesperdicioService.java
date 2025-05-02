package com.trabalho.trabalho.services;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesperdicioService {
    @Autowired
    private DesperdicioRepository repository;


    public List<Desperdicio> findAll() {
        return repository.findAll();
    }

    public Desperdicio findByiD(Long id) {
        Optional<Desperdicio> obj = repository.findById((long) id);
        return obj.get();
    }


}
