package com.mash.restaurant.controllers;

import com.mash.restaurant.models.FoodItem;
import com.mash.restaurant.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/add_food",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FoodItem> newFoodItem(@RequestBody FoodItem newFoodItem){
        FoodItem foodItem = foodItemRepository.save(newFoodItem);
        return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
    }

}
