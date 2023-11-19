package fr.ul.miage.GestionBibiliotheque.Service.DTO.Livre;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fr.ul.miage.GestionBibiliotheque.Model.Livre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostLivreDTO {

    @NotBlank(message = "le titre ne doit pas etre vide")
    private String titre;
    @NotBlank(message = "l'editeur ne doit pas etre vide")
    private String editeur;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date datePublication;
    @Pattern(regexp = "^(?:(?:\\d{9}[\\dXx])|\\d{13})$")
    @NotBlank
    private String isbn;
    @Positive
    private int nbPages;
    @NotBlank
    private String auteur;

    public Livre toEntity() {
        Livre livre = new Livre();
        livre.setTitre(this.titre);
        livre.setEditeur(this.editeur);
        livre.setDatePublication(this.datePublication);
        livre.setIsbn(this.isbn);
        livre.setNbPages(this.nbPages);
        livre.setAuteur(this.auteur); 
        livre.setListeExemplaires(new ArrayList<>());
        return livre;
    }

}
