package ro.fortech.movierental.core.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Adi on 16.05.2016.
 */
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity<Long> {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "price", nullable = false)
    private Integer price;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rental> clientRentals = new HashSet<>();

    public Movie() {
    }

    public Movie(String title, String genre, Integer price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Rental> getClientRentals() {
        return clientRentals;
    }

    public void setClientRentals(Set<Rental> clientRentals) {
        this.clientRentals = clientRentals;
    }


    public Set<Client> getClients() {
        return Collections.unmodifiableSet(
                clientRentals.stream()
                        .map(cr -> cr.getClient())
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!title.equals(movie.title)) return false;
        if (!genre.equals(movie.genre)) return false;
        if (!price.equals(movie.price)) return false;
        return clientRentals != null ? clientRentals.equals(movie.clientRentals) : movie.clientRentals == null;

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (clientRentals != null ? clientRentals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("genre", genre)
                .append("price", price)
                .toString();
    }
}
