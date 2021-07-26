package com.example.demo;

public class SalesInvoice {
	
	private int ID;
	private String INVOICE_NUM;
	private String INVOICE_DATE;
	private String CUSTOMER_NAME;
	private String TOTAL_AMT;
	
	
	public SalesInvoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesInvoice(int iD, String iNVOICE_NUM, String iNVOICE_DATE, String cUSTOMER_NAME, String tOTAL_AMT) {
		super();
		ID = iD;
		INVOICE_NUM = iNVOICE_NUM;
		INVOICE_DATE = iNVOICE_DATE;
		CUSTOMER_NAME = cUSTOMER_NAME;
		TOTAL_AMT = tOTAL_AMT;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getINVOICE_NUM() {
		return INVOICE_NUM;
	}
	public void setINVOICE_NUM(String iNVOICE_NUM) {
		INVOICE_NUM = iNVOICE_NUM;
	}
	public String getINVOICE_DATE() {
		return INVOICE_DATE;
	}
	public void setINVOICE_DATE(String iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public String getTOTAL_AMT() {
		return TOTAL_AMT;
	}
	public void setTOTAL_AMT(String tOTAL_AMT) {
		TOTAL_AMT = tOTAL_AMT;
	}
	@Override
	public String toString() {
		return "SalesInvoice [ID=" + ID + ", INVOICE_NUM=" + INVOICE_NUM + ", INVOICE_DATE=" + INVOICE_DATE
				+ ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", TOTAL_AMT=" + TOTAL_AMT + "]";
	}
	
	

}
