package org.miage.navigation;

import org.miage.Tool;
import org.miage.database.Database;
import org.miage.models.accounts.Admin;

public class AdminNavigation {
    public static void naviguerAdmin(Admin admin) {
        String choixAdmin = "";
        while (!choixAdmin.equals("retour")) {
            admin.displayMenu();
            System.out.println("Entrez une option : \n1.supprimer\n2.Modifier un compte\n3.retour\n");
            choixAdmin = Tool.scanner.nextLine();
            int index;
            switch (choixAdmin.toLowerCase()) {
                case "1":
                    Database.store.displayUser();
                    System.out.println("Quel compte souhaitez-vous supprimer ?");
                    choixAdmin = Tool.scanner.nextLine();

                    index = Integer.parseInt(choixAdmin);
                    Database.store.deleteAccount(index);
                    break;
                case "2":
                    Database.store.displayUser();

                    System.out.println("Quel compte souhaitez-vous modifier ?");
                    choixAdmin = Tool.scanner.nextLine();
                    index = Integer.parseInt(choixAdmin);

                    System.out.println("Entrez le nom  : ");
                    String name = Tool.scanner.nextLine();

                    System.out.println("Entrez le mdp : ");
                    String password = Tool.scanner.nextLine();

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