package com.mash.restaurant.controllers;

import com.mash.restaurant.configuration.WebSocketHandler;
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
    private final WebSocketHandler webSocketHandler;

    @Autowired
    public FoodItemController(FoodItemRepository foodItemRepository, WebSocketHandler webSocketHandler) {
        this.foodItemRepository = foodItemRepository;
        this.webSocketHandler = webSocketHandler;
    }

    @GetMapping
    public @ResponseBody Iterable<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<FoodItem> getFoodItem(@PathVariable Integer id) {
        return foodItemRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem newFoodItem) {
        FoodItem foodItem = foodItemRepository.save(newFoodItem);
        webSocketHandler.sendToAllSessions(foodItemRepository.findAllByOrderByIdAsc().toString());
        return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateFoodItem(@PathVariable int id) {
        foodItemRepository.updateSoldItem(id);
        webSocketHandler.sendToAllSessions(foodItemRepository.findAllByOrderByIdAsc().toString());
    }
}