package org.miage.navigation;

import org.miage.models.Product;
import org.miage.models.Store;
import org.miage.models.accounts.Admin;
import org.miage.models.accounts.Seller;
import org.miage.models.accounts.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminNavigation {
    public static void naviguerAdmin(Scanner scanner, Admin admin, Store store) {
        String choixAdmin = "";
        while (!choixAdmin.equals("retour")) {
            admin.displayMenu();
            System.out.println("Entrez une option : \n1.supprimer\n2.Modifier un compte\n3.retour\n");
            choixAdmin = scanner.nextLine();
            int index = 0;
            switch (choixAdmin.toLowerCase()) {
                case "1":
                    store.displayUser();
                    System.out.println("Quel compte souhaitez-vous supprimer ?");
                    choixAdmin = scanner.nextLine();

                    index = Integer.parseInt(choixAdmin);
                    store.deleteAccount(index);
                    break;
                case "2":
                    store.displayUser();

                    System.out.println("Quel compte souhaitez-vous modifier ?");
                    choixAdmin = scanner.nextLine();
                    index = Integer.parseInt(choixAdmin);

                    System.out.println("Entrez le nom  : ");
                    String name = scanner.nextLine();

                    System.out.println("Entrez le mdp : ");
                    String password = scanner.nextLine();

                    admin.modifyAccount(index, name, password);
                    break;
                case "3":

                    System.out.println("Retour au menu principal");
                    break;
                default:
                    System.out.println("Option non reconnue");
                    break;
            }
        }
    }
}