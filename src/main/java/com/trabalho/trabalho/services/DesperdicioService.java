package com.trabalho.trabalho.services;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.DesperdicioRepository;
import com.trabalho.trabalho.services.exception.DataBaseException;
import com.trabalho.trabalho.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Desperdicio insert(Desperdicio obj) {
        return obj = repository.save(obj);

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
