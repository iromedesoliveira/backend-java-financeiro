package com.iromedes.financeiro.controller;

import com.iromedes.financeiro.model.Transacao;
import com.iromedes.financeiro.repository.TransacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private TransacaoRepository repository;

    @GetMapping("/filtro") // A URL será .../api/financeiro/filtro?tipo=Day%20Trade
    public List<Transacao> listarPorTipo(@RequestParam String tipo) {
        return repository.findByTipo(tipo);
    }

    @PostMapping
    public Transacao salvar(@Valid @RequestBody Transacao transacao) {
        return repository.save(transacao);
    }
}