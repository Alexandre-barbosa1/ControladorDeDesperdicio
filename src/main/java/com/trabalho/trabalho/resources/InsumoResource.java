package com.trabalho.trabalho.resources;

import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.InsumoRepository;
import com.trabalho.trabalho.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/insumos")
public class InsumoResource {
    @Autowired
    private InsumoService service;

    @GetMapping
    public ResponseEntity<List<Insumo>> findAll() {
        List<Insumo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }




}
