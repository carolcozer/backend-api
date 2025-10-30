# API de Gerenciamento de Tarefas
API RESTful desenvolvida em Java com Spring Boot para gerenciamento de tarefas, permitindo operações completas de CRUD (Create, Read, Update, Delete).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**
- **Hibernate**
- **Postman** 

## Funcionalidades

- ✅ **Criar tarefa** - Cadastro de novas tarefas
- ✅ **Listar todas as tarefas** - Consulta completa do cadastro
- ✅ **Buscar tarefa por ID** - Consulta de tarefa específica
- ✅ **Atualizar tarefa** - Edição de tarefas existentes
- ✅ **Excluir tarefa** - Remoção de tarefas do sistema

## Estrutura do Projeto

```
tarefas-api/
├── src/main/java/com/example/tarefas/
│   ├── TarefasApplication.java          # Classe principal
│   ├── controller/TarefaController.java # Endpoints REST
│   ├── model/Tarefa.java               # Entidade JPA
│   ├── repository/TarefaRepository.java # Interface JpaRepository
│   └── service/TarefaService.java       # Lógica de negócio
├── src/main/resources/
│   └── application.properties          # Configurações
└── pom.xml                            # Dependências Maven
```

## Endpoints da API

### Base URL: `http://localhost:8080/api/tarefas`

| Método | Endpoint | Descrição | Status de Sucesso |
|--------|----------|-----------|-------------------|
| **GET** | `/` | Lista todas as tarefas | 200 OK |
| **GET** | `/{id}` | Busca tarefa por ID | 200 OK |
| **POST** | `/` | Cria nova tarefa | 201 Created |
| **PUT** | `/{id}` | Atualiza tarefa existente | 200 OK |
| **DELETE** | `/{id}` | Remove tarefa | 204 No Content |

## Configuração e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/carolcozer/backend-api
cd tarefas-api
```

### 2. Configure o banco de dados
```sql
CREATE DATABASE tarefas_db;
```

### 3. Configure as credenciais
Edite `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefas_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 4. Execute a aplicação
```bash
mvn spring-boot:run
```
