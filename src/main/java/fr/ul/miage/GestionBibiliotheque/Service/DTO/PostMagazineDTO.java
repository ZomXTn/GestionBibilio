package fr.ul.miage.GestionBibiliotheque.Service.DTO;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumPeriodicite;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMagazineDTO {

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{3}(\\d|X)$")
    private String issn;
    @NotBlank
    private String titre;
    @NotBlank
    private String editeur;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date datePublication;
    @NotNull
    @Min(value = 1)
    private int numVolume;
    @NotNull
    @Enumerated(EnumType.STRING)
	private EnumPeriodicite periodicite;
    
    public Magazine toEntity(){
        Magazine magazine = new Magazine();
        magazine.setTitre(this.titre);
        magazine.setEditeur(this.editeur);
        magazine.setDatePublication(datePublication);
        magazine.setIssn(this.issn);
        magazine.setNumVolume(this.numVolume);
        magazine.setPeriodicite(this.periodicite);
        magazine.setListeExemplaires(new ArrayList<>());
        magazine.setListeReservations(new ArrayList<>());
        return magazine;
    }

}
