package com.trabalho.trabalho.repository;

import com.trabalho.trabalho.entities.ParametroSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroSistemaRepository extends JpaRepository<ParametroSistema, Long> {
    boolean existsByTitulo(String titulo);
}
