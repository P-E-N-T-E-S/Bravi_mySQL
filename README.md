<p align="center">
  <img
    src="https://img.shields.io/badge/Status-Em%20desenvolvimento-green?style=flat-square"
    alt="Status"
  />
</p>

<p align="center">
  <img
    width="400"
    display="inline-block"
    src="https://assets.agilecdn.com.br/images/logo_bravi.png"
  />
</p>

<p align="center">
  <img
    src="https://img.shields.io/github/repo-size/P-E-N-T-E-S/Bravi_mySQL?style=flat"
    alt="Repository Size"
  />
  <img
    src="https://img.shields.io/github/languages/count/P-E-N-T-E-S/Bravi_mySQL?style=flat&logo=python"
    alt="Language Count"
  />
  <img
    src="https://img.shields.io/github/commit-activity/t/P-E-N-T-E-S/Bravi_mySQL?style=flat&logo=github"
    alt="Commit Activity"
  />
    <a href="LICENSE.md"
    ><img
      src="https://img.shields.io/github/license/P-E-N-T-E-S/Bravi_mySQL"
      alt="License"
  /></a>
</p>


Este repositório contém o projeto de banco de dados desenvolvido para a **Bravi Distribuidora**, uma empresa especializada na distribuição de produtos profissionais de higiene, limpeza, descartáveis, maquinários e Equipamentos de Proteção Individual (EPIs). Além disso, a Bravi possui uma linha específica de produtos sustentáveis, alinhada às tendências globais de consumo consciente.

## 👀 Objetivo

O objetivo deste projeto é modelar e implementar um sistema de banco de dados eficiente para gerenciar as operações da Bravi Distribuidora, otimizando o controle de estoque, fornecedores, clientes e pedidos.

## ⚙️ Funcionalidades do Banco de Dados

- **Gerenciamento de Produtos**: Cadastro de produtos de diferentes categorias (higiene, limpeza, descartáveis, maquinários, EPIs e produtos sustentáveis).
- **Controle de Estoque**: Monitora a quantidade de produtos disponíveis em estoque, alertando quando níveis críticos são atingidos.
- **Cadastro de Fornecedores**: Registra informações de fornecedores para manter o fluxo de produtos.
- **Cadastro de Clientes**: Armazena dados de clientes, facilitando o processo de venda e distribuição.
- **Gerenciamento de Pedidos**: Controle detalhado de pedidos de compra, incluindo status e histórico.

## 📪 Estrutura do Projeto

O projeto está dividido nas seguintes seções:

1. **Modelagem de Dados**: Diagrama Entidade-Relacionamento (ERD) que descreve as tabelas e suas relações.
2. **Scripts SQL**: Scripts para criação e manipulação do banco de dados.
3. **Procedures e Triggers**: Funções automatizadas para garantir integridade e eficiência no gerenciamento de dados.
4. **Consultas SQL**: Exemplos de consultas otimizadas para extração de dados úteis ao negócio.

## 🚀 Como Rodar

### 🛠️ Pré-requisitos
- ☕ **Java 21** ou superior
- ⚙️ JDK instalado
- 🗄️ **Banco de Dados MySQL** configurado e rodando localmente ou em um servidor remoto

### 📂 Clone a aplicação no GitHub
Primeiro, clone o repositório do projeto para o seu ambiente local:
👉 [Repositório no GitHub](https://github.com/P-E-N-T-E-S/Bravi_mySQL)

```bash
git clone <Url do repositório>
cd <diretório do projeto>
```

## 🛢️ Configurar o Banco de Dados
Você precisa de um banco de dados configurado para rodar a aplicação. Caso ainda não tenha configurado, siga os passos abaixo:

1. 📂 **Acesse a pasta `BDBravi`.**
   - Na pasta, você encontrará dois arquivos:
     - **`codigoBanco.sql`**: Execute este arquivo para criar a estrutura do banco de dados.
     - **`povoamentoBanco.sql`**: Execute este arquivo para inserir os dados iniciais e povoar as tabelas criadas.

## ▶️ Executando a Aplicação

### 🗒️ 1. Criando o Arquivo `.env`
Crie o arquivo `.env` na pasta `Bravi` (que contém o `src`) com o seguinte conteúdo:

```env
DATABASE_URL=jdbc:mysql://localhost:3306/BDBravi
DATABASE_USERNAME={Seu Usuário}
DATABASE_PASSWORD={Sua Senha}
```
### 💻 2. Rodando no Terminal

### 2.1 MacOS ou Linux
1. Certifique-se de que o terminal esteja na pasta `Bravi`.
2. Execute o comando para preparar o script:
   ```bash
   chmod +x mvnw
  
### Instale as dependências do projeto:
```bash
npm install
```

### Inicie a aplicação:
```bash
./mvnw spring-boot:run
```
### 🖥️ 3. Rodando no IntelliJ IDEA
Abra o projeto na IDE.
Clique no ícone de play para rodar a aplicação.
A IDE cuidará de compilar e executar automaticamente. Certifique-se de que o arquivo .env está na pasta correta para evitar erros.

### 🌐 Acessando a Aplicação
Abra o navegador e digite o seguinte endereço: 
👉 http://localhost:8080/login

### Login

Ao acessar o login, insira o **CPF** como nome de usuário e o **Nome** como a senha. Aqui estão alguns exemplos de login:

- **Usuário**: 44444444444, **Senha**: João Silva
- **Usuário**: 55555555555, **Senha**: Maria Oliveira
- **Usuário**: 66666666666, **Senha**: Carlos Souza
- **Usuário**: 77777777777, **Senha**: Ana Costa
- **Usuário**: 88888888888, **Senha**: Pedro Santos
- **Usuário**: 99999999999, **Senha**: Julia Martins


## 👩‍💻 TechSphere

<ul>
  <li>
    <a href="https://github.com/Thomazrlima">Thomaz Lima</a> - trl@cesar.school 📩
  </li>
  <li>
    <a href="https://github.com/Sofia-Saraiva">Sofia Saraiva</a> - spscl@cesar.school 📩
  </li>
</ul>

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Thomazrlima">
        <img src="https://avatars3.githubusercontent.com/Thomazrlima" width="100px;" alt="Foto de Thomaz"/><br>
        <sub>
          <b>Thomaz R. Lima</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Sofia-Saraiva">
        <img src="https://avatars.githubusercontent.com/Sofia-Saraiva" width="100px;" alt="Foto de Sofia"/><br>
        <sub>
          <b>Sofia Saraiva</b>
        </sub>
      </a>
    </td>
  </tr>
</table>


## License

[MIT](https://github.com/P-E-N-T-E-S/Bravi_mySQL/LICENSE)
