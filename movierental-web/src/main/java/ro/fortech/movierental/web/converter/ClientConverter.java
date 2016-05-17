package ro.fortech.movierental.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.fortech.movierental.core.model.Client;
import ro.fortech.movierental.web.dto.ClientDto;

/**
 * Created by Adi on 16.05.2016.
 */
@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {

    @Autowired
    private MovieConverter movieConverter;

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setAge(client.getAge());

        clientDto.setMovies(movieConverter.convertModelsToIDs(client.getMovies()));

        return clientDto;
    }
}
