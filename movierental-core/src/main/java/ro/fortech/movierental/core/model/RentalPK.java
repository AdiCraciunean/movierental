package ro.fortech.movierental.core.model;

import java.io.Serializable;

/**
 * Created by Adi on 16.05.2016.
 */
public class RentalPK implements Serializable {

    private Client client;

    private Movie movie;

    public RentalPK() {
    }

    public RentalPK(Client client, Movie movie) {
        this.client = client;
        this.movie = movie;
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

        RentalPK rentalPK = (RentalPK) o;

        if (!client.equals(rentalPK.client)) return false;
        return movie.equals(rentalPK.movie);

    }

    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + movie.hashCode();
        return result;
    }
}
