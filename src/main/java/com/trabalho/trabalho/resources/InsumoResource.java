package com.trabalho.trabalho.resources;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.repository.InsumoRepository;
import com.trabalho.trabalho.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/insumos")
public class InsumoResource {
    @Autowired
    private InsumoService service;

    @GetMapping
    public ResponseEntity<List<Insumo>> findAll() {
        List<Insumo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Insumo> findById(@PathVariable Long id) {
        Insumo obj = service.findByiD(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Insumo> insert(@RequestBody Insumo obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
}
