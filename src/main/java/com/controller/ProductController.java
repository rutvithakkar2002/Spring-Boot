package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	//new
	@PostMapping("/product")
	public ProductBean saveProduct(@RequestBody ProductBean product)
	{
		System.out.println("Product added");
		System.out.println(product.getName());
		System.out.println(product.getQty());
		System.out.println(product.getPrice());
		System.out.println(product.getProductId());
		
		productDao.insertProduct(product);
		
		return product;//object json
	}
	
	
	@GetMapping("products")
	public List<ProductBean> getAllProducts()
	{
		List<ProductBean> products= productDao.listProducts();
		return products;
	}
	
	@DeleteMapping("/product/{productid}")
	public List<ProductBean> deleteproduct(@PathVariable("productid") int productId)
	{
		productDao.deleteProduct(productId);
		List<ProductBean> products= productDao.listProducts();
		return products;
	}
	
	@GetMapping("/product/{productid}")
	public ProductBean getProductById(@PathVariable("productid") int productId)
	{
		ProductBean productBean=productDao.getProductById(productId);
		return productBean;
		
	}
	
	@PutMapping("/product")
	public ProductBean updateProduct(@RequestBody ProductBean product)
	{
		
		System.out.println(product.getName());
		System.out.println(product.getQty());
		System.out.println(product.getPrice());
		System.out.println(product.getProductId());
		
		productDao.updateProduct(product);
		
		System.out.println("Product Updated..");
		
		return product;//object json
		
		
	}
	
	
}
