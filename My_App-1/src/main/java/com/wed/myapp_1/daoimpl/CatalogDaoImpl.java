package com.wed.myapp_1.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wed.myapp_1.dao.CatalogDao;
import com.wed.myapp_1.request.CatalogRequest;
@Repository
public class CatalogDaoImpl implements CatalogDao{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private String update_Ctalog = "update  catalog Set name =:name  , parent_catalog_id=:pid where catalog_id=:id";
	
	@Override
	public CatalogRequest updateCatalog(CatalogRequest catalog, int id) {
		MapSqlParameterSource mps = new MapSqlParameterSource();
		mps.addValue("name", catalog.getName());
		mps.addValue("pid", catalog.getParentCatalogId());
		mps.addValue("id", id);
		namedParameterJdbcTemplate.update(update_Ctalog, mps);
		return catalog;
	}

}
