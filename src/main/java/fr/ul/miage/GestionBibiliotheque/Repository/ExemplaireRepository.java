package fr.ul.miage.GestionBibiliotheque.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;

public interface ExemplaireRepository extends JpaRepository<Exemplaire,Integer> {

} 