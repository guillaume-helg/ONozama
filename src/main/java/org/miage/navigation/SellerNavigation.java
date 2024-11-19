package org.miage.navigation;

import org.miage.models.Store;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;

import java.util.*;

public class SellerNavigation {

    public static void naviguerMarchand(Scanner scanner, Seller marchand, Store magasin) {
        String choixMarchand = "";
        while (!choixMarchand.equals("retour")) {
            marchand.displayMenu();
            System.out.println("Entrez une option (ajouter, supprimer, afficher, retour) :");
            choixMarchand = scanner.nextLine();

            switch (choixMarchand.toLowerCase()) {
                case "ajouter":
                    System.out.println("Entrez le nom du produit : ");
                    String nomProduit = scanner.nextLine();

                    System.out.println("Entrez le prix du produit : ");
                    double prixProduit = 0;

                    System.out.println("Entrez la quantité de stock : ");
                    int quantiteProduit = 0;

                    Product nouveauProduit = new Product(nomProduit, prixProduit, quantiteProduit);
                    marchand.addProduct(magasin, nouveauProduit);
                    System.out.println("Produit ajouté !");
                    break;
                case "supprimer":
                    marchand.displayProduct(magasin);
                    System.out.println("Entrez le numéro du produit : ");
                    String numeroIndex = scanner.nextLine();

                    int index = Integer.parseInt(numeroIndex);

                    HashMap<Seller, ArrayList<Product>> productList = magasin.getProductHashMap();
                    boolean productFound = false;
                    int i = 0;

                    for (Map.Entry<Seller, ArrayList<Product>> entry : productList.entrySet()) {
                        Seller seller = entry.getKey();

                        if (Objects.equals(seller.getIdUser(), marchand.getIdUser())) {
                            ArrayList<Product> products = entry.getValue();

                            for (Product product : products) {
                                if (i == index) {
                                    products.remove(product);
                                    System.out.println("Produit supprimé !");
                                    productFound = true;
                                    break;
                                }
                                i++;
                            }
                        }

                        if (productFound) break;
                    }

                    if (!productFound) {
                        System.out.println("Produit introuvable.");
                    }
                    break;
                case "afficher":
                    System.out.println("afficher ....");
                    marchand.displayProduct(magasin);
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
