package com.trabalho.trabalho.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Desperdicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Double quantidade;
    @OneToMany
    private List<Insumo> insumos = new ArrayList<Insumo>();

    public Desperdicio() {
    }

    public Desperdicio(Long id, String date, Double quantidade) {
        this.id = id;
        this.date = date;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }
}
