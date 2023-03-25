package com.mash.restaurant;

import com.mash.restaurant.models.FoodItem;
import com.mash.restaurant.repositories.FoodItemRepository;
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
			repository.save(new FoodItem("Apple", 50, false));
			repository.save(new FoodItem("Fried Chicken", 500, true));
			repository.save(new FoodItem("Mashed Potatoes", 100, true));
			repository.save(new FoodItem("Pizza", 350,true));
			repository.save(new FoodItem("Caesar Salad", 150, false));
		});
	}
}
