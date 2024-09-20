package com.wed.myapp_1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wed.myapp_1.common.Product;
import com.wed.myapp_1.repository.ProductRepositary;
import com.wed.myapp_1.response.ProductResponce;
import com.wed.myapp_1.service.ProductService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:8088","*"})
public class ProductController {
	
	@Autowired
	private ProductRepositary productRepositary;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productRepositary.save(product);
		
	}
	@GetMapping("/getProduct")
	public List<Product> getProduct() {
		return productRepositary.findAll();	
	}
	
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable ("id") int  id) {
		return productService.updateProduct(product, id);
	}
	
	@GetMapping("/getByProductId/{id}")
	public Product getByProductId(@PathVariable ("id") int id) {
		return productService.getByProductId(id);
		
	}
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable ("id") int id) {
		productRepositary.deleteById(id);
		return "Deleted";
	}
	@GetMapping("/getProductsbyCatalogid/{id}")
	public List<ProductResponce> getProductsbyCatalogid(@PathVariable ("id") int id) {
		return productService.getProductsbyCatalogid(id);
	}
}
