package org.miage.models.accounts;


import org.miage.models.Product;
import org.miage.models.Store;

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
        Map<Seller, Product> productList = store.getProductHashMap();
        if (productList == null || productList.isEmpty()) {
            System.out.println("No products available");
            return;
        }
        int i = 0;
        for (Map.Entry<Seller, Product> entry : productList.entrySet()) {

            Seller seller = entry.getKey();
            if (Objects.equals(seller.getIdUser(), this.getIdUser())) {
                System.out.println(i + " " + entry.getValue().toString());
            }

            i++;
        }
    }


    public static void main(String[] args) {
        Seller seller = new Seller("John", "Doe");
        Store store = new Store();
        Product product = new Product("sas", 12.0, 2);
        store.addProduct(product, seller);
        seller.displayProduct(store);
    }

    public void displayMenu() {
        System.out.println("Menu Marchand : 1. Ajouter un produit, 2. Afficher les produits");
    }
}
