package org.miage;

import org.miage.database.Database;
import org.miage.models.accounts.*;
import org.miage.navigation.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        // Initialisation des données
        initializeData();

        System.out.println("Bienvenue dans le magasin en ligne !");
        String input;

        do {
            System.out.println("Entrez votre pseudo suivi du mot de passe (ou tapez 'i leave' pour quitter) :");
            input = Tool.scanner.nextLine().trim();

            if (input.equalsIgnoreCase("i leave") || input.equalsIgnoreCase("retour")) {
                System.out.println("Au revoir !");
                break;
            }

            String[] credentials = input.split(" ");
            if (credentials.length != 2) {
                System.out.println("Format incorrect. Veuillez entrer : pseudo mdp");
                continue;
            }

            User connectedUser = Database.store.connection(credentials[0], credentials[1]);
            if (connectedUser == null) {
                System.out.println("Identifiants incorrects. Veuillez réessayer.");
            } else {
                navigateUser(connectedUser);
            }
        } while (true);

    }

    /**
     * Initialisation des données (comptes et produits).
     */
    private static void initializeData() {
//        Customer client = new Customer("jerem87", "pass");
//        Seller marchand = new Seller("bogdan21", "password123");
//        Admin admin = new Admin("guillaume31", "admin123");
//
//        magasin.addAccount(client);
//        magasin.addAccount(marchand);
//        magasin.addAccount(admin);
//
//        Product produit1 = new Product("Laptop", 999.99, 10);
//        Product produit2 = new Product("Smartphone", 599.99, 20);
//        marchand.addProduct(magasin, produit1);
//        marchand.addProduct(magasin, produit2);
//
//        client.order(produit1, 1);
//
//        System.out.println("Données de test initialisées !");
//        try {
//            Database.save(magasin);
//        } catch (IOException exception) {
//            System.out.println("Erreur de sauvegarde !" + exception);
//        }
        try {
            Database.load();
        } catch (IOException exception){
            System.out.println("Erreur de sauvegarde !" + exception);
        }
    }

    /**
     * Permet la navigation en fonction du type d'utilisateur.
     *
     * @param user    L'utilisateur connecté.
     */
    private static void navigateUser(User user) {
        String userType = user.getClass().getSimpleName();
        switch (userType) {
            case "Customer":
                ClientNavigation.naviguerClient( (Customer) user);
                break;
            case "Seller":
                SellerNavigation.naviguerMarchand( (Seller) user);
                break;
            case "Admin":
                AdminNavigation.naviguerAdmin( (Admin) user);
                break;
            default:
                System.out.println("Type de compte non reconnu");
                break;
        }
    }
}
