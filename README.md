# Gerenciamento de Curso

Projeto Java para gerenciamento de cursos utilizando JDBC com PostgreSQL, rodando em Apache Tomcat.

---

## Tecnologias Utilizadas

- Java 22
- PostgreSQL
- Apache Tomcat 10.1.x
- JDBC (Java Database Connectivity)
- Servlet API

---

## Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado e configurado:

- [Java JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Apache Tomcat 10.1.x](https://tomcat.apache.org/download-10.cgi)
- IDE Java (IntelliJ IDEA, Eclipse, etc.)
- Driver JDBC do PostgreSQL (`postgresql-42.x.x.jar`)

---

## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `gerenciamentodecurso`.
2. Crie a tabela `curso` com a seguinte estrutura:
3. Crie um profile no PostgreSQL com username admin e a senha admin.

```sql
CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    carga_horaria INT NOT NULL
);
