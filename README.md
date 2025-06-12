# Gerenciador de Eventos Acadêmicos - INF008 T1

## 1. Visão Geral do Projeto

O **Gerenciador de Eventos Acadêmicos** é uma aplicação de console em Java desenvolvida para o gerenciamento de eventos acadêmicos como **palestras, workshops, cursos e feiras**. 

O sistema foi desenvolvido com foco nos princípios da **Programação Orientada a Objetos (POO)** como **encapsulamento, herança e polimorfismo**. A interface é **interativa via terminal (CLI)**, e utiliza as bibliotecas externas **JFreeChart** e **Apache PDFBox**.

## 2. Funcionalidades Principais

### 🗓️ Gerenciamento de Eventos
- Registro de eventos dos tipos:
  - `Lecture` (Palestra)
  - `Workshop`
  - `Course`
  - `AcademicFair` (Feira)
- Definição de:
  - Título
  - Data
  - Local
  - Capacidade máxima
  - Descrição
- Atributos específicos por tipo:
  - Palestrante, carga horária, tema principal
- Estratégias de inscrição com o **Padrão Strategy** (online/presencial)

### 👥 Gerenciamento de Participantes
- Tipos suportados:
  - `Student` (matrícula)
  - `Professor` (departamento)
  - `Guest` (CPF)
- Registro e listagem de participantes

### 📋 Inscrição em Eventos
- Inscrição com controle de vagas
- Regras específicas por tipo (ex: só alunos em cursos)

### 🏆 Certificados
- Geração de **certificados em `.txt`** para participantes inscritos

### 📊 Relatórios Gráficos
- Geração de arquivos `.png` e `.pdf` com gráficos:
  - **Pizza:** Contagem de eventos por tipo
  - **Barras:** Número de participantes por evento

## 3. Bibliotecas Utilizadas

| Biblioteca        | Versão   | Finalidade                      | Licença                     |
|------------------|----------|----------------------------------|-----------------------------|
| JFreeChart        | 1.5.x    | Geração de gráficos              | LGPL v2.1 ou superior       |
| Apache PDFBox     | 2.0.x/3.0.x | Geração de PDF com gráficos      | Apache License 2.0          |
| Apache Maven      | 3.6.x+   | Build e gerenciamento de dependências | -                   |
| Java JDK          | 11+      | Execução do sistema              | GPL (OpenJDK)               |

## 4. Estrutura do Projeto (Pacotes)

```plaintext
br.edu.ifba.inf008.eventManager
├── App.java                               // Classe principal
├── model.events                           // Eventos (Event, Lecture, Course...)
├── model.participants                     // Participantes (Student, Guest...)
├── services                               
│   └── management                         // Gerenciamento de eventos e participantes
│   └── strategies                         // Estratégias de inscrição
├── controllers                            // (opcional - fluxo do sistema)
├── ui                                     // Menus interativos
├── utils                                  // Utilitários (ex: FormatterUtil)
```

## 5. Pré-requisitos

- **Java JDK 11+**
- **Apache Maven 3.6+**

## 6. Compilação do Projeto

Para compilar e empacotar o projeto em um **uber-JAR (fat-JAR)**:

```bash
mvn clean package
```

> O arquivo será gerado em: `target/event-manager-1.0-SNAPSHOT.jar`

## 7. Execução

### ✅ Para rodar o JAR no terminal:

```bash
java -jar target/event-manager-1.0-SNAPSHOT.jar
```

> **Certifique-se de que o `pom.xml` define corretamente o `mainClass`** no `maven-jar-plugin`.


## 8. Relatórios

Os relatórios são gerados nos seguintes formatos:

- **PNG:** gráficos simples (`events_by_type.png`)
- **PDF:** gráficos integrados em documentos (`participants_by_event.pdf`)

Salvos no mesmo diretório do projeto ou onde a aplicação estiver sendo executada.

## 9. Autor

**Carlos Alberto Santos Sales Junior**

> Projeto acadêmico desenvolvido para a disciplina **INF008 – Programação Orientada a Objetos**, no curso de **Análise e Desenvolvimento de Sistemas** do **IFBA**.
