package co.usa.ciclo3.ciclo3.jar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.jar.model.Client;
import co.usa.ciclo3.ciclo3.jar.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    
    // Metodo delete

    public void delete(Client c){
        clientCrudRepository.delete(c);
    }
}
