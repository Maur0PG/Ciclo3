package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Client;
import co.usa.ciclo3.ciclo3.jar.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> consulta = clientRepository.getClient(c.getIdClient());
            if (consulta.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }    

    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> consulta = clientRepository.getClient(c.getIdClient());
            if (!consulta.isEmpty()) {
                if (c.getName() != null) {
                    consulta.get().setName(c.getName());
                }
                if (c.getEmail() != null){
                    consulta.get().setEmail(c.getEmail());
                }
                if (c.getPassword() != null) {
                    consulta.get().setPassword(c.getPassword());
                }
                if (c.getAge() != null) {
                    consulta.get().setAge(c.getAge());
                }
            }

            return clientRepository.save(consulta.get());
        }

        return c;
    }

    public boolean deleteClient(int id){
        Optional<Client> consulta = clientRepository.getClient(id);
        if (!consulta.isEmpty()) {
            clientRepository.delete(consulta.get());
            return true;
        }
        return false;
    }



}
