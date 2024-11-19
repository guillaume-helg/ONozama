package org.miage.models;

import java.util.HashMap;

public class Cart {
    private Product product;
    private int quantity;
    private HashMap<Product, Integer> cartMap;


    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

        this.cartMap = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Le produit ne peut pas être nul et la quantité doit être positive.");
        }
        cartMap.put(product, cartMap.getOrDefault(product, 0) + quantity);
    }

    public void remove(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Le produit ne peut pas être nul et la quantité doit être positive.");
        }

        if (cartMap.containsKey(product)) {
            int currentQuantity = cartMap.get(product);
            int newQuantity = currentQuantity - quantity;

            if (newQuantity > 0) {
                cartMap.put(product, newQuantity);
            } else {
                cartMap.remove(product);
            }
        } else {
            System.out.println("Le produit n'existe pas dans le panier.");
        }
    }

    public int size(){
        return cartMap.size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contenu du panier :\n");
        for (var entry : cartMap.entrySet()) {
            sb.append("Produit : ").append(entry.getKey().getName())
                    .append(", Quantité : ").append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }
}
