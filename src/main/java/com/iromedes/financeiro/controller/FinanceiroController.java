package com.iromedes.financeiro.controller;

import com.iromedes.financeiro.model.Transacao;
import com.iromedes.financeiro.repository.TransacaoRepository;
import com.iromedes.financeiro.service.FinanceiroService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping("/filtro")
    public List<Transacao> listarPorTipo(@RequestParam String tipo) {
        return repository.findByTipo(tipo);
    }

    // --- NOVA ROTA DE AUTOMAÇÃO ---
    @GetMapping("/cotacao")
    public String obterCotacao() {
        return financeiroService.getCotacaoDolar();
    }
    // ------------------------------

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody Transacao transacao) {
        Transacao transacaoSalva = repository.save(transacao);
        Map<String, Double> alocacao = financeiroService.processarAlocacao(transacaoSalva);

        return ResponseEntity.ok(Map.of(
                "transacao", transacaoSalva,
                "alocacao", alocacao));
    }
}