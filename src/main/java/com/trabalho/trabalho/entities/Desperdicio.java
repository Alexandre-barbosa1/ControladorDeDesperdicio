package com.trabalho.trabalho.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_desperdicio")
public class Desperdicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private Double quantidade;
    private String descricao;
    @ManyToMany
    @JoinTable(
            name = "desperdicio_pratos",
            joinColumns = @JoinColumn(name = "desperdicio_id"),
            inverseJoinColumns = @JoinColumn(name = "pratos_id")
    )
    private List<Prato> pratos = new ArrayList<Prato>();

    public Desperdicio() {
    }

    public Desperdicio(Long id, String date, Double quantidade, String descricao) {
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

    public List<Prato> getPratos() {
        return pratos;

    }
    public String getDescricao() {
        return descricao;
    }

}
