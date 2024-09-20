package com.wed.myapp_1.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Catalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catalogId;
	private String name;
	private int parentCatalogId;
	private String image;
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentCatalogId() {
		return parentCatalogId;
	}
	public void setParentCatalogId(int parentCatalogId) {
		this.parentCatalogId = parentCatalogId;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Catalog [catalogId=" + catalogId + ", name=" + name + ", parentCatalogId=" + parentCatalogId + "]";
	}
	
	
	

}
