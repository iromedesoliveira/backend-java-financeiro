package com.iromedes.financeiro.service;

import com.iromedes.financeiro.model.Transacao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class FinanceiroService {

    private final RestTemplate restTemplate = new RestTemplate();

    // Lógica original de alocação
    public Map<String, Double> processarAlocacao(Transacao transacao) {
        double valor = transacao.getValor();

        return Map.of(
                "Necessidades (30%)", valor * 0.30,
                "Desejos (30%)", valor * 0.30,
                "Investimentos (40%)", valor * 0.40);
    }

    // Nova automação de integração
    public String getCotacaoDolar() {
        String url = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
        return restTemplate.getForObject(url, String.class);
    }
}