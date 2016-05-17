package ro.fortech.movierental.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * Created by Adi on 16.05.2016.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientDto extends BaseDto {
    private String name;
    private Integer age;
    private Set<Long> movies;

    public ClientDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
