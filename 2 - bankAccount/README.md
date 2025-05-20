# Conta bancária

Projeto desenvolvido no Bootcamp Java - Claro da [ DIO ] ( https como exercícioda DIO como exercício prático de criação de uma Conta Bancária em Java .em Java.

Este projeto simula a criação de uma conta bancária simples via terminal, com entrada de dados do usuário e uma resposta personalizada.

## 🚀 Tecnologias utilizadas

Java 17

IDE: Visual Studio Code

Terminal / Scanner (entrada de dados)

Organização por pacotes ( applications, users)

JavaDoc para documentação de métodos

## 📁 Estrutura do projeto

```bash
bank-account/
│
├── README.md
└── src/
    ├── applications/
    │   └── ContaBanco.java      # Classe com atributos e toString personalizado
    │
    └── users/
        └── ContaTerminal.java   # Classe com método main e entrada de dados
```

## 🎯 Funcionalidade

Após rodar o programa, o usuário irá:

```bash
Insira seu nome

Informar o número da agência

Informar o número da conta

Informar o saldo inicial

O sistema exibirá a seguinte mensagem personalizada:

Olá Mauro, obrigado por criar uma conta em nosso banco, sua agência é 1234, conta 56789 e seu saldo 1000.00 já está disponível para saque.
```

## 📌 Como executar o projeto

Clonar este repositório:

```bash
git clone https://github.com/MauroSantosIf/bank-account.git
```

Compilar e executar:

javac users/ContaTerminal.java
java users.ContaTerminal

📚 Documentação
Este projeto contém JavaDocs nos métodos principais, explicando seu funcionamento e propósito.
Para gerar a documentação em HTML, use:

```bash
javadoc -d docs -sourcepath src users/*.java applications/*.java
```

A documentação será gerada na pasta docs/.

## 👨‍💻 Autor

Desenvolvido por Mauro Santos
