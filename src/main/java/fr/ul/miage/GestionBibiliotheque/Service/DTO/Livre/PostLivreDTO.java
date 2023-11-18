package fr.ul.miage.GestionBibiliotheque.Service.DTO.Livre;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Crée les getters et setters
@AllArgsConstructor
public class PostLivreDTO {

    @NotBlank(message = "le titre ne doit pas etre vide")
    private String titre;
    @NotBlank(message = "l'editeur ne doit pas etre vide")
    private String editeur;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date datePublication;
    

}
