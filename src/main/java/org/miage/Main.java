package org.miage;
import org.miage.Model.*;

import java.util.Scanner;

public class Main {

    public static Store magasin = new Store();


    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        Customer client = new Customer("c", "p");
        Seller marchand = new Seller("marchand1", "password123");
        Admin admin = new Admin("admin", "admin123");

        magasin.addAccount(client);
        magasin.addAccount(marchand);
        magasin.addAccount(admin);

        Product produit1 = new Product("Laptop", 999.99, 10);
        Product produit2 = new Product("Smartphone", 599.99, 20);
        marchand.addProduct(produit1);
        marchand.addProduct(produit2);
        magasin.addProduct(produit1);
        magasin.addProduct(produit2);

        String input = "";
        System.out.println("Bienvenue dans le magasin en ligne !");
        while (!input.equalsIgnoreCase("i leave")) {
            System.out.println("Entrez vos pseudo suivi du mdp : pseudo mdp");
            input = scanner.nextLine();

            User co = magasin.connexion(input.split(" ")[0], input.split(" ")[1]);
            if (co == null) {
                System.out.println("Vous n'avez pas le bon pseudo mdp");
                break;
            }

            switch (co.getClass().getSimpleName()) {
                case "Customer":
                    naviguerClient(scanner, client);
                    break;
                case "Merchant":
                    naviguerMarchand(scanner, marchand);
                    break;
                case "Admin":
                    naviguerAdmin(scanner, admin);
                    break;
                case "i leave":
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Type de compte non reconnu");
                    break;
            }
        }
        scanner.close();
    }

    private static void naviguerClient(Scanner scanner, Customer client) {
        String choixClient = "";
        while (!choixClient.equals("retour")) {
            client.afficherMenu();
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

    private static void naviguerMarchand(Scanner scanner, Seller marchand) {
        String choixMarchand = "";
        while (!choixMarchand.equals("retour")) {
            marchand.afficherMenu();
            System.out.println("Entrez une option (ajouter, afficher, retour) :");
            choixMarchand = scanner.nextLine();

            switch (choixMarchand.toLowerCase()) {
                case "ajouter":
                    Product nouveauProduit = new Product("Tablette", 299.99, 15);
                    marchand.addProduct(nouveauProduit);
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
