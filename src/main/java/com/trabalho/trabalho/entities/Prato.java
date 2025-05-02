package com.trabalho.trabalho.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_prato")
public class Prato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "prato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InsumoUtilizado> insumoUtilizados = new ArrayList<>();

    public Prato() {

    }

    public Prato(Long id, String name) {
        this.id = id;
        this.name = name;
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


    public List<InsumoUtilizado> getInsumoUtilizados() {
        return insumoUtilizados;
    }
}
