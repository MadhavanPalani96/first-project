package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Supplier;


import junit.framework.TestCase;

public class SupplierDAOImplTest extends TestCase 
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 	 SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

 	 public void testFindAllSuppliers() 
 	 {
 		List<Supplier> supplierList=supplierDAO.findAllSuppliers();
		assertNotNull(supplierList);
		
	}

	public void testFindSupplierById()
	{
		Supplier supplier1=supplierDAO.findSupplierById(1);
		assertNotNull(supplier1);
		int expectedId=1;
		int actualId=supplier1.getSupplierId();
		assertTrue(expectedId==actualId);
	}

	public void testFindSupplierByName() 
	{
		Supplier supplier2=supplierDAO.findSupplierByName("derby");
		assertNotNull(supplier2);
		String expectedName="derby";
		String actualName=supplier2.getSupplierName();
		assertTrue(expectedName.equals(actualName));
		
	}
	public void testAddSupplier() 
	{
		Supplier supplier3=new Supplier();
		supplier3.setSupplierId(9);
		supplier3.setSupplierName("PeterEngland");
		supplier3.setSupplierAddress("england");
		supplier3.setSupplierMailId("peter@gmail.com");
		supplier3.setSupplierMobNo("6578492");
		
		assertEquals(true,supplierDAO.addSupplier(supplier3));
	}

	public void testUpdateSupplier() 
	{
		Supplier supplier4=supplierDAO.findSupplierById(2);
		supplier4.setSupplierAddress("California");
		assertTrue(supplier4.getSupplierAddress().equals("California"));
	}

	public void testDeleteSupplier() 
	{
		Supplier supplier5=supplierDAO.findSupplierById(8);
		assertEquals(true,supplierDAO.deleteSupplier(supplier5.getSupplierId()));
	}

}
