package ro.fortech.movierental.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.movierental.core.model.Client;
import ro.fortech.movierental.core.service.ClientService;
import ro.fortech.movierental.web.RentalMediaType;
import ro.fortech.movierental.web.converter.ClientConverter;
import ro.fortech.movierental.web.dto.ClientDto;
import ro.fortech.movierental.web.dto.ClientsDataDto;
import ro.fortech.movierental.web.dto.EmptyJsonResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adi on 16.05.2016.
 */

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = RentalMediaType.API_JSON)
    public ClientsDataDto getClients() {
        List<Client> clients = clientService.findAll();

        Set<ClientDto> clientsDtos = clientConverter.convertModelsToDtos(clients);

        ClientsDataDto result = new ClientsDataDto(clientsDtos);

        return result;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST, consumes = RentalMediaType.API_JSON)
    public Map<String, ClientDto> createClient(@RequestBody final Map<String, ClientDto> clientDtoMap) {
        ClientDto clientDto = clientDtoMap.get("client");
        Client client = clientService.createClient(clientDto.getName(), clientDto.getAge());

        Map<String, ClientDto> result = new HashMap<>();

        result.put("client", clientConverter.convertModelToDto(client));

        return result;
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.PUT, consumes = RentalMediaType.API_JSON)
    public Map<String, ClientDto> updateClient(@PathVariable final Long clientId,
                                               @RequestBody final Map<String, ClientDto> clientDtoMap) {
        ClientDto clientDto = clientDtoMap.get("client");
        Client client = clientService.updateClient(clientId, clientDto.getName(), clientDto.getAge(), clientDto.getMovies());

        Map<String, ClientDto> result = new HashMap<>();
        result.put("client", clientConverter.convertModelToDto(client));

        return result;
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE, consumes = RentalMediaType.API_JSON)
    public ResponseEntity deleteClient(@PathVariable final Long clientId) {
        clientService.deleteClient(clientId);

        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }
}