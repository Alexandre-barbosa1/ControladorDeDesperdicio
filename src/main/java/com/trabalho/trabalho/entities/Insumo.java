package com.trabalho.trabalho.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_insumo")
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double estoque;

    @JsonIgnore
    @ManyToMany(mappedBy = "insumos")
    private List<Desperdicio> desperdicios = new ArrayList<>();
    @JsonIgnore
    @OneToMany  @JoinColumn(name = "insumo_tb")
    private List<InsumoUtilizado> insumosUtilizados = new ArrayList<>();

    public Insumo() {

    }

    public Insumo(Long id, String name, Double unidade) {
        this.id = id;
        this.name = name;
        this.estoque = unidade;
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

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public List<Desperdicio> getDesperdicios() {
        return desperdicios;
    }

    public List<InsumoUtilizado> getInsumosUtilizados() {
        return insumosUtilizados;
    }
}
