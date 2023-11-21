package fr.ul.miage.GestionBibiliotheque.Controller;

import fr.ul.miage.GestionBibiliotheque.Model.*;
import fr.ul.miage.GestionBibiliotheque.Service.ExemplaireService;
import fr.ul.miage.GestionBibiliotheque.Service.UsagerService;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostUsagerDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/usagers")
public class UsagerEmpruntReservationController {

    @Autowired
    UsagerService usagerService;
    @Autowired
    ExemplaireService exemplaireService;

    /*
     * USAGERS
     */
    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Usager> getAllUsagers() {
        return usagerService.getAllUsagers();
    }

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Usager createNewUsager(@RequestBody @Valid PostUsagerDTO usagerDTO) {
        return usagerService.createUsager(usagerDTO);
    }

    @GetMapping(value = "/{usagerID}/")
    @ResponseStatus(value = HttpStatus.OK)
    public Usager getUsagerById(@PathVariable("usagerID") UUID usagerID) {
        return usagerService.findUsagerById(usagerID);
    }

    @DeleteMapping(value = "/{userID}/")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> deleteMagazine(@PathVariable("userID") @NotBlank UUID id){
        return usagerService.deleteUsager(id);
    }

    /*
     * EMPRUNTS
     */

    @GetMapping("/{usagerID}/emprunts/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Emprunt> getEmpruntsOfUsager(@PathVariable("usagerID") UUID usagerID) {
        return usagerService.getEmpruntsOfUsager(usagerID);
    }
    
    @GetMapping("/{usagerID}/reservations/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Reservation> getReservationsOfUsager(@PathVariable("usagerID") UUID usagerID) {
        return usagerService.getReservationsOfUsager(usagerID);
    }
    
    @PostMapping("/{usagerID}/emprunt/{exemplaireID}/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Emprunt createNewEmprunt(@PathVariable("usagerID") UUID usagerID,
            @PathVariable("exemplaireID") int exemplaireID,
            @RequestBody @Valid @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX") Date dateFin) {
        return exemplaireService.EmprunterExemplaire(usagerID, exemplaireID, dateFin);
    }

    /*
     * RESERVATIONS
     */
    @PostMapping(value = "/{usagerID}/reservation/{oeuvreID}/")
    @ResponseStatus(value = HttpStatus.CREATED ,reason = "Réservation crée avec succès")
    public Reservation createNewReservation(@PathVariable("usagerID") UUID usagerID,
            @PathVariable("oeuvreID") UUID oeuvreID) {
        return usagerService.createNewReservation(usagerID, oeuvreID);
    }


}
