package ro.fortech.movierental.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.fortech.movierental.core.model.Movie;
import ro.fortech.movierental.core.service.MovieService;
import ro.fortech.movierental.web.RentalMediaType;
import ro.fortech.movierental.web.converter.MovieConverter;
import ro.fortech.movierental.web.dto.MoviesDataDto;

import java.util.List;

/**
 * Created by Adi on 16.05.2016.
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = RentalMediaType.API_JSON)
    public MoviesDataDto getMovies() {

        List<Movie> movies = movieService.findAll();

        return new MoviesDataDto(movieConverter.convertModelsToDtos(movies));
    }
}
