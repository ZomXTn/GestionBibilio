package fr.ul.miage.GestionBibiliotheque.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ul.miage.GestionBibiliotheque.Model.Livre;

public interface LivreRepository extends JpaRepository<Livre,UUID>{
    
}
