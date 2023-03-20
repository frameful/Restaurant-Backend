package com.mash.restaurant.controllers;

import com.mash.restaurant.models.FoodItem;
import com.mash.restaurant.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemController(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<FoodItem> getFoodItem(@PathVariable Integer id) { return foodItemRepository.findById(id); }

    @PostMapping
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem newFoodItem){
        FoodItem foodItem = foodItemRepository.save(newFoodItem);
        return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
    }

}
