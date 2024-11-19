package org.miage.models.accounts;

import org.miage.models.Cart;
import org.miage.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private Cart cart;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void order(Product produit, int quantite) {
        if(quantite > 0)
            if(produit.getProduct(quantite)){
                cart.add(produit, quantite);
                System.out.println("Commande passée : " + produit.getName() + " - Quantité : " + quantite);
            } else
                System.out.println("Erreur stock inférieur à la demande : "+produit.getStock()+" < "+quantite);
        if (quantite < 0) {
            produit.pushProduct(quantite);
            cart.remove(produit, quantite);
        }
    }

    public void displayOrderList() { System.out.println(cart.toString()); }

    public void displayMenu() {
        System.out.println("Menu Client : 1. Passer une commande, 2. Afficher le panier");
    }

    public Cart getOrderList() {
        return cart;
    }
}
