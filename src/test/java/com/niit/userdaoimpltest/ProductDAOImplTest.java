package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDAOImplTest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 	 ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
 	 

	public void testAddProduct() {
		Product product=new Product();
		product.setId(4);
		product.setProductName("T-shirt");
		product.setProductDescription("Polo");
		product.setProductSize("x");
		product.setProductQuantity(5);
		product.setProductCost(300);
		assertEquals(true,productDAO.addProduct(product));
	
	}

	public void testFindAllProducts() 
	{
		List<Product> productList=productDAO.findAllProducts();
		assertNotNull(productList);
	}

	public void testFindProductById()
	{
		Product product1=productDAO.findProductById(1);
		assertNotNull(product1);
		int expectedId=1;
		int actualId=product1.getId();
		assertTrue(expectedId==actualId);
	}

	public void testFindProductByName() 
	{

		Product product2=productDAO.findProductByName("shirt");
		assertNotNull(product2);
		String expectedName="shirt";
		String actualName=product2.getProductName();
		assertTrue(expectedName.equals(actualName));
		
	}

	public void testUpdateProduct() 
	{
		Product product3=productDAO.findProductById(1);
		product3.setProductName("PencilFitJean");
		product3.setProductSize("x");
		productDAO.updateProduct(product3);
		assertTrue(product3.getProductSize().equals("x"));
		
	}

	public void testDeleteProduct()
	{
		
		Product product4=productDAO.findProductById(3);
		assertEquals(true,productDAO.deleteProduct(product4.getId()));
	}

}
