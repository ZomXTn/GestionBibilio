package fr.ul.miage.GestionBibiliotheque.Repository;

import fr.ul.miage.GestionBibiliotheque.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
