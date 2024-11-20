package org.miage.navigation;

import org.miage.Tool;
import org.miage.database.Database;
import org.miage.models.Product;
import org.miage.models.accounts.Seller;

import java.util.*;

public class SellerNavigation {

    public static void naviguerMarchand( Seller marchand) {
        String choixMarchand = "";
        while (!choixMarchand.equals("retour")) {
            marchand.displayMenu();
            System.out.println("Entrez une option (ajouter, supprimer, afficher, retour) :");
            choixMarchand = Tool.scanner.nextLine();

            switch (choixMarchand.toLowerCase()) {
                case "ajouter":
                    System.out.println("Entrez le nom du produit : ");
                    String nomProduit = Tool.scanner.nextLine();

                    System.out.println("Entrez le prix du produit : ");
                    String prixProduit = Tool.scanner.nextLine();

                    System.out.println("Entrez la quantité de stock : ");
                    String qttProduit = Tool.scanner.nextLine();

                    Product nouveauProduit = new Product(nomProduit, Double.parseDouble(prixProduit), Integer.parseInt(qttProduit));
                    marchand.addProduct(Database.store, nouveauProduit);
                    System.out.println("Produit ajouté !");
                    break;
                case "supprimer":
                    marchand.displayProduct(Database.store);
                    System.out.println("Entrez le numéro du produit : ");
                    String numeroIndex = Tool.scanner.nextLine();

                    int index = Integer.parseInt(numeroIndex);

                    HashMap<Seller, ArrayList<Product>> productList = Database.store.getProductHashMap();
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
                    marchand.displayProduct(Database.store);
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
