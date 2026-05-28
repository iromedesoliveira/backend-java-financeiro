package com.iromedes.financeiro.service;

import com.iromedes.financeiro.model.Transacao;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class FinanceiroService {

    public Map<String, Double> processarAlocacao(Transacao transacao) {
        double valor = transacao.getValor();

        return Map.of(
                "Necessidades (30%)", valor * 0.30,
                "Desejos (30%)", valor * 0.30,
                "Investimentos (40%)", valor * 0.40);
    }
}