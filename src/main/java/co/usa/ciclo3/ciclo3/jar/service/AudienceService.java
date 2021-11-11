package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Audience;
import co.usa.ciclo3.ciclo3.jar.repository.AudienceRepository;

@Service
public class AudienceService {
    @Autowired
    AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();

    }

    public Optional<Audience>getAudience(int id){
        return audienceRepository.getAudience(id);

    }

    public Audience save(Audience a){
        // verifica si es nulo
        if (a.getId()==null){
            return audienceRepository.save(a);

        }else{
            Optional<Audience> consulta=audienceRepository.getAudience(a.getId());

            if(consulta.isEmpty()){
                return audienceRepository.save(a);

            }else{
                return a;
            }

        }

    }

    public Audience update(Audience a){
        if(a.getId()!=null){
            Optional<Audience> consulta = audienceRepository.getAudience(a.getId());
            if(!consulta.isEmpty()){
                if(a.getName()!=null){
                   consulta.get().setName(a.getName());
                }
                if(a.getOwner()!=null){
                    consulta.get().setOwner(a.getOwner());
                }
                if(a.getCapacity()!=null){
                    consulta.get().setCapacity(a.getCapacity());
                 }
                 if(a.getDescription()!=null){
                    consulta.get().setDescription(a.getDescription());
                 }
                 return audienceRepository.save(consulta.get());
            }
        }
        return a;
    }

    public boolean deleteAudience(int id){
        Optional<Audience> consulta = audienceRepository.getAudience(id);
        if (!consulta.isEmpty()) {
            audienceRepository.delete(consulta.get());
            return true;
        }
        return false;
    }


}
