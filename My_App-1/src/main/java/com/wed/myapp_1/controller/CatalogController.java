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

import com.wed.myapp_1.common.Catalog;
import com.wed.myapp_1.repository.CatalogRepositary;
import com.wed.myapp_1.request.CatalogRequest;
import com.wed.myapp_1.service.CatalogService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"http://localhost:8088","*"})
public class CatalogController {

	@Autowired
	private CatalogRepositary catalog;
	@Autowired
	private CatalogService catalogService;
	
	@PostMapping(value = "/addCatalog")
	public Catalog addData( @RequestBody Catalog ca) {
		return catalog.save(ca);
		
	}
	@GetMapping(value = "/getAllData")
	public List<Catalog> getData() {
		return catalog.findAll();
		
	}
	@PutMapping("/updateCatalog/{id}")
	public CatalogRequest updateCatalog(@RequestBody CatalogRequest catalog,@PathVariable("id") int id){
		return catalogService.updateCatalog(catalog, id);
		
	}
	@DeleteMapping("/deleteCatalog/{id}")
	public String deleteCatalog(@PathVariable ("id") int id) {
		catalog.deleteById(id);
		return "Deleted";
		
	}
}
