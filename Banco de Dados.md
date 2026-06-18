# ObjectDB - Banco de Dados Orientado a Objetos

## Aluna
Mariana Araújo de Medeiros

## Banco de Dados Escolhido

O banco de dados escolhido foi o ObjectDB, um Sistema Gerenciador de Banco de Dados Orientado a Objetos (SGBDOO) desenvolvido para aplicações Java.

O ObjectDB permite armazenar objetos Java diretamente no banco de dados, sem a necessidade de convertê-los em tabelas relacionais. Ele suporta os principais conceitos da orientação a objetos, como herança, encapsulamento e relacionamentos entre classes, além de oferecer compatibilidade com a especificação JPA (Java Persistence API).

## Principais Características

- Banco de dados orientado a objetos.
- Armazenamento nativo de objetos Java.
- Suporte a JPA e JPQL.
- Fácil integração com aplicações Java.
- Persistência transparente de objetos.

## Instalação

### Pré-requisitos

- Java JDK 8 ou superior.
- IDE Java (Eclipse, IntelliJ IDEA ou VS Code).

### Download

1. Acesse o site oficial do ObjectDB:
   https://www.objectdb.com

2. Faça o download da versão mais recente.

3. Extraia o arquivo ZIP em uma pasta de sua preferência.

### Executando o Servidor

Abra um terminal na pasta do ObjectDB e execute:

```bash
objectdb/bin/server.sh
```

No Windows:

```cmd
objectdb\bin\server.bat
```

O servidor iniciará na porta padrão:

```text
6136
```

## Exemplo de Programa Java

### Classe Pessoa

```java
import javax.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    public Pessoa() {}

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
```

### Programa de Conexão

```java
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "objectdb://localhost/meubanco.odb");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Pessoa p = new Pessoa("Mariana");

        em.persist(p);

        em.getTransaction().commit();

        TypedQuery<Pessoa> query =
            em.createQuery(
                "SELECT p FROM Pessoa p",
                Pessoa.class);

        for (Pessoa pessoa : query.getResultList()) {
            System.out.println(pessoa.getNome());
        }

        em.close();
        emf.close();
    }
}
```

## Resultado Esperado

Ao executar o programa, o objeto será armazenado no banco de dados e posteriormente recuperado pela consulta:

```text
Mariana
```

## Aplicação Desenvolvida

Foi criada uma aplicação Java simples que realiza a conexão com o ObjectDB, insere um objeto da classe Pessoa e posteriormente consulta os registros armazenados.

## Referências

- https://www.objectdb.com
- https://www.objectdb.com/java/jpa
- https://db-engines.com/en/ranking/object+oriented+dbms
