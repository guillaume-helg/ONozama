package org.miage.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import org.miage.database.*;
import org.miage.models.accounts.*;

import java.util.*;

public class Store {
    @JsonIgnore
    private final List<User> userList;
    @JsonDeserialize(using = HashMapSellerProductDeserializer.class)
    @JsonSerialize(using = HashMapSellerProductSerializer.class)
    private HashMap<Seller, ArrayList<Product>> productHashMap;

    public Store() {
        this.userList = new ArrayList<>();
        this.productHashMap = new HashMap<>();
    }

    @JsonCreator
    public Store(@JsonProperty("productHashMap") HashMap<Seller, ArrayList<Product>> productHashMap) {
        this.productHashMap = productHashMap;
        this.userList = new ArrayList<>();
    }

    public void setProductHashMap(HashMap<Seller, ArrayList<Product>> productHashMap) {
        this.productHashMap = productHashMap;
    }

    public void addAccount(User compte) {
        if (compte == null) {
            System.out.println("Erreur : le compte ne peut pas être nul.");
            return;
        }

        if (userList.contains(compte)) {
            System.out.println("Le compte existe déjà : " + compte.getIdUser());
        } else {
            userList.add(compte);
            System.out.println("Compte ajouté avec succès : " + compte.getIdUser());
        }
    }

    public void deleteAccount(User compte) {
        if (compte == null) {
            System.out.println("Erreur : le compte ne peut pas être nul.");
            return;
        }

        if (userList.remove(compte)) {
            System.out.println("Compte supprimé avec succès : " + compte.getIdUser());
        } else {
            System.out.println("Erreur : le compte n'existe pas ou n'a pas pu être supprimé.");
        }
    }

    public void addProduct(Product produit, Seller seller) {
        if (produit == null || seller == null) {
            System.out.println("Erreur : ni le produit ni le vendeur ne peuvent être nuls.");
            return;
        }

        productHashMap.putIfAbsent(seller, new ArrayList<>());
        productHashMap.get(seller).add(produit);
        System.out.println("Produit ajouté au magasin par " + seller.getIdUser() + " : " + produit.getName());
    }

    public void deleteProduct(Product produit, Seller seller) {
        if (produit == null || seller == null) {
            System.out.println("Erreur : ni le produit ni le vendeur ne peuvent être nuls.");
            return;
        }

        ArrayList<Product> products = productHashMap.get(seller);
        if (products != null && products.remove(produit)) {
            System.out.println("Produit supprimé du magasin : " + produit.getName() + " (par " + seller.getIdUser() + ")");
            if (products.isEmpty()) {
                productHashMap.remove(seller); // Supprime l'entrée si la liste est vide.
            }
        } else {
            System.out.println("Erreur : le produit n'existe pas ou n'a pas pu être supprimé.");
        }
    }

    public Product selectProduct(String code) {
        try {
            String[] parts = code.split(" ");
            int sellerNumber = Integer.parseInt(parts[0]); // numéro du vendeur
            int productNumber = Integer.parseInt(parts[1]); // numéro du produit

            List<Seller> sellers = new ArrayList<>(productHashMap.keySet());
            if (sellerNumber < 0 || sellerNumber >= sellers.size()) {
                System.out.println("Erreur : numéro de vendeur invalide.");
                return null;
            }

            Seller seller = sellers.get(sellerNumber);
            ArrayList<Product> products = productHashMap.get(seller);

            if (productNumber < 0 || productNumber >= products.size()) {
                System.out.println("Erreur : numéro de produit invalide.");
                return null;
            }

            return products.get(productNumber);
        } catch (Exception e) {
            System.out.println("Erreur : le code fourni est invalide. Format attendu : 'num_vendeur num_produit quantité'");
        }

        return null;
    }


    public void displayProducts() {
        int numV = 0 , numP = 0;
        System.out.println("Produits disponibles dans le magasin :");

        if (productHashMap.isEmpty()) {
            System.out.println("Aucun produit n'est disponible actuellement.");
            return;
        }

        for (Map.Entry<Seller, ArrayList<Product>> entry : productHashMap.entrySet()) {
            System.out.println(productHashMap);

            Seller vendeur = entry.getKey();
            ArrayList<Product> products = entry.getValue();

            System.out.println("Vendeur ("+numV+"): " + vendeur.getIdUser());
            for (Product product : products) {
                System.out.printf("  - Produit ("+numP+") : %s | Prix : %.2f€ | Quantité : %d\n",
                        product.getName(),
                        product.getPrice(),
                        product.getStock());
                numP++;
            }
            numV++;
        }
        System.out.println("\n");
    }

    public void order(Customer client){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le num vendeur, num produit et la quantité " +
                "\n  Exemple: (0, 1, 5) :");
        String choix = scanner.nextLine();
        Product product = selectProduct(choix);

        int quantity = Integer.parseInt(choix.split(" ")[2]); // Quantité


        if(quantity > 0){
            client.addToCart(product, quantity);
        } else if (quantity < 0) {
            client.removeFromCart(product, quantity);
        }else{
            System.out.println("Quantité ne peut pas être 0");
        }
    }

    public User connection(String username, String password) {
        for (User compte : userList) {
            if (compte.getIdUser().equals(username) && compte.getPassword().equals(password)) {
                return compte;
            }
        }
        return null;
    }

    public List<User> getUserList() {
        return userList;
    }

    public HashMap<Seller, ArrayList<Product>> getProductHashMap() {
        return productHashMap;
    }

    public void displayUser() {
        int i = 0;
        for (User compte : userList) {
            System.out.println(i + " " + compte);
            i++;
        }
    }

    public void deleteAccount(int index) {
        this.userList.remove(index);
    }
}