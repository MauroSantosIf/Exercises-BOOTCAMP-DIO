# 📊 Banco Digital - Projeto de Estudo DIO

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

Projeto bancário desenvolvido para o bootcamp da Digital Innovation One (DIO), implementando conceitos fundamentais de POO em Java.

## 🏗 Estrutura Atual

### 📂 Pacotes Principais
```
br.com.bancoDigital/
├── conta/               # Lógica de contas bancárias
│   ├── Conta.java       # Classe abstrata
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   └── IConta.java      # Interface
├── model/
│   ├── Banco.java       # Entidade bancária
│   └── cliente/
│       └── Cliente.java # Entidade cliente
└── App.java             # Classe principal
```

## 🚀 Funcionalidades Implementadas
- **Sistema básico de contas** (Corrente e Poupança)
- **Operações financeiras**:
  - Saque
  - Depósito
  - Transferência entre contas
- **Gerenciamento de clientes**
- **Extrato bancário**

## 🔮 Próximas Implementações (To-Do)
- [ ] **Validações avançadas**:
  - Limite de saque diário
  - Taxas diferenciadas por tipo de conta
- [ ] **Novos tipos de conta**:
  - Conta Investimento
  - Conta Salário
- [ ] **Sistema de banco**:
  - Cadastro de agências
  - Relatórios gerenciais


## 🛠 Como Executar
1. Clone o repositório:
```bash
git clone https://github.com/MauroSantosIf/Exerc-cios---Bootcamp-Dio-Claro-.git
```
2. Importe no VS Code/Eclipse como projeto Java
3. Execute `App.java`

## 📚 Conceitos Aplicados
✔️ **Abstração** (Classes abstratas e interfaces)  
✔️ **Encapsulamento** (Atributos privados com getters/setters)  
✔️ **Herança** (Conta → ContaCorrente/ContaPoupanca)  
✔️ **Polimorfismo** (Métodos implementados diferentemente nas subclasses)  

## 🤝 Contribuição
Este é um projeto de estudo, mas sugestões são bem-vindas! Abra uma issue ou pull request.

## 📝 Licença
Projeto educacional sob licença MIT.