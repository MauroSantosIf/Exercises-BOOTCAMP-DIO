# 📚 Bootcamp Manager - POO Implementation  

Um projeto simples em **Java** que simula um sistema de gerenciamento de Bootcamps, aplicando os **4 pilares da Programação Orientada a Objetos (POO)**:  

1. **Abstração**  
2. **Encapsulamento**  
3. **Herança**  
4. **Polimorfismo**  

---

## 🏗️ Estrutura do Projeto  

### 📂 Classes Principais  

| Classe          | Descrição                                                                                     | Pilar de POO Aplicado          |  
|-----------------|---------------------------------------------------------------------------------------------|-------------------------------|  
| `Conteudo`      | Classe **abstrata** que define atributos e métodos comuns para `Curso` e `Mentoria`.         | **Abstração**, **Herança**     |  
| `Curso`         | Herda de `Conteudo` e implementa `calcularXp()` com base na carga horária.                   | **Herança**, **Polimorfismo** |  
| `Mentoria`      | Herda de `Conteudo` e implementa `calcularXp()` com um valor fixo adicional (+20 XP).        | **Herança**, **Polimorfismo** |  
| `Bootcamp`      | Agrupa `Conteudos` (cursos/mentorias) e `Devs` inscritos. Usa `Set` para evitar duplicações. | **Encapsulamento**            |  
| `Dev`           | Representa um desenvolvedor, com métodos para se inscrever em bootcamps e progredir.         | **Encapsulamento**            |  

---

## ⚙️ Funcionalidades  

✅ **Cadastro de Cursos e Mentorias**  
- Cada `Curso` tem:  
  - Título, descrição, carga horária.  
  - XP calculado por: `XP_PADRAO * cargaHoraria`.  
- Cada `Mentoria` tem:  
  - Título, descrição, data.  
  - XP fixo: `XP_PADRAO + 20`.  

✅ **Gerenciamento de Bootcamps**  
- Um `Bootcamp` tem:  
  - Nome, descrição, datas (início e fim).  
  - Conjuntos (`Set`) de `Conteudos` e `Devs` inscritos.  

✅ **Interação de Devs**  
- Um `Dev` pode:  
  - Se inscrever em um `Bootcamp`.  
  - Marcar conteúdos como concluídos (`progredir()`).  
  - Calcular XP total (`calcularTotalXp()`).  

---

## 🛠️ Como Executar  

1. **Compile e execute `Main.java`**:  
   ```bash
   javac Main.java
   java Main
   ```
   - Saída esperada:  
     ```plaintext
     Mentoria - Seu Xp = 30.0, Título = Mentoria Java, Data = 2023-10-20, Descrição = descrição mentoria java
     Curso - seu Xp = 20.0, Carga Horária: 2, Título: Java Spring Boot, Descrição: Aqui, aprenderemos a mexer com Spring boot
     ```

---

## 📌 Pilares de POO no Projeto  

| Pilar         | Exemplo no Código                                                                 |  
|--------------|----------------------------------------------------------------------------------|  
| **Abstração** | `Conteudo` é uma classe abstrata com método `calcularXp()` a ser implementado.   |  
| **Encapsulamento** | Atributos privados (`private`) com getters/setters (ex: `Bootcamp.nome`).       |  
| **Herança**   | `Curso` e `Mentoria` herdam de `Conteudo` e implementam `calcularXp()`.         |  
| **Polimorfismo** | `calcularXp()` tem comportamentos diferentes em `Curso` e `Mentoria`.          |  

---

## 📝 Melhorias Futuras  

🔹 Implementar os métodos vazios de `Dev`:  
- `inscreverBootcamp()`: Adicionar o dev ao `Set<Dev>` do bootcamp.  
- `progredir()`: Mover conteúdos de `conteudosInscritos` para `conteudosConcluidos`.  
- `calcularTotalXp()`: Somar o XP de todos os `conteudosConcluidos`.  

🔹 Adicionar validações (ex: evitar cursos com carga horária negativa).  

---

## 🚀 Tecnologias  

- Java 11+  
- POO (Abstração, Encapsulamento, Herança, Polimorfismo)  

---

Feito por Mauro Santos. Desafio DIO. Licença MIT.