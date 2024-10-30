package org.miage;
import org.miage.Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store magasin = new Store();

        Customer client = new Customer("client1", "password123");
        Merchant marchand = new Merchant("marchand1", "password123");
        Admin admin = new Admin("admin", "admin123");

        magasin.ajouterCompte(client);
        magasin.ajouterCompte(marchand);
        magasin.ajouterCompte(admin);

        Product produit1 = new Product("Laptop", 999.99, 10);
        Product produit2 = new Product("Smartphone", 599.99, 20);
        marchand.ajouterProduit(produit1);
        marchand.ajouterProduit(produit2);
        magasin.ajouterProduit(produit1);
        magasin.ajouterProduit(produit2);

        String input = "";
        System.out.println("Bienvenue dans le magasin en ligne !");
        while (!input.equalsIgnoreCase("i leave")) {
            System.out.println("Entrez le type de compte (client, marchand, admin) ou 'i leave' pour quitter :");
            input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "client":
                    naviguerClient(scanner, client);
                    break;
                case "marchand":
                    naviguerMarchand(scanner, marchand);
                    break;
                case "admin":
                    naviguerAdmin(scanner, admin);
                    break;
                case "i leave":
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Type de compte non reconnu.");
                    break;
            }
        }
        scanner.close();
    }

    // Navigation pour le client
    private static void naviguerClient(Scanner scanner, Customer client) {
        String choixClient = "";
        while (!choixClient.equals("retour")) {
            client.afficherMenu();
            System.out.println("Entrez une option (passer, historique, retour) :");
            choixClient = scanner.nextLine();

            switch (choixClient.toLowerCase()) {
                case "passer":
                    Product produitTest = new Product("Laptop", 999.99, 10);
                    client.passerCommande(produitTest, 1);
                    break;
                case "historique":
                    client.afficherHistoriqueCommandes();
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

    // Navigation pour le marchand
    private static void naviguerMarchand(Scanner scanner, Merchant marchand) {
        String choixMarchand = "";
        while (!choixMarchand.equals("retour")) {
            marchand.afficherMenu();
            System.out.println("Entrez une option (ajouter, afficher, retour) :");
            choixMarchand = scanner.nextLine();

            switch (choixMarchand.toLowerCase()) {
                case "ajouter":
                    Product nouveauProduit = new Product("Tablette", 299.99, 15);
                    marchand.ajouterProduit(nouveauProduit);
                    break;
                case "afficher":
                    marchand.afficherProduits();
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

    private static void naviguerAdmin(Scanner scanner, Admin admin) {
        String choixAdmin = "";
        while (!choixAdmin.equals("retour")) {
            admin.afficherMenu();
            System.out.println("Entrez une option (supprimer, retour) :");
            choixAdmin = scanner.nextLine();

            switch (choixAdmin.toLowerCase()) {
                case "supprimer":
                    System.out.println("Quel compte souhaitez-vous supprimer ? (pas implémenté)");
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
