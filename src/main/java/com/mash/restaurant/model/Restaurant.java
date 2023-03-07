package com.mash.restaurant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Restaurant {
    @Id
    @Column
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Column
    private String name;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant() {

    }
}
