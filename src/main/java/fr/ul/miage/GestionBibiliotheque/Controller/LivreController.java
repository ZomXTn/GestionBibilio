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

import fr.ul.miage.GestionBibiliotheque.Model.Livre;
import fr.ul.miage.GestionBibiliotheque.Repository.LivreRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(consumes = "/livres")
public class LivreController {

    @Autowired
    LivreRepository livresRepository;

    @GetMapping
    public List<Livre> getAllLives(){
        return this.livresRepository.findAll();
    }

    @PostMapping
    public Livre createLivre(@RequestBody @Valid Livre livre){
        return this.livresRepository.save(livre);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteLivre(@RequestParam @NotBlank UUID id){
        this.livresRepository.deleteById(id);
        return ResponseEntity.ok("Livre supprimé avec succès");
    }
}
