
---

```markdown
# 📱 iPhone - Modelagem UML de Funcionalidades

**Projeto em andamento**

Modelagem UML das funcionalidades básicas de um iPhone (Reprodutor Musical, Aparelho Telefônico e Navegador na Internet), seguindo boas práticas de design orientado a objetos.

## 🎯 Objetivo
Representar os papéis do iPhone através de:
- **Classes e interfaces** bem definidas.
- **Separação de responsabilidades**.
- **Diagramas UML** claros e modulares.

## 📂 Estrutura do Projeto
```plaintext
📦 src/
├── 📂 reprodutormusical
│   ├── IReprodutorMusical.java   # Interface
│   └── ReprodutorMusicalImpl.java # Implementação
├── 📂 aparelhotelefonico
│   ├── IAparelhoTelefonico.java
│   └── AparelhoTelefonicoImpl.java
├── 📂 navegadorinternet
│   ├── INavegadorInternet.java
│   └── NavegadorInternetImpl.java
└── iPhone.java                  # Classe principal
```

## 📊 Diagrama UML

<<<<<<< HEAD
<img src="lib\UML.png" width="1200">
=======
<img src="lib\uml.png" width="750">
>>>>>>> 5838724a3ac2c54cefc623af36b7dc6bf3cffff8

### Principais Componentes
| **Pacote**           | **Interface**           | **Responsabilidade**                     |
|-----------------------|-------------------------|------------------------------------------|
| `reprodutormusical`   | `IReprodutorMusical`    | Gerenciar música (tocar, pausar, etc.).  |
| `aparelhotelefonico`  | `IAparelhoTelefonico`   | Controlar chamadas e correio de voz.      |
| `navegadorinternet`   | `INavegadorInternet`    | Navegação web (abrir URL, nova aba, etc.).|


## 🤝 Como Contribuir
1. Faça um fork do projeto.
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`).
3. Commit suas mudanças (`git commit -m 'Adiciona X'`).
4. Push para a branch (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request.

## 📄 Finalidade do projeto

---
```

Projeto com intuito de exercitar pilares de programação orientada a objetos + interfaces. Além do mais, exercitar a criação de UMLs.
