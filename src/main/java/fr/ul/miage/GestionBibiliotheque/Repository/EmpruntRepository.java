package fr.ul.miage.GestionBibiliotheque.Repository;

import fr.ul.miage.GestionBibiliotheque.Model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpruntRepository extends JpaRepository<Emprunt, UUID> {
}
