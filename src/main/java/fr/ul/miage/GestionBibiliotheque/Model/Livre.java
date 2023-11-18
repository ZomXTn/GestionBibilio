package fr.ul.miage.GestionBibiliotheque.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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

    @Pattern(regexp = "^(?:(?:\\d{9}[\\dXx])|\\d{13})$")
    @NotBlank
    private String isbn;

    @NotNull
    @Positive
    private int nbPages;
    
    @NotBlank
    private String auteur;
}
