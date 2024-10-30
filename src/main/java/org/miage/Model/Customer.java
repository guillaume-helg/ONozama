package org.miage.Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Account {
    private List<Order> historiqueCommandes;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.historiqueCommandes = new ArrayList<>();
    }

    public void passerCommande(Product produit, int quantite) {
        Order commande = new Order(produit, quantite);
        historiqueCommandes.add(commande);
        System.out.println("Commande passée : " + produit.getNom() + " - Quantité : " + quantite);
    }

    public void afficherHistoriqueCommandes() {
        System.out.println("Historique des commandes pour " + nomUtilisateur + ":");
        for (Order commande : historiqueCommandes) {
            System.out.println(commande);
        }
    }

    public void afficherMenu() {
        System.out.println("Menu Client : 1. Passer une commande, 2. Afficher l'historique des commandes");
    }
}
