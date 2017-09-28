package net.kzn.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("CategoryDAO")
public class CategoryDaoImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("It's a Television Category");
		category.setImageURL("Cat_1.png");

		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("It's a Mobile Category");
		category.setImageURL("Cat_1.png");

		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("laptop");
		category.setDescription("It's a laptop Category");
		category.setImageURL("Cat_1.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for (Category category : categories) {
			if (category.getId() == id)

				return category;

		}

		return null;
	}

}