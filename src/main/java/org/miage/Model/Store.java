package org.miage.Model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<User> userList;
    private List<Product> productList;

    public Store() {
        this.userList = new ArrayList<>();
        this.productList = new ArrayList<>();
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

    public void addProduct(Product produit) {
        productList.add(produit);
        System.out.println("Produit ajouté au magasin : " + produit.getName());
    }

    public void deleteProduct(Product produit) {
        productList.remove(produit);
        System.out.println("Produit supprimé au magasin : " + produit.getName());
    }

    public void displayProducts() {
        System.out.println("Produits disponibles dans le magasin :");
        for (Product produit : productList) {
            System.out.println(produit);
        }
    }

    public User connexion(String username, String password) {
        for (User compte : userList) {
            if (compte.getIdUser().equals(username) && compte.getPassword().equals(password)) {
                return compte;
            }
        }
        return null;
    }
}
