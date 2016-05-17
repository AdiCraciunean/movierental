package ro.fortech.movierental.core.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Adi on 16.05.2016.
 */
@Entity
@Table(name = "client")
public class Client extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rental> clientRentals = new HashSet<>();

    public Client() {
    }

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Rental> getClientRentals() {
        return clientRentals;
    }

    public void setClientRentals(Set<Rental> clientRentals) {
        this.clientRentals = clientRentals;
    }

    public Set<Movie> getMovies() {
        return Collections.unmodifiableSet(
                this.clientRentals.stream()
                        .map(cr -> cr.getMovie())
                        .collect(Collectors.toSet())
        );
    }

    public void addMovie(Movie movie) {
        Rental rental = new Rental();
        rental.setMovie(movie);
        rental.setClient(this);
        clientRentals.add(rental);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;
        if (!age.equals(client.age)) return false;
        return clientRentals != null ? clientRentals.equals(client.clientRentals) : client.clientRentals == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + (clientRentals != null ? clientRentals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", clientRentals=" + clientRentals +
                '}';
    }
}
