package org.miage;

import org.miage.database.Database;
import org.miage.models.*;
import org.miage.models.accounts.*;
import org.miage.navigation.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Store magasin = new Store();

    public static void main(String[] args) {
        // Initialisation des données
        initializeData();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenue dans le magasin en ligne !");
            String input;

            do {
                System.out.println("Entrez votre pseudo suivi du mot de passe (ou tapez 'i leave' pour quitter) :");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("i leave")) {
                    System.out.println("Au revoir !");
                    break;
                }

                String[] credentials = input.split(" ");
                if (credentials.length != 2) {
                    System.out.println("Format incorrect. Veuillez entrer : pseudo mdp");
                    continue;
                }

                User connectedUser = magasin.connection(credentials[0], credentials[1]);
                if (connectedUser == null) {
                    System.out.println("Identifiants incorrects. Veuillez réessayer.");
                } else {
                    navigateUser(scanner, connectedUser);
                }
            } while (true);
        }
    }

    /**
     * Initialisation des données temporaires (comptes et produits).
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
//        System.out.println("Données de test initialisées !");
//        try {
//            Database.save(magasin, "test.json");
//        } catch (IOException exception){
//            System.out.println("Erreur de sauvegarde !" + exception.toString());

        try {
            magasin = Database.load("test.json");
        } catch (IOException exception){
            System.out.println("Erreur de sauvegarde !" + exception.toString());
        }
    }

    /**
     * Permet la navigation en fonction du type d'utilisateur.
     *
     * @param scanner Scanner pour lire les entrées utilisateur.
     * @param user    L'utilisateur connecté.
     */
    private static void navigateUser(Scanner scanner, User user) {
        String userType = user.getClass().getSimpleName();
        switch (userType) {
            case "Customer":
                ClientNavigation.naviguerClient(scanner, (Customer) user, magasin);
                break;
            case "Seller":
                SellerNavigation.naviguerMarchand(scanner, (Seller) user, magasin);
                break;
            case "Admin":
                AdminNavigation.naviguerAdmin(scanner, (Admin) user);
                break;
            default:
                System.out.println("Type de compte non reconnu.");
                break;
        }
    }
}
