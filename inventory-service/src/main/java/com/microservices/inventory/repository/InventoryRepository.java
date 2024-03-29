package com.microservices.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<com.microservices.inventory.model.Inventory, Long> {

	Optional<Inventory> findBySkuCode(String skuCode);
	
}
