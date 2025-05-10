package com.trabalho.trabalho.services;

import com.trabalho.trabalho.DTO.PratoDTO;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.repository.PratoRepository;
import com.trabalho.trabalho.services.exception.DataBaseException;
import com.trabalho.trabalho.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Prato insert(Prato obj) {
        return obj =  repository.save(obj);
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
