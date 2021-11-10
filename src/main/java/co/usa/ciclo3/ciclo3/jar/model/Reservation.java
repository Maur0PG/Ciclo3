package co.usa.ciclo3.ciclo3.jar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    // Ingreso de Relaciones

    @ManyToOne
    @JoinColumn(name = "audience")
    @JsonIgnoreProperties("reservations")
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Score> score;

    //Se Generan Getters and Setters

    public Integer getIdReservation() {
        return idReservation;
    }
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    //Getters and Setters externos


    public Audience getAudience() {
        return audience;
    }
    public void setAudience(Audience audience) {
        this.audience = audience;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Score> getScore() {
        return score;
    }
    public void setScore(List<Score> score) {
        this.score = score;
    }
}
