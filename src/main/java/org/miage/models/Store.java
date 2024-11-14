package org.miage.models;

import org.miage.models.accounts.Seller;
import org.miage.models.accounts.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    private List<User> userList;
    private HashMap<Seller, Product> productHashMap;

    public Store() {
        this.userList = new ArrayList<>();
        this.productHashMap = new HashMap<>();
    }

    public void addAccount(User compte) {
        userList.add(compte);
        System.out.println("Compte ajouté : " + compte.getIdUser());
    }

    /** A voir **
    public void modifierCompte(User compte) {

    }*/

    public void deleteAccount(User compte) {
        userList.remove(compte);
        System.out.println("Compte supprimé : " + compte.getIdUser());
    }

    public void addProduct(Product produit, Seller seller) {
        productHashMap.put(seller, produit);
        System.out.println("Produit ajouté au magasin : " + produit.getName());
    }

    public void deleteProduct(Product produit, Seller seller) {
        productHashMap.remove(seller, produit);
        System.out.println("Produit supprimé au magasin : " + produit.getName());
    }

    public void displayProducts() {
        System.out.println("Produits disponibles dans le magasin :");
        for(Map.Entry<Seller, Product> entry : productHashMap.entrySet()) {
            Product produit = entry.getValue();
            System.out.println(produit);
        }
    }

    public User connection(String username, String password) {
        for (User compte : userList) {
            if (compte.getIdUser().equals(username) && compte.getPassword().equals(password)) {
                return compte;
            }
        }
        return null;
    }
}
