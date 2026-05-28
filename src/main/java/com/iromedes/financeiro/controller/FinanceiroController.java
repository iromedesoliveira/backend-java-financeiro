package com.iromedes.financeiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @GetMapping
    public String status() {
        return "API de Gestão Financeira do Iromedes ativa!";
    }
}