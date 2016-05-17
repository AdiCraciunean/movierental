package ro.fortech.movierental.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Adi on 16.05.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDataDto implements Serializable {
    private Set<MovieDto> movies;
}
