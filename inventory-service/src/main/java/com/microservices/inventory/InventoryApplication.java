package com.microservices.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservices.inventory.model.Inventory;
import com.microservices.inventory.repository.InventoryRepository;


@SpringBootApplication
public class InventoryApplication{

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepo) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone24");
			inventory.setQuantity(200);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone25");
			inventory1.setQuantity(20);
			
			inventoryRepo.save(inventory);
			inventoryRepo.save(inventory1);
		};
	}

	
}
