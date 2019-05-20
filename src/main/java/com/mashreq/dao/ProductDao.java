package com.mashreq.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mashreq.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
