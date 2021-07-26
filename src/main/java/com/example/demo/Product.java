package com.example.demo;

public class Product {

	
	private int ID;
	private String PRODUCT_CODE;
	private String PRODUCT_NAME;
	private String SELLING_PRICE;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int iD, String pRODUCT_CODE, String pRODUCT_NAME, String sELLING_PRICE) {
		super();
		ID = iD;
		PRODUCT_CODE = pRODUCT_CODE;
		PRODUCT_NAME = pRODUCT_NAME;
		SELLING_PRICE = sELLING_PRICE;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}
	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getSELLING_PRICE() {
		return SELLING_PRICE;
	}
	public void setSELLING_PRICE(String sELLING_PRICE) {
		SELLING_PRICE = sELLING_PRICE;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", PRODUCT_CODE=" + PRODUCT_CODE + ", PRODUCT_NAME=" + PRODUCT_NAME
				+ ", SELLING_PRICE=" + SELLING_PRICE + "]";
	}
	
	
	
}
