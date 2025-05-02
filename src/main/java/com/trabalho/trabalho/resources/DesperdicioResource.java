package com.trabalho.trabalho.resources;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.services.DesperdicioService;
import com.trabalho.trabalho.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/desperdicios")
public class DesperdicioResource {
    @Autowired
    private DesperdicioService service;

    @GetMapping
    public ResponseEntity<List<Desperdicio>> findAll() {
        List<Desperdicio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Desperdicio> findById(@PathVariable Long id) {
        Desperdicio obj = service.findByiD(id);
        return ResponseEntity.ok().body(obj);
    }


}
