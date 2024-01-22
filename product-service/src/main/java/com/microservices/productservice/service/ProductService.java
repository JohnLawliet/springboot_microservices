package com.microservices.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepo;


	public String createProduct(ProductRequest productReq) {
		Product product = Product.builder()
				.name(productReq.getName())
				.description(productReq.getDescription())
				.price(productReq.getPrice())
				.build();
		productRepo.save(product);
		
		//below is possible coz of slf4j due to lombok. id gets replaced in placeholder
		log.info("Product {} is saved", product.getId());
		return product.getId();
	}
	
	public List<ProductResponse> getAllProducts(){
		List<Product> products = productRepo.findAll();
		return products.stream()
		.map(product -> mapToProductResponse(product))
		.toList();
	}
	
	public ProductResponse getProduct(String id) {
		Product product = productRepo.findById(id).get();
		return mapToProductResponse(product);
	}
	
	public void deleteProduct(String id) {
		productRepo.deleteById(id);
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.description(product.getDescription())
				.name(product.getName())
				.price(product.getPrice())
				.build();
	}
	
	
}
