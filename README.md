# AutoFinance Intelligence: Automação e Gestão Financeira

Este projeto é uma solução de **Backend para Automação Financeira**, focada em processamento inteligente de investimentos. Ele automatiza a aplicação de estratégias financeiras (reinvestimento 30/30/40) através da integração com APIs de dados e persistência robusta em banco de dados.

## 🎯 Objetivo da Automação
O sistema foi desenhado para eliminar a necessidade de input manual, consumindo dados externos em tempo real e aplicando regras de negócio automáticas para alocação de capital em:
- 30% Poupança
- 30% Dividendos
- 40% Day Trade

## 🛠 Tecnologias Principais
- **Java 21** & **Spring Boot 3**
- **MySQL** (Persistência de dados)
- **Hibernate/JPA** (ORM)
- **REST API Integration** (Automação de dados)

## 🏗 Arquitetura do Projeto
O projeto segue o padrão de design focado em escalabilidade:
* **Controller:** Camada de exposição da API.
* **Service:** O "cérebro" que executa as regras de automação.
* **Repository:** Camada de acesso aos dados.
* **DTO:** Estrutura para tráfego seguro de informações.

## 🚀 Como rodar
1. Configure sua variável de ambiente `DB_PASSWORD` para a conexão com o MySQL.
2. Certifique-se de que o banco de dados `financeiro_db` esteja ativo na porta `3307`.
3. Execute o comando: `./mvnw clean spring-boot:run`

## 📈 Status
[EM DESENVOLVIMENTO] - Atualmente implementando integração com APIs de mercado financeiro para automação de coleta de dados.