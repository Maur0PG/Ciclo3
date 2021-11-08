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

}
