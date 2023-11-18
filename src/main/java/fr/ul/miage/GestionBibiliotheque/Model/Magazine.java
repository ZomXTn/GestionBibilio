package fr.ul.miage.GestionBibiliotheque.Model;

import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumPeriodicite;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("MAGAZINE")
public class Magazine extends Oeuvre{

    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{3}(\\d|X)$")
    private String issn; 

    @NotNull
    @Min(value = 1, message = "minimum 1")
    private int numVolume;
    @NotNull
    @Enumerated(EnumType.STRING)
	private EnumPeriodicite periodicite;
    @NotNull
    @OneToMany(mappedBy = "magazine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exemplaire> listeExemplaires = new ArrayList<>();
}
