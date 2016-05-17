package ro.fortech.movierental.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.fortech.movierental.core.model.Client;
import ro.fortech.movierental.core.model.Movie;
import ro.fortech.movierental.core.repository.ClientRepository;
import ro.fortech.movierental.core.repository.MovieRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Adi on 16.05.2016.
 */

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client createClient(String name, Integer age) {
        Client client = new Client(name, age);

        Client cl = clientRepository.save(client);

        return cl;
    }

    @Override
    @Transactional
    public Client updateClient(Long clientId, String name, Integer age, Set<Long> movies) {
        Client client = clientRepository.findOne(clientId);
        client.setName(name);
        client.setAge(age);

        client.getMovies().stream()
                .map(m -> m.getId())
                .forEach(id -> movies.remove(id));

        List<Movie> movieList = movieRepository.findAll(movies);
        movieList.stream()
                .forEach(m -> client.addMovie(m));

        return client;
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.delete(clientId);
    }
}
