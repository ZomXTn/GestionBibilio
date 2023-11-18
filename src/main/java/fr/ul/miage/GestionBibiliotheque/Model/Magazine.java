package fr.ul.miage.GestionBibiliotheque.Model;

import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumPeriodicite;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("MAGAZINE")
public class Magazine {

    @NotBlank
    private int numVolume; 

    @NotBlank
	private EnumPeriodicite periodicite;
}
