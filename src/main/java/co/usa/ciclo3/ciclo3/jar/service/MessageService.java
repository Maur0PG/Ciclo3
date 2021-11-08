package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Message;
import co.usa.ciclo3.ciclo3.jar.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getId() == null){
            return messageRepository.save(m);
        }else{
            Optional<Message> consulta = messageRepository.getMessage(m.getId());
            if(consulta.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }

}
