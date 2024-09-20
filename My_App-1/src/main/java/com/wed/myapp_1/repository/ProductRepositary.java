package com.wed.myapp_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.wed.myapp_1.common.Product;

@Repository
public interface ProductRepositary extends JpaRepository<Product, Integer>{

}
