package com.wed.myapp_1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.wed.myapp_1.common.Product;
import com.wed.myapp_1.dao.ProductDao;
import com.wed.myapp_1.response.ProductResponce;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public Product updateProduct(Product product, int id) {
		return productDao.updateProduct(product, id);
	}

	public Product getByProductId(int id) {
		return productDao.getByProductId(id);

	}

	public List<ProductResponce> getProductsbyCatalogid(int id) {

		return productDao.getProductsbyCatalogid(id);
	}

}
