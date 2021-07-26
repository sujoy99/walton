package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.internal.OracleTypes;

@Repository
public class DemoDao {

	SimpleJdbcCall getAllStatesJdbcCall;
	SimpleJdbcCall getAllStatesJdbcCall1;
	SimpleJdbcCall getAllStatesJdbcCall2;
	SimpleJdbcCall getAllStatesJdbcCall3;
	
	
	SimpleJdbcCall getAllStatesJdbcCall4;
	SimpleJdbcCall getAllStatesJdbcCall5;
	SimpleJdbcCall getAllStatesJdbcCall6;
	SimpleJdbcCall getAllStatesJdbcCall7;
	
	SimpleJdbcCall getAllStatesJdbcCall8;
	SimpleJdbcCall getAllStatesJdbcCall9;
	SimpleJdbcCall getAllStatesJdbcCall10;
	
	SimpleJdbcCall getAllStatesJdbcCall11;
	SimpleJdbcCall getAllStatesJdbcCall12;
	
	SimpleJdbcCall getAllStatesJdbcCall13;
	SimpleJdbcCall getAllStatesJdbcCall14;

	public DemoDao(DataSource dataSource) {

		this.getAllStatesJdbcCall = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall1 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall2 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall3 = new SimpleJdbcCall(dataSource);
		
		
		this.getAllStatesJdbcCall4 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall5 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall6 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall7 = new SimpleJdbcCall(dataSource);
		
		this.getAllStatesJdbcCall8 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall9 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall10 = new SimpleJdbcCall(dataSource);
		
		this.getAllStatesJdbcCall11 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall12 = new SimpleJdbcCall(dataSource);
		
		this.getAllStatesJdbcCall13 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall14 = new SimpleJdbcCall(dataSource);
	}
	
	
	
//	product list starts 
	
	public ArrayList<Product>listProduct(){
		ArrayList<Product> productList = new ArrayList<>();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall.withCatalogName("DATA_PKG")
											.withProcedureName("PRODUCT_LIST")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute();
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	productList.add(new
		    			Product(Integer.valueOf(jsonData.getString ("ID")), jsonData.getString ("PRODUCT_CODE"),
		    					jsonData.getString ("PRODUCT_NAME"),jsonData.getString ("SELLING_PRICE")));
			}
		    	
		    
		    
		    
		    
		  
		    
		    return productList;
		}
			
		
	}
	
	
//	product list ends

	// proudct insert starts

	public void insertProdcut(Product product) {

		System.out.println(product);
		
		String a = product.getPRODUCT_CODE();
		System.out.println(a);
		String b = product.getPRODUCT_NAME();
		System.out.println(b);
		Double c = Double.valueOf(product.getSELLING_PRICE()) ;
		System.out.println(c);

		

		Map<String, Object> result = getAllStatesJdbcCall1.withCatalogName("DATA_PKG")
				.withProcedureName("PRODUCT_INSERT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(a, b, c);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
	

	}

	// product insert ends
	
//	product single starts 
	
	public Product singleProduct(int id){
		Product product = new Product();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall2.withCatalogName("DATA_PKG")
											.withProcedureName("PRODUCT_SINGLE")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute(id);
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	product = new
		    			Product(Integer.valueOf(jsonData.getString ("ID")), jsonData.getString ("PRODUCT_CODE"),
		    					jsonData.getString ("PRODUCT_NAME"),jsonData.getString ("SELLING_PRICE"));
			}
		    	
		    
		    
		    
		    
		  
		    
		    return product;
		}
			
		
	}
	
	
//	product single ends
	
	// proudct update starts

	public void updateProdcut(Product product) {

		System.out.println(product);
		
		int d = product.getID();
		
		String a = product.getPRODUCT_CODE();
		System.out.println(a);
		String b = product.getPRODUCT_NAME();
		System.out.println(b);
		Double c = Double.valueOf(product.getSELLING_PRICE()) ;
		System.out.println(c);

		

		Map<String, Object> result = getAllStatesJdbcCall3.withCatalogName("DATA_PKG")
				.withProcedureName("PRODUCT_UPDATE")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(d, a, b, c);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
	

	}

	// product update ends
	
