package com.mash.restaurant;

import com.mash.restaurant.model.FoodItem;
import com.mash.restaurant.repository.FoodItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(FoodItemRepository repository) {
		return (args -> {
			repository.save(new FoodItem("Apple", 50, 50));
			repository.save(new FoodItem("Fried Chicken", 500, 10));
			repository.save(new FoodItem("Mashed Potatoes", 100, 100));
			repository.save(new FoodItem("Pizza", 350, 10));
			repository.save(new FoodItem("Caesar Salad", 150, 50));
		});
	}
}
