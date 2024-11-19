package org.miage.models;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
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

    public boolean getProduct(int nombre){
        if(nombre <= this.stock){
            this.stock -= nombre;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Produit: " + name + ", Prix: " + price + ", Stock: " + stock;
    }
}
