package org.miage.navigation;

import org.miage.models.Store;
import org.miage.models.Product;
import org.miage.models.accounts.Customer;
import java.util.Scanner;

public class ClientNavigation {
    public static void naviguerClient(Scanner scanner, Customer client, Store magasin) {
        String choixClient = "";
        while (!choixClient.equals("retour")) {
            client.displayMenu();
            System.out.println("Entrez une option (passer, historique, retour) :");
            choixClient = scanner.nextLine();

            switch (choixClient.toLowerCase()) {
                case "passer":
                    magasin.displayProducts();
                    Product produitTest = new Product("Laptop", 999.99, 10);
                    client.order(produitTest, 1);
                    break;
                case "historique":
                    client.displayOrderList();
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
