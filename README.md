<div align="center">

# 🏭 Sistema de Gestão para Distribuidora Bravi

*Sistema completo de banco de dados relacional para otimização das operações da Bravi Distribuidora*

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-green?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge)

<p align="center">
  <img src="https://assets.agilecdn.com.br/images/logo_bravi.png" width="400" alt="Bravi Logo" />
</p>

<p align="center">
  <img src="https://img.shields.io/github/repo-size/P-E-N-T-E-S/Bravi_mySQL?style=flat-square" alt="Repository Size" />
  <img src="https://img.shields.io/github/languages/count/P-E-N-T-E-S/Bravi_mySQL?style=flat-square" alt="Language Count" />
  <img src="https://img.shields.io/github/commit-activity/t/P-E-N-T-E-S/Bravi_mySQL?style=flat-square" alt="Commit Activity" />
  <img src="https://img.shields.io/github/license/P-E-N-T-E-S/Bravi_mySQL?style=flat-square" alt="License" />
</p>

</div>

## 📋 Sobre o Projeto

Sistema de gestão empresarial desenvolvido para a **Bravi Distribuidora** com um banco de dados relacional robusto que gerencia:

- 👥 **Recursos Humanos** (Funcionários, Setores, Hierarquia)
- 📦 **Gestão de Produtos** e Categorias
- 🏢 **Cadastro de Fornecedores** e Clientes
- 💰 **Controle de Compras** e Fornecimentos
- 📊 **Gestão de Estoque** em tempo real
- 🧾 **Emissão de Notas** Fiscais automáticas
---

## 🏗️ Arquitetura do Banco de Dados

### 📊 Esquema Relacional

```mermaid
erDiagram
    Setor ||--o{ Funcionario : contém
    Setor ||--o{ Estoque : armazena
    Setor {
        int id PK
        string nome
    }
    
    Funcionario ||--o{ Usuario : possui
    Funcionario {
        string cpf PK
        string nome
        string cargo
        date data_nascimento
        string cpf_gerente FK
    }
    
    Categoria ||--o{ Produto : classifica
    Categoria {
        int id PK
        string nome
    }
    
    Produto ||--o{ Estoque : em_estoque
    Produto ||--o{ _Compra : vendido_em
    Produto ||--o{ _Fornece : fornecido_em
    Produto {
        int nsm PK
        string nome
        string descricao
    }
    
    Fornecedor ||--o{ _Fornece : fornece
    Fornecedor {
        string cnpj PK
        string nome
        string razao_social
    }
    
    Cliente ||--o{ _Compra : compra
    Cliente {
        string cnpj PK
        string nome
        string razao_social
    }
    
    _Compra ||--o{ Nota : gera_nota
    _Fornece ||--o{ Nota : gera_nota
```

### 🗃️ Estrutura de Tabelas

| **Tabela** | **Chave Primária** | **Descrição** |
|------------|-------------------|---------------|
| `Setor` | `id` AUTO_INCREMENT | Departamentos da empresa |
| `Funcionario` | `CPF` VARCHAR(14) | Cadastro de colaboradores |
| `Usuario` | `id` AUTO_INCREMENT | Sistema de autenticação |
| `Produto` | `NSM` INTEGER | Catálogo de produtos |
| `Categoria` | `id` AUTO_INCREMENT | Classificação de produtos |
| `Fornecedor` | `CNPJ` VARCHAR(20) | Parceiros comerciais |
| `Cliente` | `CNPJ` VARCHAR(20) | Base de clientes |
| `Estoque` | Composite (`fk_Setor_id`, `fk_Produto_NSM`) | Controle de inventário |

---

## ⚡ Triggers e Automatizações

### 🔄 Sistema de Triggers Implementado

| **Trigger** | **Evento** | **Ação** |
|-------------|------------|----------|
| `after_funcionario_insert` | INSERT em Funcionario | Cria usuário automaticamente |
| `after_compra_insert` | INSERT em _Compra | Atualiza estoque (-1) e gera nota |
| `after_fornece_insert` | INSERT em _Fornece | Atualiza estoque (+1) e gera nota |
| `after_produto_insert` | INSERT em Produto | Associa categoria automaticamente |

### 💡 Exemplo de Trigger

```sql
DELIMITER //
CREATE TRIGGER after_compra_insert
AFTER INSERT ON _Compra
FOR EACH ROW
BEGIN
    -- Atualiza estoque ou insere novo registro
    UPDATE Estoque SET qtd = qtd - 1 
    WHERE fk_Produto_NSM = NEW.fk_Produto_NSM;
    
    -- Gera nota fiscal automaticamente
    INSERT INTO Nota (fk_Compra_id, is_in, data) 
    VALUES (NEW.id, TRUE, NOW());
END //
DELIMITER ;
```

---

