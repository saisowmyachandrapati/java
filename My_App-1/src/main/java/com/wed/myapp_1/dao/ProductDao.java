package com.wed.myapp_1.dao;

import java.util.List;


import com.wed.myapp_1.common.Product;
import com.wed.myapp_1.response.ProductResponce;

public interface ProductDao {
	
	public Product updateProduct(Product product, int id) ;
	
	public Product getByProductId(int id);
	
	public List<ProductResponce> getProductsbyCatalogid(int id);
}
