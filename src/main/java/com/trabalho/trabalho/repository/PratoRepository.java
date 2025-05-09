package com.trabalho.trabalho.repository;

import com.trabalho.trabalho.entities.Desperdicio;
import com.trabalho.trabalho.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

}
