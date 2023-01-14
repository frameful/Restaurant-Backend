package com.mash.restaurant.controllers;

import com.mash.restaurant.models.FoodItem;
import com.mash.restaurant.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemController(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping("/food")
    public @ResponseBody Iterable<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

}
