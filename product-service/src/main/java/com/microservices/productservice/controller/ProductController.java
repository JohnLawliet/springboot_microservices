package com.microservices.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.dto.ProductResponse;
import com.microservices.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createProduct(@RequestBody ProductRequest productReq) {
		return productService.createProduct(productReq);
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getProduct(@RequestParam("id") String id){
		return productService.getProduct(id);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@RequestParam("id") String id) {
		System.out.println("HEEEEEELLLLLLLLLLLLLLOOOOOOOOOOOOOOOOOO");
		System.out.println("id "+id);
		productService.deleteProduct(id);
	}
	
}
