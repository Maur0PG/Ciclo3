package co.usa.ciclo3.ciclo3.jar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.jar.model.Reservation;
import co.usa.ciclo3.ciclo3.jar.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> consulta = reservationRepository.getReservation(r.getIdReservation());
            if(consulta.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

}
