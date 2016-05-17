package ro.fortech.movierental.web.converter;

import ro.fortech.movierental.core.model.BaseEntity;
import ro.fortech.movierental.web.dto.BaseDto;

/**
 * Created by Adi on 16.05.2016.
 */
public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);
}
