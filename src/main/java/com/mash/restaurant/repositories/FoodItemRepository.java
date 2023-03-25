package com.mash.restaurant.repositories;

import com.mash.restaurant.models.FoodItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {

    Iterable<FoodItem> findAllByOrderByIdAsc();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE FoodItem SET inStock = (NOT inStock) WHERE id = :id")
    void updateSoldItem(@Param("id") int id);
}
