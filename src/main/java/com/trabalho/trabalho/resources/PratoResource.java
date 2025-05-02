package com.trabalho.trabalho.resources;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.services.DesperdicioService;
import com.trabalho.trabalho.services.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pratos")
public class PratoResource {
    @Autowired
    private PratoService service;

    @GetMapping
    public ResponseEntity<List<Prato>> findAll() {
        List<Prato> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Prato> findById(@PathVariable Long id) {
        Prato obj = service.findByiD(id);
        return ResponseEntity.ok().body(obj);
    }


}
