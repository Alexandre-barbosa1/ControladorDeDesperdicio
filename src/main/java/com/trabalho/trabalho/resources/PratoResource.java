package com.trabalho.trabalho.resources;

import com.trabalho.trabalho.DTO.PratoDTO;
import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Insumo;
import com.trabalho.trabalho.entities.Prato;
import com.trabalho.trabalho.services.DesperdicioService;
import com.trabalho.trabalho.services.PratoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<Prato> insert(@RequestBody PratoDTO obj){
        var prato = new Prato();
        BeanUtils.copyProperties(obj,prato);
        prato = service.insert(prato);
        return ResponseEntity.ok().body(prato);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.deleteByiD(id);
        return ResponseEntity.noContent().build();
    }



}
