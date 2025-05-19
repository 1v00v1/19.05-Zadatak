import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Company;
import model.Contract;
import model.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Person p1 = new Person("Pero");
        Person p2 = new Person("Josip");
        Person p3 = new Person("Maja");
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        Company c1 = new Company("Google");
        Company c2 = new Company("Amazon");
        em.persist(c1);
        em.persist(c2);

        Contract co1 = new Contract();
        co1.getCompanies().add(c1);
        co1.getCompanies().add(c2);
        co1.getPersons().add(p1);
        co1.getPersons().add(p2);
        co1.getPersons().add(p3);

        em.persist(co1);
        List<Contract> contracts = em.createQuery("select c from Contract c", Contract.class).getResultList();
        for (Contract c : contracts){
            System.out.println("Osobe:");
            for (Person p : c.getPersons()){
                System.out.println(p.getName());
            }
            System.out.println("Kompanije:");
            for (Company com : c.getCompanies()){
                System.out.println(com.getName());
            }

        }

tx.commit();
em.close();
emf.close();
    }
}
