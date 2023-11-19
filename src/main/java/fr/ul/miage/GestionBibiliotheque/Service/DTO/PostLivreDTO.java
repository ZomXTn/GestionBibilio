package fr.ul.miage.GestionBibiliotheque.Service.DTO;

import java.util.ArrayList;
import java.util.Date;

import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class PostLivreDTO {

    @NotBlank
    @Pattern(regexp = "^(?:(?:\\d{9}[\\dXx])|\\d{13})$")
    private String isbn;
    @NotBlank
    private String titre;
    @NotBlank
    private String editeur;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date datePublication;
    @NotNull
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
        livre.setListeReservations(new ArrayList<>());
        return livre;
    }

}
