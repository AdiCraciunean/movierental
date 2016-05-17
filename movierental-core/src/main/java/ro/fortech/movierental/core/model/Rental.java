package ro.fortech.movierental.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adi on 16.05.2016.
 */

@Entity
@Table(name = "rental")
@IdClass(RentalPK.class)
public class Rental implements Serializable {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Rental() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (!client.equals(rental.client)) return false;
        return movie.equals(rental.movie);

    }

    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + movie.hashCode();
        return result;
    }
}
