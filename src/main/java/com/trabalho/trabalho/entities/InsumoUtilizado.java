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
    private Double quantidadeUsada;

    public InsumoUtilizado() {

    }

    public InsumoUtilizado(Long id, Double quantidade, Insumo insumo, Prato prato) {
        this.id = id;
        this.quantidadeUsada = quantidade;
        this.insumo = insumo;
        this.prato = prato;

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

    public Double getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(Double quantidadeUsada) {
        this.quantidadeUsada = quantidadeUsada;
    }
}
