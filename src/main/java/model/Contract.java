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
    private LocalDate date;
    private int trajanjeUgovora;
    private BigDecimal plača;

    @ManyToMany(mappedBy = "contracts")
    private Set<Company> companies = new HashSet<>();

    @ManyToMany(mappedBy = "contracts")
    private Set<Person> persons = new HashSet<>();
}
