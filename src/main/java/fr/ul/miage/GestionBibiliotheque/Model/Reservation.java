package fr.ul.miage.GestionBibiliotheque.Model;

import fr.ul.miage.GestionBibiliotheque.Model.Usager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("RESERVATION")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "usager_id")
    @JsonIgnore
    private Usager usager;
    @ManyToOne
    @JoinColumn(name = "oeuvre_id")
    private Oeuvre oeuvre;

}