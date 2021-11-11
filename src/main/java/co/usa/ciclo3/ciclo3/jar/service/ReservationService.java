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

    public Reservation update(Reservation r) {

        if (r.getIdReservation() != null) {
            Optional<Reservation> consulta = reservationRepository.getReservation(r.getIdReservation());
            if (!consulta.isEmpty()) {
                if (r.getStartDate() != null) {
                    consulta.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    consulta.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    consulta.get().setStatus(r.getStatus());
                }
            }

            return reservationRepository.save(consulta.get());
        }

        return r;
    }

    public boolean deleteReservation(int id){
        Optional<Reservation> consulta = reservationRepository.getReservation(id);
        if (!consulta.isEmpty()) {
            reservationRepository.delete(consulta.get());
            return true;
        }
        return false;
    }


}
