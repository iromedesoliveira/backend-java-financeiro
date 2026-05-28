package com.iromedes.financeiro.controller;

import com.iromedes.financeiro.model.Transacao;
import com.iromedes.financeiro.repository.TransacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Transacao> salvar(@Valid @RequestBody Transacao transacao) {
        return ResponseEntity.ok(repository.save(transacao));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}