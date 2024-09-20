package com.wed.myapp_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.wed.myapp_1.common.Catalog;

@Repository
public interface CatalogRepositary extends JpaRepository<Catalog, Integer> {

}
