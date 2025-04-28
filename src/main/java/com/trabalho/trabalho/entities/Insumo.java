package com.trabalho.trabalho.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Insumo {
    private Long id;
    private String name;
    private Double unidade;
    @OneToMany
    private List <Desperdicio> list = new ArrayList<>();
    
    public Insumo(){

    }
    public Insumo(Long id, String name, Double unidade) {
        this.id = id;
        this.name = name;
        this.unidade = unidade;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getUnidade() {
        return unidade;
    }
    public void setUnidade(Double unidade) {
        this.unidade = unidade;
    }
    public List<Desperdicio> getList() {
        return list;
    }

    

    

    

}
