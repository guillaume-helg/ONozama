package org.miage.navigation;

import org.miage.models.Store;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;
import java.util.Scanner;

public class SellerNavigation {
    public static void naviguerMarchand(Scanner scanner, Seller marchand, Store magasin) {
        String choixMarchand = "";
        while (!choixMarchand.equals("retour")) {
            marchand.displayMenu();
            System.out.println("Entrez une option (ajouter, afficher, retour) :");
            choixMarchand = scanner.nextLine();

            switch (choixMarchand.toLowerCase()) {
                case "ajouter":
                    Product nouveauProduit = new Product("Tablette", 299.99, 15);
                    marchand.addProduct(magasin, nouveauProduit);
                    break;
                case "afficher":
                    System.out.println("afficher ....");
                    //marchand.afficherProduits();
                    break;
                case "retour":
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option non reconnue.");
                    break;
            }
        }
    }
}
