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
}
