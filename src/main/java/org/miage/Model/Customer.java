package org.miage.Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Order> orderList;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.orderList = new ArrayList<>();
    }

    public void order(Product produit, int quantite) {
        Order commande = new Order(produit, quantite);
        orderList.add(commande);
        System.out.println("Commande passée : " + produit.getName() + " - Quantité : " + quantite);
    }

    public void displayOrderList() {
        System.out.println("Historique des commandes pour " + idUser + ":");
        for (Order commande : orderList) {
            System.out.println(commande);
        }
    }

    public void afficherMenu() {
        System.out.println("Menu Client : 1. Passer une commande, 2. Afficher l'historique des commandes");
    }
}
