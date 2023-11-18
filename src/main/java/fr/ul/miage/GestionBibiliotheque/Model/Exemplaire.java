package fr.ul.miage.GestionBibiliotheque.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String state;
    @ManyToOne
    @JoinColumn(name = "oeuvre_id")
    private UUID oeuvre_id;
    

    public Exemplaire(int id, String state, UUID oeuvre_id){
        this.id = id;
        this.state = state;
        this.oeuvre_id = oeuvre_id;
    }
}
