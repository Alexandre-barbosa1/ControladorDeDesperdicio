package com.trabalho.trabalho.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_desperdicio")
public class Desperdicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Double quantidade;
    private String descricao;
    @ManyToMany
    @JoinTable(
            name = "desperdicio_pratos",
            joinColumns = @JoinColumn(name = "desperdicio_id"),
            inverseJoinColumns = @JoinColumn(name = "pratos_id")
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Prato> pratos = new ArrayList<Prato>();

    @ManyToMany
    @JoinTable(
            name = "desperdicio_insumos",
            joinColumns = @JoinColumn(name = "desperdicio_id"),
            inverseJoinColumns = @JoinColumn(name = "insumos_id")
    )
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Insumo> insumos = new ArrayList<Insumo>();

    public Desperdicio() {
    }

    public Desperdicio(Long id, Date date, Double quantidade, String descricao) {
        this.id = id;
        this.date = date;
        this.quantidade = quantidade;
        this.descricao = descricao;
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

    public List<Prato> getPratos() {
        return pratos;

    }

    public String getDescricao() {
        return descricao;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }
}
