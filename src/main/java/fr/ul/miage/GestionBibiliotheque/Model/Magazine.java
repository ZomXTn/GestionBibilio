package fr.ul.miage.GestionBibiliotheque.Model;

import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumPeriodicite;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("MAGAZINE")
public class Magazine implements Serializable {

    @Id
    @NotNull
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
