package org.miage.models.accounts;

import org.miage.models.Cart;
import org.miage.models.Product;

import java.util.Scanner;

public class Customer extends User {
    private Cart cart;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.cart = new Cart();
    }

    /**
     * Permet de passer ou modifier une commande.
     *
     * @param produit  Le produit concerné.
     * @param quantite La quantité à ajouter ou retirer.
     */
    public void order(Product produit, int quantite) {
        if (produit == null || quantite == 0) {
            System.out.println("Erreur : produit invalide ou quantité nulle.");
            return;
        }

        if (quantite > 0) { // Ajout au panier
            if (produit.getProduct(quantite)) {
                cart.add(produit, quantite);
                System.out.println("Ajouté au panier : " + produit.getName() + " - Quantité : " + quantite);
            } else {
                System.out.println("Erreur : stock insuffisant. Stock disponible : " + produit.getStock());
            }
        } else { // Retrait du panier
            int quantiteAbs = Math.abs(quantite);
            try {
                cart.remove(produit, quantiteAbs);
                produit.pushProduct(quantiteAbs);
                System.out.println("Retiré du panier : " + produit.getName() + " - Quantité : " + quantiteAbs);
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    /**
     * Affiche le contenu du panier et gère les interactions utilisateur.
     */
    public void displayCart() {
        System.out.println(cart);

        if (cart.size() > 0) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez une option (supprimer, vider, retour) :");
            String choixClient = scanner.nextLine();

            switch (choixClient.toLowerCase()) {
                case "supprimer" -> handleRemoveFromCart(scanner);
                case "vider" -> {
                    cart.clear();
                    System.out.println("Votre panier a été vidé.");
                }
                case "retour" -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Option non reconnue.");
            }
        } else {
            System.out.println("Votre panier est vide.");
        }
    }

    /**
     * Affiche le menu principal pour le client.
     */
    public void displayMenu() {
        System.out.println("""
                Menu Client :
                1. passer (Passer une commande)
                2. panier (Voir et gérer le panier)
                3. retour (Retour au menu principal)
                """);
    }

    /**
     * Permet de supprimer un produit spécifique du panier.
     *
     * @param scanner Scanner pour lire l'entrée utilisateur.
     */
    private void handleRemoveFromCart(Scanner scanner) {
        System.out.println("Entrez le numéro du produit et la quantité à supprimer (format : num quantité) :");
        String choix = scanner.nextLine();

        try {
            String[] choixArray = choix.split(" ");
            int numProduit = Integer.parseInt(choixArray[0]);
            int quantite = Integer.parseInt(choixArray[1]);

            Product produitASupprimer = cart.getProductByIndex(numProduit);

            if (produitASupprimer == null) {
                System.out.println("Erreur : produit non trouvé pour le numéro " + numProduit);
                return;
            }

            try {
                cart.remove(produitASupprimer, quantite);
                System.out.printf("Quantité mise à jour pour le produit %s. Quantité restante : %d\n",
                        produitASupprimer.getName(),
                        cart.size());
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : format incorrect. Utilisez 'num quantité'.");
        }
    }
}
