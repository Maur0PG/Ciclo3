package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Reserva;
import co.usa.ciclo3.ciclo3.jar.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return reservaRepository.getAll();
    }

    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }

    public Reserva save(Reserva r){
        if(r.getId() == null){
            return reservaRepository.save(r);
        }else{
            Optional<Reserva> consulta = reservaRepository.getReserva(r.getId());
            if(consulta.isEmpty()){
                return reservaRepository.save(r);
            }else{
                return r;
            }
        }
    }

}
