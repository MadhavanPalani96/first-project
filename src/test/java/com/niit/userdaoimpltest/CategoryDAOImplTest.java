package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;


import junit.framework.TestCase;

public class CategoryDAOImplTest extends TestCase {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
 	 CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	public void testFindAllCategorys()
	{
		List<Category> categoryList=categoryDAO.findAllCategorys();
		assertNotNull(categoryList);
	}

	public void testFindCategoryById()
	{
		Category category1=categoryDAO.findCategoryById(11);
		assertNotNull(category1);
		int expectedId=11;
		int actualId=category1.getCategoryId();
		assertTrue(expectedId==actualId);
	}

	public void testFindCategoryByName() 
	{
		Category category2=categoryDAO.findCategoryByName("kids");
		assertNotNull(category2);
		String expectedName="kids";
		String actualName=category2.getCategoryName();
		assertTrue(expectedName.equals(actualName));
		
	}

	public void testAddCategory() 
	{
		Category category=new Category();
		category.setCategoryId(14);
		category.setCategoryName("women");
		
		
		assertEquals(true,categoryDAO.addCategory(category));
	}

	public void testUpdateCategory() 
	{
		Category category3=categoryDAO.findCategoryById(11);
		category3.setCategoryName("Men");
		
		assertTrue(category3.getCategoryName().equals("Men"));
	}

	public void testDeleteCategory()
	{
		Category category4=categoryDAO.findCategoryById(17);
		assertEquals(true,categoryDAO.deleteCategory(category4.getCategoryId()));
	}

}
