package com.bean;

public class ProductBean {

	
	// naming convention optional -> no error
		// when we use framework -> compulsory
		// convention over of the configuration
		// pan -> pna vado -> chokadi
	private int productId;   // productid productid bean-> private can get setter private constructor
	private String name;
	private float price;
	private int qty;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
