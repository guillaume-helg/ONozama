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
