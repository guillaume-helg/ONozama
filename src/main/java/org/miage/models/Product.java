package org.miage.models;

import com.fasterxml.jackson.annotation.*;

public class Product {
    private String name;
    private double price;
    private int stock;

    @JsonCreator
    public Product(@JsonProperty("name") String name, @JsonProperty("price") double price, @JsonProperty("stock") int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean getProduct(int number){
        if(number <= this.stock){
            this.stock -= number;
            return true;
        }

        return false;
    }

    public void pushProduct(int number){
        this.stock += number;
    }

    @Override
    public String toString() {
        return "Produit: " + name + ", Prix: " + price + ", Stock: " + stock;
    }
}
