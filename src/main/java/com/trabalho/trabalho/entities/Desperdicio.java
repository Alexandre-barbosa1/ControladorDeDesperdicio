package com.trabalho.trabalho.entities;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Desperdicio {
    private Long id;
    private Date date;
    private Double quantidade;

    private Insumo insumo;
    public Desperdicio() {
    }
    public Desperdicio(Long id, Date date, Double quantidade, Insumo insumo) {
        this.id = id;
        this.date = date;
        this.quantidade = quantidade;
        this.insumo = insumo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Double getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    public Insumo getInsumo() {
        return insumo;
    }
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    
    
    
    

}
