package fr.ul.miage.GestionBibiliotheque.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import fr.ul.miage.GestionBibiliotheque.Model.Livre;
import fr.ul.miage.GestionBibiliotheque.Model.Reservation;
import fr.ul.miage.GestionBibiliotheque.Service.ExemplaireService;
import fr.ul.miage.GestionBibiliotheque.Service.LivreService;
import fr.ul.miage.GestionBibiliotheque.Service.UsagerService;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostLivreDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(value = "/livres")
public class LivreExemplaireController {

    @Autowired
    LivreService livreService;

    @Autowired
    ExemplaireService exemplaireService;

    @Autowired
    UsagerService usagerService;

    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Livre> getAllLivres(){
        return livreService.getAllLivres();
    }

    @GetMapping(value = "/{oeuvreID}/")
    @ResponseStatus(value = HttpStatus.OK)
    public Livre getLivreById(@PathVariable("oeuvreID") UUID oeuvreID){
        return livreService.getLivreById(oeuvreID);
    }

    @PatchMapping(value = "/{oeuvreID}/exemplaires/{id}/detruire")
    @ResponseStatus(value = HttpStatus.OK)
    public Exemplaire detruireMagazine(@PathVariable("oeuvreID") UUID oeuvreID, @PathVariable("id") int id){
        return exemplaireService.detruireMagazine(oeuvreID,id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value= "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Livre createLivre(@RequestBody @Valid PostLivreDTO livreDTO){
        return livreService.createLivre(livreDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value= "/{oeuvreID}/")
    public ResponseEntity<String> deleteLivre(@PathVariable("oeuvreID") @NotBlank UUID id){
        return livreService.deleteLivre(id);
    }

    @GetMapping(value = "/{oeuvreID}/exemplaires/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Exemplaire> getExemplaireOfLivre(@PathVariable("oeuvreID") UUID oeuvreID){
        return exemplaireService.getExemplairesOfOeuvreLivre(oeuvreID);
    }

    @GetMapping(value = "/{oeuvreID}/reservations/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Reservation> getReservationLivre(@PathVariable("oeuvreID") UUID oeuvreID){
        return usagerService.getReservationOfOeuvreLivre(oeuvreID);
    }

    @PostMapping(value = "/{oeuvreID}/exemplaire/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Exemplaire createNewExemplaire(@PathVariable("oeuvreID") UUID oeuvreID){
        return exemplaireService.createNewExemplaireLivre(oeuvreID);
    }
    
}
