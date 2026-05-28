package com.iromedes.financeiro.repository;

import com.iromedes.financeiro.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // Este método permite buscar transações pelo tipo (Ex: "Day Trade")
    List<Transacao> findByTipo(String tipo);
}