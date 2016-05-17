package ro.fortech.movierental.core.service;

import ro.fortech.movierental.core.model.Movie;

import java.util.List;

/**
 * Created by Adi on 16.05.2016.
 */
public interface MovieService {
    List<Movie> findAll();
}
