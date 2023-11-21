package fr.ul.miage.GestionBibiliotheque.Service.DTO;

import fr.ul.miage.GestionBibiliotheque.Model.Usager;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUsagerDTO {

        @NotBlank
        @Email(message = "Format email invalide")
        private String email;
        @NotBlank
        private String nom;
        @NotBlank
        private String prenom;
        @NotBlank
        private String adresse;

        public Usager toEntity() {
            Usager usager = new Usager();
            usager.setEmail(this.email);
            usager.setNom(this.nom);
            usager.setPrenom(this.prenom);
            usager.setAdresse(this.adresse);
            usager.setListeEmprunts(new ArrayList<>());
            usager.setListeReservations(new ArrayList<>());
            return usager;
        }
}
