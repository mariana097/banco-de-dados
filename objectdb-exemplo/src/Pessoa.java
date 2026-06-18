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

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
