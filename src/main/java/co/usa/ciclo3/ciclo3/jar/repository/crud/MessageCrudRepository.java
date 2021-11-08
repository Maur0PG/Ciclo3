package co.usa.ciclo3.ciclo3.jar.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.ciclo3.ciclo3.jar.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
    
}
