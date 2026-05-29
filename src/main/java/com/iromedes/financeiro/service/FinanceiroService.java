package com.iromedes.financeiro.service;

import com.iromedes.financeiro.model.Transacao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class FinanceiroService {

    private final RestTemplate restTemplate = new RestTemplate();

    // 1. Lógica original de alocação
    public Map<String, Double> processarAlocacao(Transacao transacao) {
        double valor = transacao.getValor();

        return Map.of(
                "Necessidades (30%)", valor * 0.30,
                "Desejos (30%)", valor * 0.30,
                "Investimentos (40%)", valor * 0.40);
    }

    // 2. Busca o JSON bruto da API
    public String getCotacaoDolar() {
        String url = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
        return restTemplate.getForObject(url, String.class);
    }

    // 3. NOVO: Extrai apenas o valor numérico do Dólar
    public Double getValorDolarAtual() {
        try {
            String json = getCotacaoDolar();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            // Extrai o campo 'ask' dentro de 'USDBRL'
            return root.path("USDBRL").path("ask").asDouble();
        } catch (Exception e) {
            return 0.0; // Tratamento de erro caso a API falhe
        }
    }
}