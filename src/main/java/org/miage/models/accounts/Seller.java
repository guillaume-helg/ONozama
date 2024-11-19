package org.miage.models.accounts;


import org.miage.models.Product;
import org.miage.models.Store;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Seller extends User {

    public Seller(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
    }

    public void addProduct(Store store, Product produit) {
        store.addProduct(produit, this);
    }

    public void deleteProduct(Store store, Product produit) {
        store.deleteProduct(produit, this);
    }

    public void displayProduct(Store store) {
        Map<Seller, ArrayList<Product>> productList = store.getProductHashMap();
        ArrayList<Product> products = productList.get(this);

        int i = 0;

        for (Product product : products) {
            System.out.println(product);
            i++;
        }
    }


    public void displayMenu() {
        System.out.println("Menu Marchand : 1. Ajouter un produit, 2. Afficher les produits");
    }
}
