package ro.fortech.movierental.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.fortech.movierental.core.model.Movie;
import ro.fortech.movierental.core.repository.MovieRepository;

import java.util.List;

/**
 * Created by Adi on 16.05.2016.
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    @Transactional
    public List<Movie> findAll() {
        List<Movie> movies = movieRepository.findAll();

        return movies;
    }
}
