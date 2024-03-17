package com.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bindings.Product;

import io.swagger.annotations.Api;

@RestController
@Api("this is product details api")
public class WelcomeRestController {

	Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);


	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcome(){
		
		String responsePayload ="Welcome to Ashok It";
		return new ResponseEntity<>(responsePayload, HttpStatus.OK);
	}
	
	@GetMapping("/greet")
	public ResponseEntity<String> getWelcome(@RequestParam("name") String name){
		logger.info("NAME OF BOOK "+name);
		String responsePayload ="Hi "+name +" Good Morning";
		return new ResponseEntity<>(responsePayload, HttpStatus.OK);
	}
	
	@GetMapping("/book/{name}/trainer/{price}")
	public ResponseEntity<String> getWelcome(@PathVariable("name") String name,@PathVariable("price") String price){
		
		String responsePayload ="Book Name is : "+name +" And Book Price is :"+price;

		return new ResponseEntity<>(responsePayload, HttpStatus.OK);
	}
	
	@GetMapping(value="/product", produces= {"application/xml","application/json"})
	public ResponseEntity<Product> getProduct(){
		
		Product product = new Product();
		product.setProductId(101);
		product.setProductName("Samsung");
		product.setProductPrice("200");
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping(value="/products", produces= {"application/xml","application/json"})
	public ResponseEntity<List<Product>> getProductList(){
		
		Product product = new Product();
		product.setProductId(101);
		product.setProductName("Samsung");
		product.setProductPrice("200");
		
		Product product1 = new Product();
		product1.setProductId(102);
		product1.setProductName("Iphone");
		product1.setProductPrice("300");
		
		Product product2 = new Product();
		product2.setProductId(103);
		product2.setProductName("Redmi");
		product2.setProductPrice("250");
		
		return new ResponseEntity<>(Arrays.asList(product,product1,product2), HttpStatus.OK);
	}
	
	@PostMapping(value="/product", consumes= {"application/xml","application/json"})
	public ResponseEntity<String> saveProdcut(@RequestBody Product product){
		
		System.out.println(product);
		
		String msg = "Successfully saved product record";
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	

}