## 📈 Principais Funcionalidades

### 👥 Gestão de Recursos Humanos

| **Recurso** | **Implementação** | **Benefício** |
|-------------|-------------------|---------------|
| **Hierarquia Organizacional** | Auto-relacionamento em Funcionario | Gestão de subordinados |
| **Cadastro Automático de Usuários** | Trigger `after_funcionario_insert` | Redução de erros manuais |
| **Controle de Acessos** | Campo `isGerente` na tabela Usuario | Segurança granular |

### 📦 Gestão de Estoque Inteligente

| **Operação** | **Trigger** | **Resultado** |
|-------------|-------------|---------------|
| **Venda Realizada** | `after_compra_insert` | Estoque decrementado + Nota gerada |
| **Recebimento de Fornecedor** | `after_fornece_insert` | Estoque incrementado + Nota gerada |
| **Produto Novo** | `after_produto_insert` | Categoria associada automaticamente |

### 💰 Processos Comerciais

- **🎯 Fornecimento**: Tabela `_Fornece` com valores negociados
- **🛒 Compras**: Tabela `_Compra` com histórico de vendas
- **🧾 Notas Fiscais**: Geração automática via triggers
- **📊 Estoque**: Controle em tempo real por setor

---

## 🚀 Guia de Instalação

### 📋 Pré-requisitos

| **Componente** | **Versão** | **Download** |
|----------------|------------|--------------|
| **MySQL** | 8.0+ | [MySQL Community](https://dev.mysql.com/downloads/) |
| **Java JDK** | 21+ | [Oracle JDK](https://www.oracle.com/java/) |
| **Git** | 2.30+ | [Git SCM](https://git-scm.com/) |

### 🛠️ Configuração do Banco de Dados

#### 1. 📥 Clone do Repositório
```bash
git clone https://github.com/P-E-N-T-E-S/Bravi_mySQL.git
cd Bravi_mySQL
```

#### 2. 🗄️ Execução dos Scripts SQL
```bash
# Execute no MySQL Client ou Workbench
mysql -u root -p < BDBravi/codigoBanco.sql
mysql -u root -p < BDBravi/povoamentoBanco.sql
```

#### 3. ⚙️ Estrutura Criada
O script `codigoBanco.sql` criará:
- ✅ 11 tabelas normalizadas
- ✅ 4 triggers de automação
- ✅ Constraints de integridade referencial
- ✅ Índices primários e estrangeiros

### 🔧 Configuração da Aplicação

Crie o arquivo `.env` na pasta `Bravi`:

```env
# Configurações do Banco de Dados
DATABASE_URL=jdbc:mysql://localhost:3306/BDBravi
DATABASE_USERNAME=seu_usuario
DATABASE_PASSWORD=sua_senha

# Configurações da Aplicação Spring Boot
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=dev
```

### 🏃 Execução

**Terminal (Linux/Mac):**
```bash
cd Bravi
chmod +x mvnw
./mvnw clean install
./mvnw spring-boot:run
```

**Acesso:**
```url
http://localhost:8080/login
```

---

## 🔐 Sistema de Autenticação

### 👤 Credenciais Automáticas

| **CPF (Usuário)** | **Nome (Senha)** | **Cargo** | **isGerente** |
|-------------------|------------------|-----------|---------------|
| 44444444444 | João Silva | Gerente | TRUE |
| 55555555555 | Maria Oliveira | Vendedor | FALSE |
| 66666666666 | Carlos Souza | Vendedor | FALSE |

**💡 Dica:** As credenciais são criadas automaticamente via trigger quando um funcionário é inserido!

---

## 👥 Equipe de Desenvolvimento

<div align="center">

### 💻 Arquitetos de Banco de Dados

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Thomazrlima">
        <img src="https://avatars.githubusercontent.com/Thomazrlima" width="100px;" alt="Thomaz Lima"/><br>
        <sub><b>Thomaz R. Lima</b></sub><br>
        <sub>trl@cesar.school</sub><br>
        <sub>🗄️ Modelagem Relacional</sub><br>
        <sub>⚡ Triggers & Stored Procedures</sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Sofia-Saraiva">
        <img src="https://avatars.githubusercontent.com/Sofia-Saraiva" width="100px;" alt="Sofia Saraiva"/><br>
        <sub><b>Sofia Saraiva</b></sub><br>
        <sub>spscl@cesar.school</sub><br>
        <sub>🔍 Normalização</sub><br>
        <sub>📊 Consultas Otimizadas</sub>
      </a>
    </td>
  </tr>
</table>

</div>

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

<div align="center">

**🏭 Transformando operações distribuidoras através de um banco de dados robusto e inteligente**

*Desenvolvido com 💙 pela equipe P.E.N.T.E.S. para a Bravi Distribuidora*

</div>
