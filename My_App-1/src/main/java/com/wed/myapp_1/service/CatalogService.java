package com.wed.myapp_1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wed.myapp_1.dao.CatalogDao;
import com.wed.myapp_1.request.CatalogRequest;

@Service
public class CatalogService  {
	
	@Autowired
	private CatalogDao catalogDao;
	
	public CatalogRequest updateCatalog(CatalogRequest catalog, int id) {
		return catalogDao.updateCatalog(catalog, id);
		
	}
}
