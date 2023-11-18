package fr.ul.miage.GestionBibiliotheque.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_oeuvre", discriminatorType = DiscriminatorType.STRING)
public class Oeuvre {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

    @NotBlank
	private String titre;

    @NotBlank
    private String editeur;
    @OneToMany(mappedBy = "oeuvre", cascade = CascadeType.ALL, orphanRemoval = true)    
    private List<Exemplaire> listeExemplaires; 
    
    @NotNull
    private Date datePublication;

    public Oeuvre(String titre, String editeur, Date datePublication){
        this.titre = titre;
        this.listeExemplaires = new ArrayList<>();
        this.editeur = editeur;
        this.datePublication = datePublication;
    }

}
