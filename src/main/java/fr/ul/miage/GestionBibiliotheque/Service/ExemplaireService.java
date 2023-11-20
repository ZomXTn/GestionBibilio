package fr.ul.miage.GestionBibiliotheque.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import fr.ul.miage.GestionBibiliotheque.Model.Emprunt;
import fr.ul.miage.GestionBibiliotheque.Model.Exemplaire;
import fr.ul.miage.GestionBibiliotheque.Model.Livre;
import fr.ul.miage.GestionBibiliotheque.Model.Magazine;
import fr.ul.miage.GestionBibiliotheque.Model.Usager;
import fr.ul.miage.GestionBibiliotheque.Repository.EmpruntRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.ExemplaireRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.LivreRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.MagazineRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.ReservationRepository;
import fr.ul.miage.GestionBibiliotheque.Repository.UsagerRepository;
import fr.ul.miage.GestionBibiliotheque.Utilitary.EnumDisponibilite;

@Service
public class ExemplaireService {

    @Autowired
    UsagerRepository usagerRepository;

    @Autowired
    EmpruntRepository empruntRepository;

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    MagazineRepository oeuvreRepository;

    @Autowired
    LivreRepository livreRepository;

    public List<Exemplaire> getExemplairesOfOeuvre(@PathVariable("oeuvreID") UUID oeuvreID) {
        return oeuvreRepository.findById(oeuvreID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Oeuvre n'existe pas"))
                .getListeExemplaires();
    }

    public Exemplaire createNewExemplaireLivre(@PathVariable("oeuvreID") UUID oeuvreID) {
        Exemplaire exemplaire = new Exemplaire();
        Livre livre = livreRepository.findById(oeuvreID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livre n'existe pas"));
        exemplaire.setDisponibilite(EnumDisponibilite.EN_RAYON);
        exemplaire.setOeuvre(livre);
        exemplaire.setListeEmprunts(new ArrayList<>());
        return exemplaireRepository.save(exemplaire);
    }

    public Exemplaire createNewExemplaireMagazine(@PathVariable("oeuvreID") UUID oeuvreID) {
        Exemplaire exemplaire = new Exemplaire();
        Magazine oeuvre = oeuvreRepository.findById(oeuvreID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Magazine n'existe pas"));
        exemplaire.setDisponibilite(EnumDisponibilite.EN_RAYON);
        exemplaire.setOeuvre(oeuvre);
        exemplaire.setListeEmprunts(new ArrayList<>());
        return exemplaireRepository.save(exemplaire);
    }

    public Emprunt EmprunterExemplaire(UUID usagerID, int exemplaireID, Date dateFin) {
        Exemplaire exemplaire = exemplaireRepository.findById(exemplaireID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exemplaire n'existe pas"));
        Usager usager = usagerRepository.findById(usagerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usager n'existe pas"));
        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(new Date());
        emprunt.setDateFin(dateFin);
        emprunt.setUsager(usager);
        emprunt.setExemplaire(exemplaire);
        exemplaire.setDisponibilite(EnumDisponibilite.EMPRUNTÉ);
        exemplaireRepository.save(exemplaire);
        return empruntRepository.save(emprunt);
    }

}
