package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.dao.ProductDAO;



public class ProductService {
	ProductDAO productdao;
	private static ProductService instance;

	public static ProductService getInstance() {
		if(instance == null)instance = new ProductService();
		return instance;
	}

	public int registProduct(Product product) {
		return productdao.registProduct(product);
	}
	
	public List<Product> listProduct() {
		return productdao.listProduct();
	}

}
