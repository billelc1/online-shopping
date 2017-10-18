package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categorydao;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categorydao = (CategoryDAO)context.getBean("categorydao");
	}
	
//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		
//		category.setName("Laptop");
//		category.setDescription("This is some description for laptop!");
//		category.setImageURL("CAT_105.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categorydao.add(category));
//		
//		
//	}
	
//@Test
//public void testGetCategory(){
//	
//	category = categorydao.get(1);
//	
//	assertEquals("Successfully get fetched a single category","Laptop",category.getName());
//	
//	
//}

//	@Test
//	public void testUpdateCategory() {
//		
//		category = categorydao.get(1);
//		
//		category.setName("Laptop9");
//		category.setDescription("This is some description for laptop9!");
//		category.setImageURL("CAT_109.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categorydao.update(category));
//		
//		
//	}
	
	
//	@Test
//	public void testDeleteCategory() {
//		
//		category = categorydao.get(3);
//		
//		
//		
//		assertEquals("Successfully deleted a category inside the table!",true,categorydao.delete(category));
//		
//		
//	}


	@Test
	public void testListCategory() {
		
		

		assertEquals("Successfully fetched a list of category inside the table!",2,categorydao.list().size());
		
		
	}

}