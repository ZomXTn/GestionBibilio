package fr.ul.miage.GestionBibiliotheque.Controller;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data // Crée les getters et setters
@NoArgsConstructor
@AllArgsConstructor
public class LivreInput {

    @Id
    @NotBlank
    private String isbn;
    @NotBlank
    private String titre;
    @NotBlank
    @Pattern(regexp="[0-9]+")
    private String nbPages;
    @NotBlank
    private String auteur;
    @NotBlank
    private String datePublication;

}
