# 📚 Sistema de Gerenciamento de Biblioteca

Este é um sistema simples de **empréstimo de livros** desenvolvido em Java. Ele permite o cadastro de usuários (alunos e professores), controle de livros e gerenciamento de empréstimos e devoluções com regras específicas.

🚀 Projeto desenvolvido como parte de aprendizado no **Bootcamp da DIO (Digital Innovation One)**, com foco em **orientação a objetos, abstração e regras de negócio**.

---

## 🛠️ Funcionalidades

- 📖 Cadastro de livros com controle de exemplares.
- 👨‍🎓 Usuários do tipo `Aluno` e `Professor`.
- 📅 Empréstimos com prazos diferentes:
  - 45 dias para alunos
  - 60 dias para professores
- ⛔ Limites por tipo de usuário:
  - Alunos: até 3 livros
  - Professores: até 5 livros
- 🔄 Controle de devolução e cálculo de atraso
- 💸 Multas personalizadas:
  - Alunos: R$1,00 por dia de atraso
  - Professores: R$0,50 por dia de atraso
- ✅ Validações de CPF, e-mail e telefone

---

## 🧩 Estrutura do Projeto

```bash
biblioteca/
├── model/
│ ├── Usuario.java
│ ├── Aluno.java
│ ├── Professor.java
│ ├── Livro.java
│ ├── Emprestimo.java
│ └── CalculadoraMulta.java
└── Main.java
```
## 🧪 Exemplo de Saída (Console)

```txt
Livro

ISBN:       1234567890
Título:     Algoritmos Avançados
Autor:      João da Silva
Disponível: 0 de 3
----------------------------

Empréstimo realizado com sucesso para Aluno: Ana Clara


📬 Devolução realizada com sucesso!
📆 Dias em atraso: 2
💰 Multa: R$ 2.00
```


# 📦 Tecnologias e Conceitos Utilizados
- Java 17+

- Programação Orientada a Objetos (OOP)

- Herança e Polimorfismo

- Validação de dados

- Tratamento de erros

- Collections (List)

- LocalDateTime e ChronoUnit (Java Time API)

- Function<T, R> (Interface funcional)

# 👨‍💻 Autor
Desenvolvido com 💻 por Mauro Santos

Bootcamp: DIO - Digital Innovation One
