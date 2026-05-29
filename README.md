# Backend Java Financeiro (API de Automação Financeira)

## 🚀 Sobre o Projeto
Este projeto foi desenvolvido como uma solução robusta para o gerenciamento de finanças pessoais, focando em automação e integração de dados. O sistema vai além de um CRUD tradicional, oferecendo uma camada de inteligência que processa transações e realiza conversões de moeda em tempo real via integração com APIs externas.



## 🛠 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3.4.0**
* **Spring Data JPA & Hibernate**
* **MySQL**
* **Jackson (Data Processing)**
* **RestTemplate (Integração de APIs)**

## ⚙️ Funcionalidades de Automação
* **Regra de Negócio 30/30/40:** O sistema processa automaticamente a alocação de qualquer transação registrada:
    * 30% Necessidades
    * 30% Desejos
    * 40% Investimentos
* **Integração em Tempo Real:** Consumo da API AwesomeAPI para cotação atualizada do Dólar (USDBRL).
* **Conversão Inteligente:** Endpoint de processamento que converte valores de Reais para Dólares utilizando taxas em tempo real.

## 🔗 Endpoints Principais
* `POST /api/financeiro`: Registra uma nova transação e retorna a alocação automática.
* `GET /api/financeiro/cotacao`: Retorna a cotação atual do dólar integrada.
* `GET /api/financeiro/converter/{valor}`: Realiza a conversão de moeda processada pelo backend.

## 💡 Por que este projeto?
Este projeto demonstra minha capacidade de separar responsabilidades, tratar dados externos com resiliência e resolver problemas reais de automação de lógica financeira.