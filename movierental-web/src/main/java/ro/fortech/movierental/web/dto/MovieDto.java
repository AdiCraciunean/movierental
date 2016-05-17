package ro.fortech.movierental.web.dto;

import lombok.*;

/**
 * Created by Adi on 16.05.2016.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto extends BaseDto {
    private String title;
    private String genre;
    private Integer price;
}