//	sales list starts 
	
	public ArrayList<SalesInvoice>listSalesInvoice(){
		ArrayList<SalesInvoice> salesInvoiceList = new ArrayList<>();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall9.withCatalogName("DATA_PKG")
											.withProcedureName("SALES_LIST")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute();
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	salesInvoiceList.add(new
		    			SalesInvoice(Integer.valueOf(jsonData.getString ("ID")), jsonData.getString ("INVOICE_NUM"),
		    					jsonData.getString ("INVOICE_DATE").substring(0, 10),jsonData.getString ("CUSTOMER_NAME"), null));
			}
		    	
		    
		    
		    
		    
		  
		    
		    return salesInvoiceList;
		}
			
		
	}
	
	
//	sales list ends
	
	// sales insert starts

	public int insertSales(SalesInvoice salesInvoice) {

		System.out.println(salesInvoice);
		
		String a = salesInvoice.getINVOICE_NUM();
		System.out.println(a);
		String b = salesInvoice.getINVOICE_DATE();
		System.out.println(b);
		String c = salesInvoice.getCUSTOMER_NAME() ;
		System.out.println(c);

		

		Map<String, Object> result = getAllStatesJdbcCall4.withCatalogName("DATA_PKG")
				.withProcedureName("SALES_INSERT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(a, b, c);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		return Integer.valueOf(out);
	

	}

	// sales insert ends
	
//	 sales single starts 
	
	public SalesInvoice singleSales(int id){
		SalesInvoice salesInvoice = new SalesInvoice();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall5.withCatalogName("DATA_PKG")
											.withProcedureName("SALES_SINGLE")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute(id);
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	salesInvoice = new
		    			SalesInvoice(Integer.valueOf(jsonData.getString ("ID")), jsonData.getString ("INVOICE_NUM"),
		    					jsonData.getString ("INVOICE_DATE"),jsonData.getString ("CUSTOMER_NAME") ,jsonData.getString ("TOTAL_AMT"));
			}
		    	
		    
		    
		    
		    
		  
		    
		    return salesInvoice;
		}
			
		
	}
	
	
//	sales single ends
	
	// sales update starts

	public int editSales(SalesInvoice salesInvoice) {

		System.out.println(salesInvoice);
		
		int d = salesInvoice.getID();
		
		String a = salesInvoice.getINVOICE_NUM();
		System.out.println(a);
		String b = salesInvoice.getINVOICE_DATE();
		System.out.println(b);
		String c = salesInvoice.getCUSTOMER_NAME() ;
		System.out.println(c);

		

		Map<String, Object> result = getAllStatesJdbcCall10.withCatalogName("DATA_PKG")
				.withProcedureName("SALES_UPDATE")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(d, a, b, c);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		return Integer.valueOf(out);
	

	}

	// sales update ends
	
//	SALES DETAIL list starts 
	
	public ArrayList<SalesDetails>listSaleDetail(int id){
		ArrayList<SalesDetails> salesDetailsList = new ArrayList<>();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall7.withCatalogName("DATA_PKG")
											.withProcedureName("SALES_DETAIL")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute(id);
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	salesDetailsList.add(new
		    			SalesDetails(Integer.valueOf(jsonData.getString ("ID")), Integer.valueOf(jsonData.getString ("LINE_NUMBER")),
		    					Integer.valueOf(jsonData.getString ("SALES_INVOICE_ID")),
		    					Integer.valueOf(jsonData.getString ("PRODUCT_ID")),jsonData.getString ("PRODUCT_NAME"),
		    					Integer.valueOf(jsonData.getString ("QUANTITY")),
		    					jsonData.getString ("UNIT_PRICE"),jsonData.getString ("AMOUNT")));
			}
		    	
		    
		    
		    
		    
		  
		    
		    return salesDetailsList;
		}
			
		
	}
	
	
