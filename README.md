# API Voll.med

## 📚 Sobre o Projeto

Voll.med é uma API RESTful para uma clínica médica fictícia, desenvolvida como projeto prático do curso de formação Java e Spring Framework G8 - ONE (Oracle Next Education) da Alura.

O projeto implementa as funcionalidades essenciais para o gerenciamento de médicos, pacientes e agendamento de consultas, seguindo as melhores práticas de desenvolvimento, como arquitetura REST, validações e segurança.

---

## ✨ Funcionalidades

A API oferece os seguintes endpoints para gerenciamento da clínica:

### Autenticação

- `POST /login`: Autenticação de usuários para geração de token JWT.

### Médicos

- `POST /medicos`: Cadastrar um novo médico.
- `GET /medicos`: Listar médicos com paginação.
- `PUT /medicos`: Atualizar informações de um médico existente.
- `DELETE /medicos/{id}`: Excluir (desativar) um médico.
- `GET /medicos/{id}`: Detalhar um médico específico.

### Pacientes

- `POST /pacientes`: Cadastrar um novo paciente.
- `GET /pacientes`: Listar pacientes com paginação.
- `PUT /pacientes`: Atualizar informações de um paciente.
- `DELETE /pacientes/{id}`: Excluir (desativar) um paciente.
- `GET /pacientes/{id}`: Detalhar um paciente específico.

### Consultas

- `POST /consultas`: Agendar uma nova consulta com validações de regras de negócio.
- `DELETE /consultas`: Cancelar uma consulta existente.

---

## 🛠️ Tecnologias Utilizadas

- **Java 24**: Linguagem de programação principal.
- **Spring Boot 3**: Framework para criação da aplicação, incluindo:
    - Spring Web: Para construção de endpoints REST.
    - Spring Data JPA: Para persistência de dados e comunicação com o banco.
    - Spring Security: Para controle de autenticação e autorização.
- **Bean Validation**: Para validação dos dados de entrada.
- **MySQL**: Banco de dados relacional para armazenar os dados.
- **Flyway**: Ferramenta para versionamento e migração de banco de dados.
- **Lombok**: Para reduzir a verbosidade do código em classes de modelo (DTOs, Entidades).
- **JWT (JSON Web Token)**: Para a implementação da autenticação stateless.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Springdoc OpenAPI**: Para documentação automática da API com Swagger.

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a API localmente.

### Pré-requisitos

- Java 24 (ou superior)
- Maven
- MySQL

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

### Acesse o diretório da API

```bash
cd seu-repositorio/api
```

### Configure o Banco de Dados

1. Crie um banco de dados no MySQL chamado `vollmed_api`.
2. As credenciais padrão no arquivo `application.properties` são `root` para usuário e senha. Se as suas forem diferentes, altere o arquivo:

```properties
# api/src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost/vollmed_api
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

### Execute a aplicação com o Maven

```bash
mvn spring-boot:run
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

---

## 📖 Documentação da API

Após iniciar a aplicação, a documentação completa da API gerada pelo Springdoc estará disponível e pode ser acessada em seu navegador através da URL:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

A interface do Swagger UI permite visualizar e interagir com todos os endpoints da API.

---

## 🧑‍💻 Autor

Desenvolvido por Fernando Luiz Jasse Paulino Ramalho.

- LinkedIn: [https://www.linkedin.com/in/seu-linkedin/](https://www.linkedin.com/in/fernando-ramalho-programador/)
- GitHub: [https://github.com/seu-usuario](https://github.com/Atered01)
