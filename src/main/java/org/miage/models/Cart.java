package org.miage.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import org.miage.database.*;

import java.util.HashMap;

public class Cart {
    @JsonSerialize(using=HashMapProductIntegerSerializer.class)
    @JsonDeserialize(using=HashMapProductIntegerDeserializer.class)
    private final HashMap<Product, Integer> cartMap;

    public Cart() {
        this.cartMap = new HashMap<>();
    }

    @JsonCreator
    public Cart(@JsonProperty("cartMap") HashMap<Product, Integer> cartMap) {
        this.cartMap = cartMap;
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
        int count = 0;

        StringBuilder sb = new StringBuilder("Contenu du panier :\n");
        for (var entry : cartMap.entrySet()) {
            sb.append("Produit ("+ count++ +") : ").append(entry.getKey().getName())
                    .append(", Quantité : ").append(entry.getValue())
                    .append("\n");
        }

        if(cartMap.isEmpty()){
            sb.append("-- Vide --\n");
        }

        return sb.toString();
    }

    public void clear(){
        cartMap.clear();
    }

    /**
     * Récupère un produit du panier selon son index.
     *
     * @param index L'index du produit dans le panier.
     * @return Le produit correspondant ou null si l'index est invalide.
     */
    public Product getProductByIndex(int index) {
        int count = 0;
        for (Product product : cartMap.keySet()) {
            if (count == index) {
                return product;
            }
            count++;
        }
        return null;
    }
}
