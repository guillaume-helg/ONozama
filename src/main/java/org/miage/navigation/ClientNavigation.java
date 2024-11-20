package org.miage.navigation;

import org.miage.Tool;
import org.miage.database.Database;
import org.miage.models.accounts.Customer;

public class ClientNavigation {
    public static void naviguerClient(Customer client) {
        String choixClient = "";
        while (!choixClient.equals("retour")) {
            client.displayMenu();
            choixClient = Tool.scanner.nextLine();

            switch (choixClient.toLowerCase()) {
                case "passer":
                    Database.store.displayProducts();
                    Database.store.order(client);
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
