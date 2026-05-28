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

    @Autowired // Adicionamos esta anotação para o Spring injetar o serviço
    private FinanceiroService financeiroService;

    @GetMapping("/filtro")
    public List<Transacao> listarPorTipo(@RequestParam String tipo) {
        return repository.findByTipo(tipo);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody Transacao transacao) {
        // 1. Salva no banco
        Transacao transacaoSalva = repository.save(transacao);

        // 2. Calcula a alocação 30/30/40 usando o serviço
        Map<String, Double> alocacao = financeiroService.processarAlocacao(transacaoSalva);

        // 3. Retorna tanto o objeto salvo quanto o cálculo
        return ResponseEntity.ok(Map.of(
                "transacao", transacaoSalva,
                "alocacao", alocacao));
    }

    // O método @ExceptionHandler foi removido daqui porque
    // ele já está no seu GlobalExceptionHandler.java!
}