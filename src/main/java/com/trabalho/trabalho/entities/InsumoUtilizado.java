package com.trabalho.trabalho.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class InsumoUtilizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "insumo_tb")
    private Insumo insumo;
    @ManyToOne
    @JoinColumn(name = "prato_tb")
    @JsonIgnore
    private Prato prato;
    private Double quantidade;

    public InsumoUtilizado() {

    }

    public InsumoUtilizado(Long id, Insumo insumo, Prato prato, Double quantidade) {
        this.id = id;
        this.insumo = insumo;
        this.prato = prato;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
