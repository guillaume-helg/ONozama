package org.miage.navigation;

import org.miage.models.Store;
import org.miage.models.accounts.Customer;
import java.util.Scanner;

public class ClientNavigation {
    public static void naviguerClient(Scanner scanner, Customer client, Store magasin) {
        String choixClient = "";
        while (!choixClient.equals("retour")) {
            client.displayMenu();
            choixClient = scanner.nextLine();

            switch (choixClient.toLowerCase()) {
                case "passer":
                    magasin.displayProducts();
                    magasin.order(client);
                    break;
                case "panier":
                    client.displayCart();
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
