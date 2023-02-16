package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;



@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void insertProduct(ProductBean product) {
		stmt.update("insert into product (name,price,qty) values (?,?,?)",product.getName(),product.getPrice(),product.getQty());
	}

	public List<ProductBean> listProducts() {
		// TODO Auto-generated method stub
		
		List<ProductBean> products = stmt.query("select * from product", new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
		return products;
		
	}

	public void deleteProduct(int productId) {
		
		stmt.update("delete from product where productId=?",productId);
		
	}

	public ProductBean getProductById(int productId) {
		ProductBean productBean=stmt.queryForObject("select * from product where productid=?",new BeanPropertyRowMapper<ProductBean>(ProductBean.class),new Object[] { productId });
		return productBean;
	}

	public void updateProduct(ProductBean product) {
		
		stmt.update("update product set name=? , price=? , qty=? ", product.getName(),product.getPrice(),product.getQty());
		
	}

	
	
	
}
