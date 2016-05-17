package ro.fortech.movierental.core.service;

import ro.fortech.movierental.core.model.Client;

import java.util.List;
import java.util.Set;

/**
 * Created by Adi on 16.05.2016.
 */
public interface ClientService {
    List<Client> findAll();

    Client createClient(String name, Integer age);

    Client updateClient(Long clientId, String name, Integer age, Set<Long> movies);

    void deleteClient(Long clientId);
}
