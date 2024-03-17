package com.springboot.bindings;


import java.util.Objects;

public class Product {
	
	
	private Integer productId;
	private String productName;
	private String productPrice;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productPrice, product.productPrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, productPrice);
	}
}
