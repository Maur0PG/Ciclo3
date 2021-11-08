package co.usa.ciclo3.ciclo3.jar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.jar.model.Reserva;
import co.usa.ciclo3.ciclo3.jar.repository.crud.ReservaCrudRepository;

@Repository
public class ReservaRepository {
    @Autowired
    ReservaCrudRepository reservaCrudRepository;
    
    public List<Reserva> getAll() {
        return (List<Reserva>) reservaCrudRepository.findAll();
    }

    public Optional<Reserva> getReserva(int id) {
        return reservaCrudRepository.findById(id);
    }

    public Reserva save(Reserva r) {
        return reservaCrudRepository.save(r);
    }
}
