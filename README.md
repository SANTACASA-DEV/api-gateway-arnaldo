# API Gateway - Santa Casa

Este projeto é uma **API Gateway** desenvolvida em **Java 21**, utilizando **Spring Boot** e **Maven**, que atua como o "porteiro" de todos os serviços desenvolvidos internamente para o ecossistema de microserviços da Santa Casa.

A API Gateway tem como objetivo centralizar, gerenciar e rotear todas as requisições para os microsserviços internos, garantindo maior **segurança, escalabilidade e organização** na comunicação entre aplicações.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- **Maven**
- **Spring Web** → Criação de APIs REST
- **Spring Data JPA** → Persistência e integração com banco de dados
- **Spring Validation** → Validação de dados de entrada
- **Spring AMQP (RabbitMQ)** → Comunicação assíncrona entre serviços
- **PostgreSQL (via Docker)** → Banco de dados relacional utilizado no ambiente de desenvolvimento
- **Jackson** → Serialização/Desserialização de objetos JSON
- **Lombok** → Redução de código boilerplate
- **DevTools** → Hot reload em ambiente de desenvolvimento
- **JUnit/Mockito** → Testes automatizados

---

## 📦 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/br/com/santacasa/api_gateway   → Código fonte principal
 │   └── resources/                         → Configurações (application.properties)
 └── test/                                  → Testes unitários e de integração
```

---

## ⚙️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/sac-microsservico-api-gateway.git
   cd sac-microsservico-api-gateway
   ```

2. Suba os containers do banco de dados (PostgreSQL) e demais serviços com Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. Compile e execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a aplicação no navegador:
   ```
   http://localhost:8080
   ```

---

## 📖 Documentação de Referência

- [Documentação oficial do Maven](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/3.5.5/maven-plugin)
- [Spring Web](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html)
- [Spring Data JPA](https://docs.spring.io/spring-boot/3.5.5/reference/data/sql.html#data.sql.jpa-and-spring-data)
- [Spring AMQP (RabbitMQ)](https://docs.spring.io/spring-boot/3.5.5/reference/messaging/amqp.html)
- [PostgreSQL Docker Image](https://hub.docker.com/_/postgres)

---

## ✨ Observações

- O pacote base foi ajustado de `br.com.santacasa.api-gateway` para `br.com.santacasa.api_gateway` por compatibilidade de nomes em Java.
- Caso o projeto utilize credenciais sensíveis (como banco de dados em produção ou mensageria), recomenda-se usar **variáveis de ambiente** ou arquivos externos de configuração ao invés de versionar no Git.

---

## 👨‍💻 Autor

Projeto desenvolvido por **Santa Casa** no contexto da arquitetura de **microserviços**.

