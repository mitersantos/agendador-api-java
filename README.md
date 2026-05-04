# API Agendador de Horários 🚀

API REST desenvolvida em **Java** e **Spring Boot** para gerenciamento de agendamentos com validações de conflitos.

### 🛠️ Tecnologias
* **Backend**: Java 17, Spring Boot 3, Spring Data JPA.
* **Banco de Dados**: H2 (Desenvolvimento) com planos de migração para MySQL.
* **Ferramentas**: Maven, Git e Postman para testes de endpoints.

### 💡 Destaques Técnicos
* **Regras de Negócio**: Implementação de lógica para evitar agendamentos duplicados no mesmo horário.
* **Tratamento de Erros**: Uso de exceções personalizadas como `ConflitoHorarioException`.
* **Arquitetura**: Organização em camadas (Controller, Service, Repository).
