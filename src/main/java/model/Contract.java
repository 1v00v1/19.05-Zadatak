package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate date ;
    private int trajanjeUgovora;
    private BigDecimal plača;

    @ManyToMany(mappedBy = "contracts")
    private Set<Company> companies = new HashSet<>();

    @ManyToMany(mappedBy = "contracts")
    private Set<Person> persons = new HashSet<>();

    public Contract() {

        this.plača = BigDecimal.valueOf(2022.22);
        this.trajanjeUgovora = 2;
        this.date = LocalDate.now();
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public BigDecimal getPlača() {
        return plača;
    }

    public void setPlača(BigDecimal plača) {
        this.plača = plača;
    }

    public int getTrajanjeUgovora() {
        return trajanjeUgovora;
    }

    public void setTrajanjeUgovora(int trajanjeUgovora) {
        this.trajanjeUgovora = trajanjeUgovora;
    }
}
