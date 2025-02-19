# Catálogo de Receitas

## 📝 Descrição
Sistema de gerenciamento de receitas culinárias desenvolvido com Spring Boot. Esta aplicação permite aos usuários cadastrar, consultar, atualizar e deletar receitas, proporcionando uma maneira organizada de gerenciar suas receitas favoritas.

## 🛠️ Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Hibernate
- Spring Web

## 🔧 Funcionalidades
- Cadastro de receitas com ingredientes e modo de preparo
- Busca de receitas por nome, categoria ou ingredientes
- Atualização de receitas existentes
- Remoção de receitas
- Listagem de todas as receitas cadastradas
- Categorização de receitas

## 💻 Pré-requisitos
- Java JDK 21 ou superior
- Maven
- PostgreSQL

## 🗄️ Estrutura do Projeto
```

catalogo-receitas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           └── receitas/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               ├── controller/
│   │   │               └── CatalogoReceitasApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## �� Endpoints da API
- `GET /api/receitas` - Lista todas as receitas
- `GET /api/receitas/{id}` - Busca uma receita específica
- `POST /api/receitas` - Cadastra uma nova receita
- `PUT /api/receitas/{id}` - Atualiza uma receita existente
- `DELETE /api/receitas/{id}` - Remove uma receita
