package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categorydao;

	@RequestMapping(value = {"/","/home","index"})
	public ModelAndView index()
	{
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","Home");
	mv.addObject("categories",categorydao.list());
	mv.addObject("userClickHome",true);
	return mv;
		
	}
	@RequestMapping(value= "/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
		
	}
	@RequestMapping(value= "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
		
	}
	
	/*all products*/
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts()
	{
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title","All products");
	
	/*passing the list of categories*/
	mv.addObject("categories",categorydao.list());
	
	mv.addObject("userClickAllProducts",true);
	return mv;
		
	}
	/*products by category*/
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
	ModelAndView mv = new ModelAndView("page");
	Category category = null;
	category = categorydao.get(id);
	
	mv.addObject("title",category.getName());
	/*passing the list of categories*/
	mv.addObject("categories",categorydao.list());
	/*passing a single category */
	mv.addObject("category",category);
	
	
	mv.addObject("userClickCategoryProducts",true);
	return mv;
		
	}
	
	
	
}
