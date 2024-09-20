package com.wed.myapp_1.request;

public class CatalogRequest {
	private int catalogId;
	private String name;
	private int parentCatalogId;
	
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
	@Override
	public String toString() {
		return "CatalogRequest [catalogId=" + catalogId + ", name=" + name + ", parentCatalogId=" + parentCatalogId
				+ "]";
	}
	
	

}
