package com.wed.myapp_1.daoimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wed.myapp_1.common.Product;
import com.wed.myapp_1.dao.ProductDao;
import com.wed.myapp_1.response.ProductResponce;
@Repository
public class ProductdaoImpl implements ProductDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String UPDATE_PRODUCT = "update product set product_name=:name ,catalog_id=:cId, description=:description,img_url=:img Where product_id=:pId";
	private String GET_PRODUCTBYID="select * from product  Where product_id=?";
	private String GET_PRODUCTBYCATALOGID="select p.product_id,p.img_url, p.product_name, p.description from product p , catalog c   Where c.catalog_id=? and c.catalog_id=p.catalog_id;";
	@Override
	public Product updateProduct(Product product, int id) {
		MapSqlParameterSource mps = new MapSqlParameterSource();
		mps.addValue("name", product.getProductName());
		mps.addValue("cId", product.getCatalogId());
		mps.addValue("pId", id);
		mps.addValue("description", product.getDescription());
		mps.addValue("img", product.getImgUrl());
		namedParameterJdbcTemplate.update(UPDATE_PRODUCT, mps);
		return product;
	}

	@Override
	public Product getByProductId(int id) {
		
		return jdbcTemplate.queryForObject(GET_PRODUCTBYID, new BeanPropertyRowMapper<>(Product.class), id);
	}

	@Override
	public List<ProductResponce> getProductsbyCatalogid(int id) {
		
		return jdbcTemplate.query(GET_PRODUCTBYCATALOGID, new BeanPropertyRowMapper<>(ProductResponce.class), id);
	}

	

}
