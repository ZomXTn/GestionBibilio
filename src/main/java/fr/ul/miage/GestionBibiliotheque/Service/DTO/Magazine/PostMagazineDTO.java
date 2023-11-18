package fr.ul.miage.GestionBibiliotheque.Service.DTO.Magazine;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumPeriodicite;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostMagazineDTO {

    @NotBlank(message = "le titre ne doit pas etre vide")
    String titre;
    @NotBlank(message = "l'editeur ne doit pas etre vide")
    String editeur;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    Date datePublication;
    @Min(value = 1, message = "le numéro de volume doit etre au minimum 1")
    int numVolume;
    @Enumerated(EnumType.STRING)
    EnumPeriodicite periodicite;
    
    public Magazine toEntity(){
        Magazine magazine = new Magazine();
        return magazine;
    }

}
