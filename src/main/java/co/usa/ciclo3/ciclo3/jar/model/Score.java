package co.usa.ciclo3.ciclo3.jar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer Calification;
    private Integer Mensaje;

    // Ingreso de relaciones

    @ManyToOne
    @JoinColumn(name = "reserva")
    @JsonIgnoreProperties("scores")
    private Reserva reserva;


    //Se Generan Getters and Setters
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCalification() {
        return Calification;
    }
    public void setCalification(Integer calification) {
        Calification = calification;
    }
    public Integer getMensaje() {
        return Mensaje;
    }
    public void setMensaje(Integer mensaje) {
        Mensaje = mensaje;
    }

    //Getters and Setters externos

    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}
