package fr.ul.miage.GestionBibiliotheque.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Repository.MagazineRepository;
import fr.ul.miage.GestionBibiliotheque.Service.DTO.PostMagazineDTO;
import jakarta.validation.constraints.NotBlank;

@Service
public class MagazineService {
    @Autowired 
    MagazineRepository magazinesRepository;

    public List<Magazine> getAllMagazines(){
        return this.magazinesRepository.findAll();
    }

    public Magazine getMagazineById(UUID oeuvreID){
        return this.magazinesRepository.findById(oeuvreID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Magazine n'existe pas"));
    }

    public Magazine createMagazine(PostMagazineDTO magazineDTO){
        Magazine magazine = magazineDTO.toEntity();
        return this.magazinesRepository.save(magazine);
    }

    public ResponseEntity<String> deleteMagazine(@RequestParam @NotBlank UUID id){
        Magazine magazine = this.magazinesRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Magazine n'existe pas"));
        this.magazinesRepository.delete(magazine);
        return ResponseEntity.ok("Magazine supprimé avec succès");
    }
}
