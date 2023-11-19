package fr.ul.miage.GestionBibiliotheque.Controller;

import fr.ul.miage.GestionBibiliotheque.Model.*;
import fr.ul.miage.GestionBibiliotheque.Repository.*;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostUsagerDTO;
import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumDisponibilite;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/usagers")
public class UsagerEmpruntReservationController {

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

    /*
     * USAGERS
     */
    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Usager> getAllUsagers(){
        return this.usagerRepository.findAll();
    }

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Usager createNewUsager(@RequestBody @Valid PostUsagerDTO usagerDTO){
        Usager usager = usagerDTO.toEntity();
        return usagerRepository.save(usager);
    }

    @GetMapping(value = "/{usagerID}/")
    @ResponseStatus(value = HttpStatus.OK)
    public Usager getUsagerById(@PathVariable("usagerID") UUID usagerID){
        return this.usagerRepository.findById(usagerID).orElseThrow();
    }

    /*
     * EMPRUNTS
     */

    @GetMapping(value = "/{usagerID}/emprunts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Emprunt> getEmpruntsOfUsager(@PathVariable("usagerID") UUID usagerID){
        return usagerRepository.findById(usagerID).orElseThrow().getListeEmprunts();
    }

    @PostMapping(value = "/{usagerID}/emprunt/{exemplaireID}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Emprunt createNewEmprunt(@PathVariable("usagerID") UUID usagerID, @PathVariable("exemplaireID") int exemplaireID){
        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(new Date());
        emprunt.setUsager(usagerRepository.findById(usagerID).orElseThrow());
        emprunt.setExemplaire(exemplaireRepository.findById(exemplaireID).orElseThrow());
        return empruntRepository.save(emprunt);
    }

    /*
     * RESERVATIONS
     */
    @PostMapping(value = "/{usagerID}/reservation/{oeuvreID}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Reservation createNewReservation(@PathVariable("usagerID") UUID usagerID, @PathVariable("oeuvreID") UUID oeuvreID){
        Reservation reservation = new Reservation();
        reservation.setDateDebut(new Date());
        reservation.setUsager(usagerRepository.findById(usagerID).orElseThrow());
        reservation.setOeuvre(oeuvreRepository.findById(oeuvreID).orElseThrow());
        return reservationRepository.save(reservation);
    }

    @GetMapping(value = "/{usagerID}/reservations")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Reservation> getReservationsOfUsager(@PathVariable("usagerID") UUID usagerID){
        return usagerRepository.findById(usagerID).orElseThrow().getListeReservations();
    }

}
