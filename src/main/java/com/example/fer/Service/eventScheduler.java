package com.example.examenf.Services;

import com.example.examenf.Repository.ICategorie;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.examenf.Entities.Categorie;
import com.example.examenf.Entities.Evenement;


import java.util.List;
@AllArgsConstructor
@Component
public class EventScheduler {

    private final ICategorie categorieRepository;


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