//	SALES DETAIL list ends
	
	// sales detail insert starts

	public void insertSalesdetail(SalesDetails salesDetails) {

		System.out.println(salesDetails);
		
		int a = salesDetails.getLINE_NUMBER();
		System.out.println(a);
		int b = salesDetails.getSALES_INVOICE_ID();
		System.out.println(b);
		int c = salesDetails.getPRODUCT_ID() ;
		System.out.println(c);
		String d = salesDetails.getPRODUCT_NAME() ;
		int e = salesDetails.getQUANTITY() ;
		double f = Double.valueOf(salesDetails.getUNIT_PRICE() );
		double g = Double.valueOf(salesDetails.getAMOUNT() );

		

		Map<String, Object> result = getAllStatesJdbcCall6.withCatalogName("DATA_PKG")
				.withProcedureName("SALES_DETAIL_INSERT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(a, b, c, d, e, f, g);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		
	

	}

	// sales detail insert ends
	
//	 sales DETAIL single starts 
	
	public SalesDetails singleSalesDetail(int id, int n){
		SalesDetails salesDetails = new SalesDetails();{
		
		
		
			
			
			Map<String , Object> result = getAllStatesJdbcCall11.withCatalogName("DATA_PKG")
											.withProcedureName("SALES_DETAIL_SINGLE")
											.declareParameters(
								                    new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR))
								            .execute(id, n);
			
			JSONObject json = new JSONObject(result);
		    String out=json.get("CUR_DATA").toString();
		    JSONArray jsonArray=new JSONArray(out);
		    
		    for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	salesDetails = new
		    			SalesDetails(
		    					Integer.valueOf(jsonData.getString ("ID")), 
		    					Integer.valueOf(jsonData.getString ("LINE_NUMBER")),
		    					Integer.valueOf(jsonData.getString ("SALES_INVOICE_ID")),
		    					Integer.valueOf(jsonData.getString ("PRODUCT_ID")),
		    					null, 
		    					Integer.valueOf(jsonData.getString ("QUANTITY")) ,
		    					jsonData.getString ("UNIT_PRICE"), null);
			}
		    	
		    
		    
		    
		    
		  
		    
		    return salesDetails;
		}
			
		
	}
	
	
//	sales DETAIL single ends
	
	// sales detail UPDATE starts

	public int updateSalesdetail(SalesDetails salesDetails) {

		System.out.println(salesDetails);
		
		int h = salesDetails.getID();
		
		int a = salesDetails.getLINE_NUMBER();
		System.out.println(a);
		int b = salesDetails.getSALES_INVOICE_ID();
		System.out.println(b);
		int c = salesDetails.getPRODUCT_ID() ;
		System.out.println(c);
		String d = salesDetails.getPRODUCT_NAME() ;
		int e = salesDetails.getQUANTITY() ;
		double f = Double.valueOf(salesDetails.getUNIT_PRICE() );
		double g = Double.valueOf(salesDetails.getAMOUNT() );

		

		Map<String, Object> result = getAllStatesJdbcCall12.withCatalogName("DATA_PKG")
				.withProcedureName("SALES_DETAIL_UPDATE")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(h, a, b, c, d, e, f, g);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		return Integer.valueOf(out);
		
		
	

	}

	// sales detail UPDATE ends
	
	// total amount insert starts

	public void finishSalesDetail(int id) {



		

		Map<String, Object> result = getAllStatesJdbcCall8.withCatalogName("DATA_PKG")
				.withProcedureName("UPDATE_TOT_AMT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(id);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		
	

	}

	// total amount insert ends
	
	
//	test insert starts 
	
	

	public int insertTest(SalesInvoice salesInvoice, ArrayList<SalesDetails> salesDetailsList) {

		System.out.println(salesInvoice);
		
		String a = salesInvoice.getINVOICE_NUM();
		System.out.println(a);
		String b = salesInvoice.getINVOICE_DATE();
		System.out.println(b);
		String c = salesInvoice.getCUSTOMER_NAME() ;
		System.out.println(c);
		double d = Double.valueOf(salesInvoice.getTOTAL_AMT());

		

		Map<String, Object> result = getAllStatesJdbcCall13.withCatalogName("DATA_PKG")
				.withProcedureName("SALES_INSERT1")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(a, b, c, d);
		
		JSONObject json = new JSONObject(result);
		String out = json.get("OUTPUT").toString();
		
		System.out.println(out);
		
		
		for(int i=0; i<salesDetailsList.size(); i++) {
			
			int a1 = salesDetailsList.get(i).getLINE_NUMBER();
			System.out.println(a1);
			int b1 = salesDetailsList.get(i).getSALES_INVOICE_ID();
			System.out.println(b1);
			int c1 = salesDetailsList.get(i).getPRODUCT_ID() ;
			System.out.println(c1);
			String d1 = salesDetailsList.get(i).getPRODUCT_NAME() ;
			int e1 = salesDetailsList.get(i).getQUANTITY() ;
			double f1 = Double.valueOf(salesDetailsList.get(i).getUNIT_PRICE() );
			double g1 = Double.valueOf(salesDetailsList.get(i).getAMOUNT() );
			
			Map<String, Object> result1 = getAllStatesJdbcCall6.withCatalogName("DATA_PKG")
					.withProcedureName("SALES_DETAIL_INSERT")
					.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
					.execute(a1, Integer.valueOf(out), c1, d1, e1, f1, g1);
			
			
			
		}
		
		

		

		
		
		return Integer.valueOf(out);
	

	}

	
	
//	test insert ends

}
