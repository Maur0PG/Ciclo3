package co.usa.ciclo3.ciclo3.jar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.jar.model.Message;
import co.usa.ciclo3.ciclo3.jar.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    @Autowired
    MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return(List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message m){
        return messageCrudRepository.save(m);
    }

    // Metodo delete

    public void delete(Message m){
        messageCrudRepository.delete(m);
    }
}
