package org.miage;

import org.miage.models.*;
import org.miage.models.accounts.*;
import org.miage.navigation.*;
import java.util.Scanner;

public class Main {
    public static Store magasin = new Store();

    public static void main(String[] args) {
        // Initialisation des utilisateurs et des produits...
        Scanner scanner = new Scanner(System.in);

        /** DATA TMP ***/
        Customer client = new Customer("jerem87", "pass");
        Seller marchand = new Seller("bogdan21", "password123");
        Admin admin = new Admin("guillaume31", "admin123");

        magasin.addAccount(client);
        magasin.addAccount(marchand);
        magasin.addAccount(admin);

        Product produit1 = new Product("Laptop", 999.99, 10);
        Product produit2 = new Product("Smartphone", 599.99, 20);
        marchand.addProduct(magasin, produit1);
        marchand.addProduct(magasin, produit2);
        /** DATA TMP ***/


        String input = "";
        System.out.println("Bienvenue dans le magasin en ligne !");
        while (!input.equalsIgnoreCase("i leave")) {
            System.out.println("Entrez vos pseudo suivi du mdp : pseudo mdp");
            input = scanner.nextLine();

            User co = magasin.connection(input.split(" ")[0], input.split(" ")[1]);
            if (co == null) {
                System.out.println("Vous n'avez pas le bon pseudo mdp");
                break;
            }

            switch (co.getClass().getSimpleName()) {
                case "Customer":
                    ClientNavigation.naviguerClient(scanner, (Customer) co, magasin);
                    break;
                case "Seller":
                    SellerNavigation.naviguerMarchand(scanner, (Seller) co, magasin);
                    break;
                case "Admin":
                    AdminNavigation.naviguerAdmin(scanner, (Admin) co);
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
}
