package fr.ul.miage.GestionBibiliotheque.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("LIVRE")
public class Livre extends Oeuvre {

    private String isbn;
    private int nbPages;
    private String auteur;
}
