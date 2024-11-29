package org.miage.models.accounts;

import com.fasterxml.jackson.annotation.*;
import org.miage.Tool;
import org.miage.models.Cart;
import org.miage.models.Product;

import java.util.Scanner;

public class Customer extends User {
    @JsonProperty
    private Cart cart;

    public Customer(String nomUtilisateur, String motDePasse) {
        super(nomUtilisateur, motDePasse);
        this.cart = new Cart();
    }

    @JsonCreator
    public Customer(@JsonProperty("idUser") String nomUtilisateur, @JsonProperty("password") String motDePasse, @JsonProperty("cart") Cart cart) {
        super(nomUtilisateur, motDePasse);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    /**
     * Ajoute un produit au panier.
     *
     * @param produit  Le produit concerné.
     * @param quantite La quantité à ajouter.
     */
    public void addToCart(Product produit, int quantite) {
        if (produit == null || quantite <= 0) {
            System.out.println("Erreur : produit invalide ou quantité incorrecte.");
            return;
        }

        if (produit.getProduct(quantite)) {
            cart.add(produit, quantite);
            System.out.println("Ajouté au panier : " + produit.getName() + " - Quantité : " + quantite);
        } else {
            System.out.println("Erreur : stock insuffisant. Stock disponible : " + produit.getStock());
        }
    }

    /**
     * Retire un produit du panier.
     *
     * @param produit  Le produit concerné.
     * @param quantite La quantité à retirer.
     */
    public void removeFromCart(Product produit, int quantite) {
        if (produit == null || quantite <= 0) {
            System.out.println("Erreur : produit invalide ou quantité incorrecte.");
            return;
        }

        try {
            cart.remove(produit, quantite);
            produit.pushProduct(quantite);
            System.out.println("Retiré du panier : " + produit.getName() + " - Quantité : " + quantite);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
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
                case "supprimer" -> {
                    System.out.println("Entrez le numéro du produit et la quantité à supprimer (format : num quantité) :");
                    String choix = Tool.scanner.nextLine();

                    try {
                        String[] choixArray = choix.split(" ");
                        int numProduit = Integer.parseInt(choixArray[0]);
                        int quantite = Integer.parseInt(choixArray[1]);

                        Product produit = cart.getProductByIndex(numProduit);

                        if (produit == null) {
                            System.out.println("Erreur : produit non trouvé pour le numéro " + numProduit);
                            return;
                        }

                        removeFromCart(produit, quantite);
                        System.out.printf("Quantité mise à jour pour le produit %s. Quantité restante : %d\n",
                                produit.getName(),
                                cart.size());

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
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
}
