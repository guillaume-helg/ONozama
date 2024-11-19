package org.miage.models.accounts;

import org.miage.models.Cart;
import org.miage.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Cart> cartList;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.cartList = new ArrayList<>();
    }

    public void order(Product produit, int quantite) {
        if(produit.getProduct(quantite)){
            Cart commande = new Cart(produit, quantite);
            cartList.add(commande);
            System.out.println("Commande passée : " + produit.getName() + " - Quantité : " + quantite);
        }else
            System.out.println("Erreur stock inférieur à la demande : "+produit.getStock()+" < "+quantite);
    }

    public void displayOrderList() {
        System.out.println("Historique des commandes pour " + idUser + ":");
        for (Cart commande : cartList) {
            System.out.println(commande);
        }
    }

    public void displayMenu() {
        System.out.println("Menu Client : 1. Passer une commande, 2. Afficher l'historique des commandes");
    }

    public List<Cart> getOrderList() {
        return cartList;
    }
}
