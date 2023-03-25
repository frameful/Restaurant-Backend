package com.mash.restaurant.models;

import com.google.gson.Gson;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class FoodItem {

    @Id
    @Column
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private boolean inStock;

    public FoodItem(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public FoodItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
