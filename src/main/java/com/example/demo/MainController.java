package com.example.demo;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	SimpleJdbcCall getAllStatesJdbcCall99;
	
	@Autowired
	DemoDao demoDao;
	
	

	
	public MainController(DataSource dataSource) {
		this.getAllStatesJdbcCall99 = new SimpleJdbcCall(dataSource);
	}


	@GetMapping("/product")
	public String home(Model model) {
		
		String flag = "0";
		
		Product product = new Product();
		ArrayList<Product> productList = demoDao.listProduct();
		
		model.addAttribute("product", product);
		model.addAttribute("productList", productList);
		model.addAttribute("flag", flag);
		return "product";
	}
	
	
	@PostMapping("/product")
	public String home(Model model, Product product) {
		
		demoDao.insertProdcut(product);
		
		model.addAttribute("product", product);
		return "redirect:/product";
	}
	
	@GetMapping("/product/{id}")
	public String home(@PathVariable("id") int id, Model model) {
		
		String flag = "1";
		
		Product product  = demoDao.singleProduct(id);
		ArrayList<Product> productList = demoDao.listProduct();
		
		model.addAttribute("product", product);
		model.addAttribute("productList", productList);
		model.addAttribute("flag", flag);
		model.addAttribute("id", id);
		return "product";
	}
	
	@PostMapping("/product/{id}")
	public String home_edit(@PathVariable("id") int id, Model model, Product product) {
		
		System.out.println("edit");
		
		product.setID(id);
		demoDao.updateProdcut(product);
		
		return "redirect:/product";
	}
	
	
	@GetMapping("/salesInvoice")
	public String salesInvoice(Model model) {
		
		String flag = "0";
		
		SalesInvoice salesInvoice = new SalesInvoice();
		ArrayList<SalesInvoice> salesInvoiceList = demoDao.listSalesInvoice();
		
		System.out.println(salesInvoiceList);
		
		model.addAttribute("salesInvoice", salesInvoice);
		model.addAttribute("salesInvoiceList", salesInvoiceList);
		model.addAttribute("flag", flag);
		return "salesInvoice";
	}
	
	@PostMapping("/salesInvoice")
	public String salesInvoiceSave(Model model, SalesInvoice salesInvoice) {
		
		int id = demoDao.insertSales(salesInvoice);
		
		return "redirect:/salesDetail/"+id;
	}
	
	@GetMapping("/salesInvoice/{id}")
	public String salesInvoice(@PathVariable("id") int id, Model model) {
		
		String flag = "1";
		
		SalesInvoice salesInvoice  = demoDao.singleSales(id);
		salesInvoice.setINVOICE_DATE(salesInvoice.getINVOICE_DATE().substring(0, 10));
		ArrayList<SalesInvoice> salesInvoiceList = demoDao.listSalesInvoice();
		
		System.out.println(salesInvoiceList);
		
		model.addAttribute("salesInvoice", salesInvoice);
		model.addAttribute("salesInvoiceList", salesInvoiceList);
		model.addAttribute("flag", flag);
		model.addAttribute("id", id);
		
		return "salesInvoice";
	}
	
	@PostMapping("/salesInvoice/{id}")
	public String salesInvoiceEdit(@PathVariable("id") int id, Model model, SalesInvoice salesInvoice) {
		
		salesInvoice.setID(id);
		
		int id1 = demoDao.editSales(salesInvoice);
		
		return "redirect:/salesDetail/"+id1;
	}
	
	@GetMapping("/salesDetail/{id}")
	public String salesDetail(@PathVariable("id") int id, Model model) {
		
		String flag = "0";
		
		SalesInvoice salesInvoice  = demoDao.singleSales(id);
		
		salesInvoice.setINVOICE_DATE(salesInvoice.getINVOICE_DATE().substring(0, 10));
		
		SalesDetails salesDetails = new SalesDetails();
		ArrayList<SalesDetails> salesDetailsList = demoDao.listSaleDetail(id);
		
		ArrayList<Product> productList = demoDao.listProduct();
		
		model.addAttribute("salesInvoice", salesInvoice);
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsList", salesDetailsList);
		model.addAttribute("productList", productList);
		model.addAttribute("id", id);
		model.addAttribute("flag", flag);
		return "salesDetail";
	}
	
	@PostMapping("/salesDetail/{id}")
	public String salesDetailsave(@PathVariable("id") int id, Model model, SalesDetails salesDetails) {
		
		System.out.println("sales");
		
		
		
		salesDetails.setSALES_INVOICE_ID(id);
		
		Product product  = demoDao.singleProduct(salesDetails.getPRODUCT_ID());
		
		salesDetails.setPRODUCT_NAME(product.getPRODUCT_NAME());
		
		salesDetails.setAMOUNT( String.valueOf(( Double.valueOf(salesDetails.getQUANTITY())  * Double.valueOf(salesDetails.getUNIT_PRICE()) ))  );
		
		System.out.println(salesDetails);
		
		demoDao.insertSalesdetail(salesDetails);
		
		return "redirect:/salesDetail/"+id;
	}
	
	@GetMapping("/salesDetailE/{id}")
	public String salesDetailE(@PathVariable("id") String id, Model model) {
		
		String flag = "1";
		
		String[] parts = id.split("_");
		String part1 = parts[0];
		System.out.println(part1);
		String part2 = parts[1]; 
		System.out.println(part2);
		model.addAttribute("id1", part1);
		model.addAttribute("id2", part2);
		
		SalesInvoice salesInvoice  = demoDao.singleSales(Integer.valueOf(part1) );
		
		salesInvoice.setINVOICE_DATE(salesInvoice.getINVOICE_DATE().substring(0, 10));
		
		SalesDetails salesDetails = demoDao.singleSalesDetail(Integer.valueOf(part1), Integer.valueOf(part2) );
		ArrayList<SalesDetails> salesDetailsList = demoDao.listSaleDetail(Integer.valueOf(part1));
		
		ArrayList<Product> productList = demoDao.listProduct();
		
		model.addAttribute("salesInvoice", salesInvoice);
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsList", salesDetailsList);
		model.addAttribute("productList", productList);
		model.addAttribute("id", part1);
		model.addAttribute("flag", flag);
		return "salesDetail";
	}
	
	@PostMapping("/salesDetailE/{id}")
	public String salesDetailE(@PathVariable("id") String id, Model model, SalesDetails salesDetails) {
		
		System.out.println("sales");
		
		String[] parts = id.split("_");
		String part1 = parts[0];
		System.out.println(part1);
		String part2 = parts[1]; 
		System.out.println(part2);
		model.addAttribute("id1", part1);
		model.addAttribute("id2", part2);
		
		
		salesDetails.setID(Integer.valueOf(part2));
		salesDetails.setSALES_INVOICE_ID(Integer.valueOf(part1));
		
		Product product  = demoDao.singleProduct(salesDetails.getPRODUCT_ID());
		
		salesDetails.setPRODUCT_NAME(product.getPRODUCT_NAME());
		
		salesDetails.setAMOUNT( String.valueOf(( Double.valueOf(salesDetails.getQUANTITY())  * Double.valueOf(salesDetails.getUNIT_PRICE()) ))  );
		
		System.out.println("after");
		
		System.out.println(salesDetails);
		
		int i = demoDao.updateSalesdetail(salesDetails);
		
		return "redirect:/salesDetail/"+i;
	}
	
	@GetMapping("/productPrice/{id}")
	@ResponseBody
	public String productPrice(@PathVariable("id") int id, Model model) {
		
		Product product  = demoDao.singleProduct(id);
		
		
		
		return product.getSELLING_PRICE();
	}
	
	@GetMapping("/productName/{id}")
	@ResponseBody
	public String productName(@PathVariable("id") int id, Model model) {
		
		Product product  = demoDao.singleProduct(id);
		
		
		
		return product.getPRODUCT_NAME();
	}
	
	
	@GetMapping("/finish/{id}")
	public String finish(@PathVariable("id") int id, Model model) {
		
		 demoDao.finishSalesDetail(id);
		
		
		
		return "redirect:/salesReport/"+id;
	}
	
	
	
	@GetMapping("/salesReport")
	public String salesReport(Model model) {
		
		ArrayList<SalesInvoice> salesInvoiceList = demoDao.listSalesInvoice();
		
	
		model.addAttribute("salesInvoiceList", salesInvoiceList);
		
		return "salesreport";
	}
	
	@GetMapping("/salesReport/{id}")
	public String salesReportDtl(@PathVariable("id") int id, Model model) {
		
		SalesInvoice salesInvoice  = demoDao.singleSales(id);
		
		
		salesInvoice.setINVOICE_DATE(salesInvoice.getINVOICE_DATE().substring(0, 10));
		ArrayList<SalesDetails> salesDetailsList = demoDao.listSaleDetail(id);
		
	
		model.addAttribute("salesInvoice", salesInvoice);
		model.addAttribute("salesDetailsList", salesDetailsList);
		
		return "salesreportdtl";
	}
	
	
	@GetMapping("/test")
	public String test(Model model) {
		
		ArrayList<Product> productList = demoDao.listProduct();
		
	
		model.addAttribute("productList", productList);
		return "test";
	}
	
	@PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int postResponseJsonContent(
	  @RequestBody String data) {
		
		JSONObject json = new JSONObject(data);
		String out=json.get("OrderNo").toString();
		String out1=json.get("OrderDateString").toString();
		String out2 =json.get("Description").toString();
		String out3=json.get("OrderDetails").toString();
		
		
		System.out.println(json);
		System.out.println(out);
		System.out.println(out1);
		System.out.println(out2);
		System.out.println(out3);
		
		SalesInvoice salesInvoice  = new SalesInvoice();
		
		salesInvoice.setINVOICE_NUM(out);
		salesInvoice.setINVOICE_DATE(out1);
		salesInvoice.setCUSTOMER_NAME(out2);
		
		JSONArray jsonArray=new JSONArray(out3);
		
		ArrayList<SalesDetails> salesDetailsList = new ArrayList<>();
	    
		 for(int i=0;i<jsonArray.length();i++) {
		    	JSONObject jsonData=jsonArray.getJSONObject(i);
		    	salesDetailsList.add(new
		    			SalesDetails(0, Integer.valueOf(jsonData.getInt("Line")),
		    					Integer.valueOf(out),
		    					Integer.valueOf(jsonData.getString ("ProductID")), jsonData.getString ("Name"),
		    					Integer.valueOf(jsonData.getInt("Quantity")),
		    					String.valueOf(jsonData.getDouble("Rate")) , 
		    					String.valueOf((Integer.valueOf(jsonData.getInt ("Quantity")) * Double.valueOf(jsonData.getDouble ("Rate"))))  ));
			}
		 
		 
		 
		 double tot = 0;
		 
		 for(int i=0; i<salesDetailsList.size(); i++) {
			 
			 System.out.println("ok");
			 
			 tot += Double.valueOf(salesDetailsList.get(i).getAMOUNT());
		 }
		 
		 salesInvoice.setTOTAL_AMT(String.valueOf(tot));
		 
		 System.out.println(salesInvoice);
		 System.out.println(salesDetailsList);
		 
		 int n = demoDao.insertTest(salesInvoice, salesDetailsList);
		 
		 return n;
	    
	}
}
