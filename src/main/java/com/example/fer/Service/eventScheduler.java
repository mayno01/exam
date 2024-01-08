package com.example.fer.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.examenf.Entities.Categorie;
import com.example.examenf.Entities.Evenement;
import com.example.examenf.Repository.CategorieRepository;

import java.util.List;

@Component
public class EventScheduler {

    // hezi file hetha 7otih f code mta3k ( asn3ih file hetha kima heka ) 

    private final CategorieRepository categorieRepository;

    public EventScheduler(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Scheduled(fixedRate = 15000) // Déclenche toutes les 15 secondes
    public void listeEvenementParCategorie() {
        List<Categorie> categories = categorieRepository.findAll();

        for (Categorie categorie : categories) {
            System.out.println("Evenements pour la catégorie " + categorie.getNomCategorie() + ":");
            for (Evenement evenement : categorie.getEvenements()) {
                System.out.println("- " + evenement.getNomEvenement() + " - Places restantes : " + evenement.getNbPlacesRestants());
            }
            System.out.println("-----------------------------------------");
        }
    }
}
