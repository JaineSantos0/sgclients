<h1>Sistema de Gerenciamento de Clientes</h1>

<h2>Descrição</h2>
<p>
    Este é um sistema de gerenciamento de clientes que permite realizar operações básicas de CRUD 
    (Criar, Buscar, Atualizar, Deletar) em um banco de dados de clientes. A aplicação inclui a funcionalidade 
    de busca paginada de clientes, busca por ID, inserção de novos clientes, atualização e exclusão de clientes. 
    A aplicação segue uma arquitetura RESTful e utiliza o banco de dados H2 para armazenamento de dados.
</p>

<h2>Funcionalidades</h2>
<ul>
    <li>Busca Paginada de Clientes: Permite buscar clientes com paginação e ordenação.</li>
    <li>Busca de Cliente por ID: Recupera os detalhes de um cliente específico.</li>
    <li>Inserção de Cliente: Adiciona um novo cliente ao sistema.</li>
    <li>Atualização de Cliente: Atualiza as informações de um cliente existente.</li>
    <li>Deleção de Cliente: Remove um cliente do sistema.</li>
    <li>Validação de Dados: Verifica que o nome não pode ser vazio e que a data de nascimento não pode ser futura.</li>
    <li>Tratamento de Exceções: Gera respostas apropriadas para erros, como 404 para ID não encontrado e 422 para erros de validação.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li>Java 17</li>
    <li>Spring Boot 3</li>
    <li>H2 Database (para desenvolvimento e testes)</li>
    <li>JPA / Hibernate (para persistência de dados)</li>
    <li>Maven (para gerenciamento de dependências)</li>
</ul>

<h2>Requisitos</h2>
<ul>
    <li>JDK 17+</li>
    <li>Maven 3.8+</li>
</ul>

<h2>Configuração do Ambiente de Desenvolvimento</h2>
<p>Clone o repositório:</p>
<pre><code>git clone https://github.com/JaineSantos0/sgclients.git</code></pre>

<p>Compile e rode a aplicação:</p>
<pre><code>mvn clean install</code></pre>
<pre><code>mvn spring-boot:run</code></pre>

<h3>Acessando o Console H2:</h3>
<ul>
    <li><strong>URL:</strong> <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a></li>
    <li><strong>JDBC URL:</strong> jdbc:h2:mem:devdb</li>
    <li><strong>Username:</strong> sa</li>
    <li><strong>Password:</strong> (deixe vazio)</li>
</ul>

<h2>Endpoints</h2>

<h3>Client</h3>
<ul>
    <li><strong>POST /clients</strong> - Cria um novo cliente.</li>
    <li><strong>GET /clients</strong> - Retorna todos os clientes com paginação.</li>
    <li><strong>GET /clients/{id}</strong> - Retorna um cliente específico pelo ID.</li>
    <li><strong>PUT /clients/{id}</strong> - Atualiza um cliente existente.</li>
    <li><strong>DELETE /clients/{id}</strong> - Remove um cliente.</li>
</ul>

<h2>Estrutura do Projeto</h2>
<pre><code>
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── sgtarefas/
│   │   │       ├── controllers/
│   │   │       │   └── handlers/
│   │   │       ├── dto/
│   │   │       ├── entities/
│   │   │       ├── repositories/
│   │   │       ├── services/
│   │   │       │   └── exceptions/
│   │   │       └── SgtarefasApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── application-dev.properties
</code></pre>

<h2>Autor</h2>
<p>
    Nome do Autor: Jaine Santos<br>
    Email: <a href="mailto:jainejosiane@gmail.com">jainejosiane@gmail.com</a>
</p>
