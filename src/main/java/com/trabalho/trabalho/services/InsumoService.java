package com.trabalho.trabalho.services;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.repository.InsumoRepository;
import com.trabalho.trabalho.services.exception.DataBaseException;
import com.trabalho.trabalho.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository repository;


    public List<Insumo> findAll() {
        return repository.findAll();
    }


    public Insumo findByiD(Long id) {
        Optional<Insumo> obj = repository.findById((long) id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Insumo insert(Insumo obj) {
       return  obj = repository.save(obj);
    }

    public void deleteByiD(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
}
