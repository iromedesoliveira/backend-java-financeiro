package com.iromedes.financeiro.repository;

import com.iromedes.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // Essa interface simples já te dá métodos como .save(), .findAll(),
    // .deleteById()
}