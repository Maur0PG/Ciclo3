package co.usa.ciclo3.ciclo3.jar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.jar.model.Reservation;
import co.usa.ciclo3.ciclo3.jar.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    @Autowired
    ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation r) {
        return reservationCrudRepository.save(r);
    }

    // Metodo delete

    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }
}
