package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.Product;

public class ProductDAO {
	Connection con;
	private static ProductDAO instance;
	
	public static ProductDAO getInstance() {
		if(instance == null) instance = new ProductDAO();
		return instance;
	}

	private ProductDAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","ssafy","ssafy");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int registProduct(Product product) {
		String sql = "insert into product(productCode, model, price) value(?,?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, product.getProductCode());
			stmt.setString(2, product.getModel());
			stmt.setInt(3, product.getPrice());
			return stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Product> listProduct() {
		String sql = "select * from product";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery(sql);
			List<Product> list = new ArrayList();
			while(rs.next()) {
				list.add(new Product(rs.getString("model"), rs.getInt("productCode"),rs.getInt("price")));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
