package fr.ul.miage.GestionBibiliotheque.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import fr.ul.miage.GestionBibiliotheque.Model.Oeuvre;
import fr.ul.miage.GestionBibiliotheque.Repository.ExemplaireRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.OeuvreRepository;
import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumDisponibilite;

@Service
public class ExemplaireService {

    @Autowired
    private OeuvreRepository oeuvreRepository;
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    public Exemplaire createExemplaire(UUID oeuvreID){
        Oeuvre oeuvre = oeuvreRepository.getReferenceById(oeuvreID);
        Exemplaire exemplaire = new Exemplaire(EnumDisponibilite.EN_RAYON, oeuvre);
        return exemplaireRepository.save(exemplaire);
    }
    
}
