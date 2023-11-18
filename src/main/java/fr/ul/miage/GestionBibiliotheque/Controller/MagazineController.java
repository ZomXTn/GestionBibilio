package fr.ul.miage.GestionBibiliotheque.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Repository.MagazineRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(consumes = "/magazines")
public class MagazineController {
    @Autowired
    MagazineRepository magazineRepository ;

    @GetMapping
    public List<Magazine> getAllMagazine(){
        return this.magazineRepository.findAll();
    }

    @PostMapping
    public Magazine createMagazine(@RequestBody @Valid Magazine magazine){
        return this.magazineRepository.save(magazine);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMagazine(@RequestParam @NotBlank UUID id){
        this.magazineRepository.deleteById(id);
        return ResponseEntity.ok("Magazine Supprimé avec succès");
    }
}
