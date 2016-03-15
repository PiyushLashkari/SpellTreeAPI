package org.enableindia.spelltree.service;

import java.util.List;

import org.enableindia.spelltree.dao.CategoryMapper;
import org.enableindia.spelltree.pojo.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	// defining the slf4j Logger Object
	static Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Get list of all the categories.
	 * 
	 * @return
	 */
	public List<Category> getAllCategories() {
		List<Category> list = jdbcTemplate.query("Select * from Category", new CategoryMapper());

		return list;
	}
	
	/**
	 * Get list of all the categories which are recently updated.
	 * 
	 * @return
	 */
	public List<Category> getAllUpdatedCategories() {
		List<Category> list = jdbcTemplate.query("Select * from Category", new CategoryMapper());

		return list;
	}
	
	/**
	 * Get details of a Category.
	 * 
	 * @param category id
	 * @return
	 */
	public Category getCategoryDetails(String id) {
		List<Category> list = jdbcTemplate.query("Select * from Category where Category_Id = " + id, new CategoryMapper());
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
