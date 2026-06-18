import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("objectdb:meubanco.odb");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Pessoa p = new Pessoa("Mariana");

        em.persist(p);

        em.getTransaction().commit();

        TypedQuery<Pessoa> consulta =
                em.createQuery(
                        "SELECT p FROM Pessoa p",
                        Pessoa.class);

        List<Pessoa> pessoas = consulta.getResultList();

        System.out.println("Pessoas cadastradas:");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getId() + " - " + pessoa.getNome());
        }

        em.close();
        emf.close();
    }
}
