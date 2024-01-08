package com.example.fer.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ServiceImpl implements Iservice{


    private final EvenementRepository evenementRepository;
    private final CategorieRepository categorieRepository;


    public Evenement ajouterEvenement(Evenement evenement) {
        // Récupération des catégories depuis la base de données ou création si elles n'existent pas
        Categorie c1 = categorieRepository.findByNomCategorie("c1");
        Categorie c2 = categorieRepository.findByNomCategorie("c2");
        Categorie c3 = categorieRepository.findByNomCategorie("c3");

        // Création de l'événement "summer vibes"
        if (evenement.getNomEvenement().equals("summer vibes")) {
            Set<Categorie> categories = new HashSet<>();
            categories.add(c1);
            categories.add(c2);
            evenement.setCategories(categories);
            evenement.setDateEvenement(LocalDate.now()); // Date fictive pour l'exemple

            // Création de l'événement "how to get a job in one week"
        } else if (evenement.getNomEvenement().equals("how to get a job in one week")) {
            Set<Categorie> categories = new HashSet<>();
            categories.add(c3);
            evenement.setCategories(categories);
            evenement.setDateEvenement(LocalDate.now()); // Date fictive pour l'exemple
        }

        return evenementRepository.save(evenement);
    }
}
