package com.mash.restaurant.repositories;

import com.mash.restaurant.models.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {

}
