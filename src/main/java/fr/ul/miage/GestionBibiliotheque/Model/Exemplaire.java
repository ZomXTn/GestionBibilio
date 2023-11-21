package fr.ul.miage.GestionBibiliotheque.Model;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumDisponibilite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Exemplaire implements Serializable {

    @Serial // pour la persistence entre les JVMs
    @Transient
    private static final long serialVersionUID = 135658465368461L;

    //Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private EnumDisponibilite disponibilite;

    //Jointures
    @ManyToOne
    @JoinColumn(name = "oeuvre_id")
    private Oeuvre oeuvre;
    @OneToMany(mappedBy = "exemplaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Emprunt> listeEmprunts;

}
