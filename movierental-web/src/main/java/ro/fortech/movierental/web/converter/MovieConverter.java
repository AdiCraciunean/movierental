package ro.fortech.movierental.web.converter;

import org.springframework.stereotype.Component;
import ro.fortech.movierental.core.model.Movie;
import ro.fortech.movierental.web.dto.MovieDto;

/**
 * Created by Adi on 16.05.2016.
 */
@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setGenre(movie.getGenre());
        movieDto.setPrice(movie.getPrice());

        return movieDto;
    }
}
