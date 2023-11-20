package fr.ul.miage.GestionBibiliotheque.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import fr.ul.miage.GestionBibiliotheque.Model.Livre;
import fr.ul.miage.GestionBibiliotheque.Repository.LivreRepository;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostLivreDTO;
import jakarta.validation.constraints.NotBlank;

@Service
public class LivreService {
    @Autowired 
    LivreRepository livresRepository;

    public List<Livre> getAllLivres(){
        return this.livresRepository.findAll();
    }

    public Livre getLivreById(UUID oeuvreID){
        return this.livresRepository.findById(oeuvreID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre n'existe pas"));
    }

    public Livre createLivre(PostLivreDTO livreDTO){
        Livre livre = livreDTO.toEntity();
        return this.livresRepository.save(livre);
    }

    public ResponseEntity<String> deleteLivre(@RequestParam @NotBlank UUID id){
        Livre livre = this.livresRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre n'existe pas"));
        this.livresRepository.delete(livre);
        return ResponseEntity.ok("Livre supprimé avec succès");
    }
}
