package fr.ul.miage.GestionBibiliotheque.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "usager_id")
    private Usager usager;
    @ManyToOne
    @JoinColumn(name = "oeuvre_id")
    private Oeuvre oeuvre;

}