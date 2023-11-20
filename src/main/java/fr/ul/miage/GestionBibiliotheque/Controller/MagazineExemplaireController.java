package fr.ul.miage.GestionBibiliotheque.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Service.ExemplaireService;
import fr.ul.miage.GestionBibiliotheque.Service.MagazineService;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostMagazineDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(value = "/magazines")
public class MagazineExemplaireController {
    @Autowired
    MagazineService magazineService ;

    @Autowired
    ExemplaireService exemplaireService;

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Magazine> getAllMagazine(){
        return magazineService.getAllMagazines();
    }


    @GetMapping(value = "/{oeuvreID}/")
    @ResponseStatus(value = HttpStatus.OK)
    public Magazine getMagazineById(@PathVariable("oeuvreID") UUID oeuvreID){
        return magazineService.getMagazineById(oeuvreID);
    }

    @GetMapping(value = "/{oeuvreID}/exemplaires")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Exemplaire> getExemplaireOfMagazine(@PathVariable("oeuvreID") UUID oeuvreID){
        return exemplaireService.getExemplairesOfOeuvreMagazine(oeuvreID);
    }

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Magazine createMagazine(@RequestBody @Valid PostMagazineDTO magazineDTO){
        return magazineService.createMagazine(magazineDTO);
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> deleteMagazine(@RequestParam @NotBlank UUID id){
        return magazineService.deleteMagazine(id);
    }

    @PostMapping(value = "/{oeuvreID}/exemplaire")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Exemplaire createNewExemplaire(@PathVariable("oeuvreID") UUID oeuvreID){
        return exemplaireService.createNewExemplaireMagazine(oeuvreID);
    }
}
