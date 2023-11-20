package fr.ul.miage.GestionBibiliotheque.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.ul.miage.GestionBibiliotheque.Model.Emprunt;
import fr.ul.miage.GestionBibiliotheque.Model.Oeuvre;
import fr.ul.miage.GestionBibiliotheque.Model.Reservation;
import fr.ul.miage.GestionBibiliotheque.Model.Usager;
import fr.ul.miage.GestionBibiliotheque.Repository.EmpruntRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.ExemplaireRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.OeuvreRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.ReservationRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.UsagerRepository;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostUsagerDTO;

@Service
public class UsagerService {

    @Autowired
    UsagerRepository usagerRepository;

    @Autowired
    EmpruntRepository empruntRepository;

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    OeuvreRepository oeuvreRepository;

    public List<Usager> getAllUsagers() {
        return usagerRepository.findAll();
    }

    public Usager findUsagerById(UUID usagerID) {
        return usagerRepository.findById(usagerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usager n'existe pas"));
    }

    public Usager createUsager(PostUsagerDTO usagerDTO) {
        usagerRepository.findByEmail(null)
                .ifPresent(s -> new ResponseStatusException(HttpStatus.CONFLICT, "Usager existe Déja"));
        return usagerRepository.save(usagerDTO.toEntity());
    }

    public List<Emprunt> getEmpruntsOfUsager(UUID usagerID) {
        return usagerRepository.findById(usagerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usager n'existe pas"))
                .getListeEmprunts();
    }

    public List<Reservation> getReservationsOfUsager(UUID usagerID) {
        return usagerRepository.findById(usagerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usager n'existe pas"))
                .getListeReservations();
    }

    public Reservation createNewReservation(UUID usagerID,
            UUID oeuvreID) {
        Reservation reservation = new Reservation();
        Oeuvre oeuvre = oeuvreRepository.findById(oeuvreID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Oeuvre n'existe pas"));
        Usager usager = usagerRepository.findById(usagerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usager n'existe pas"));
        reservation.setDateDebut(new Date());
        reservation.setUsager(usager);
        reservation.setOeuvre(oeuvre);
        return reservationRepository.save(reservation);
    }
}
