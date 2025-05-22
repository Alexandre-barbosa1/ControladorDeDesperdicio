package com.trabalho.trabalho.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Data
public class ParametroSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private Boolean ehIniciado;
}
