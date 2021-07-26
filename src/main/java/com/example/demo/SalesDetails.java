package com.example.demo;

public class SalesDetails {
	
	private int ID;
	private int LINE_NUMBER;
	private int SALES_INVOICE_ID;
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private int QUANTITY;
	private String UNIT_PRICE;
	private String AMOUNT;
	public SalesDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesDetails(int iD, int lINE_NUMBER, int sALES_INVOICE_ID, int pRODUCT_ID, String pRODUCT_NAME,
			int qUANTITY, String uNIT_PRICE, String aMOUNT) {
		super();
		ID = iD;
		LINE_NUMBER = lINE_NUMBER;
		SALES_INVOICE_ID = sALES_INVOICE_ID;
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		QUANTITY = qUANTITY;
		UNIT_PRICE = uNIT_PRICE;
		AMOUNT = aMOUNT;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getLINE_NUMBER() {
		return LINE_NUMBER;
	}
	public void setLINE_NUMBER(int lINE_NUMBER) {
		LINE_NUMBER = lINE_NUMBER;
	}
	public int getSALES_INVOICE_ID() {
		return SALES_INVOICE_ID;
	}
	public void setSALES_INVOICE_ID(int sALES_INVOICE_ID) {
		SALES_INVOICE_ID = sALES_INVOICE_ID;
	}
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public String getUNIT_PRICE() {
		return UNIT_PRICE;
	}
	public void setUNIT_PRICE(String uNIT_PRICE) {
		UNIT_PRICE = uNIT_PRICE;
	}
	public String getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}
	@Override
	public String toString() {
		return "SalesDetails [ID=" + ID + ", LINE_NUMBER=" + LINE_NUMBER + ", SALES_INVOICE_ID=" + SALES_INVOICE_ID
				+ ", PRODUCT_ID=" + PRODUCT_ID + ", PRODUCT_NAME=" + PRODUCT_NAME + ", QUANTITY=" + QUANTITY
				+ ", UNIT_PRICE=" + UNIT_PRICE + ", AMOUNT=" + AMOUNT + "]";
	}
	
	

}
