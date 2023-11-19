package fr.ul.miage.GestionBibiliotheque.Model;


import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumDisponibilite;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Exemplaire implements Serializable {

    @Serial // pour la persistence entre les JVMs
    @Transient
    private static final long serialVersionUID = 135658465368461L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    private EnumDisponibilite disponibilite;
    @ManyToOne
    @JoinColumn(name = "oeuvre_id")
    @JsonIgnore
    private Oeuvre oeuvre;
    
    public Exemplaire(EnumDisponibilite disponibilite, Oeuvre oeuvre){
        this.disponibilite = disponibilite;
        this.oeuvre = oeuvre;
    }
}
