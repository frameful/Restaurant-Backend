package com.mash.restaurant.controllers;

import com.mash.restaurant.models.FoodItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {

    @GetMapping("/food")
    public FoodItem getAllFoodItems() {
        return null; //TODO: fetch all food times from database
    }

}
