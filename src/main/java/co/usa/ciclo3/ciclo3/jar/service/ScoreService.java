package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Score;
import co.usa.ciclo3.ciclo3.jar.repository.ScoreRepository;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score s){
        if(s.getId() == null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> consulta = scoreRepository.getScore(s.getId());
            if(consulta.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }

    public Score update(Score s) {

        if (s.getId() != null) {
            Optional<Score> consulta = scoreRepository.getScore(s.getId());
            if (!consulta.isEmpty()) {
                if (s.getCalification() != null) {
                    consulta.get().setCalification(s.getCalification());
                }
                if (s.getMensaje() != null) {
                    consulta.get().setMensaje(s.getMensaje());
                }

            }

            return scoreRepository.save(consulta.get());
        }

        return s;
    }

    public boolean deleteScore(int id){
        Optional<Score> consulta = scoreRepository.getScore(id);
        if (!consulta.isEmpty()) {
            scoreRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
  
}
