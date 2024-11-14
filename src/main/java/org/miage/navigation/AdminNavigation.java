package org.miage.navigation;

import org.miage.models.accounts.Admin;
import java.util.Scanner;

public class AdminNavigation {
    public static void naviguerAdmin(Scanner scanner, Admin admin) {
        String choixAdmin = "";
        while (!choixAdmin.equals("retour")) {
            admin.displayMenu();
            System.out.println("Entrez une option (supprimer, retour) :");
            choixAdmin = scanner.nextLine();

            switch (choixAdmin.toLowerCase()) {
                case "supprimer":
                    System.out.println("Quel compte souhaitez-vous supprimer ?");
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