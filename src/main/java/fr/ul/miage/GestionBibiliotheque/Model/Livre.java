package fr.ul.miage.GestionBibiliotheque.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("LIVRE")
public class Livre implements Serializable {

    @Serial // pour la persistence entre les JVMs
    private static final long serialVersionUID = 135658465368461L;

    @Id
    @NotNull
    private String isbn;
    @NotNull
    private String titre;
    @NotNull
    private int nbPages;
    @NotNull
    private String auteur;
    @NotNull
    private String datePublication;
    @NotNull
    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exemplaire> listeExemplaires;

}
