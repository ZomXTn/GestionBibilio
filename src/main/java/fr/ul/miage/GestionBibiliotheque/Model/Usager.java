package fr.ul.miage.GestionBibiliotheque.Model;

import fr.ul.miage.GestionBibiliotheque.Model.Emprunt;
import fr.ul.miage.GestionBibiliotheque.Model.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usager implements Serializable {

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;

    //Jointures
    @OneToMany(mappedBy = "usager", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Emprunt> listeEmprunts;
    @OneToMany(mappedBy = "usager", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Reservation> listeReservations;
}