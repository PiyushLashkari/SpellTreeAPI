package org.enableindia.spelltree.controller;

import java.util.List;

import org.enableindia.spelltree.pojo.Category;
import org.enableindia.spelltree.pojo.Content;
import org.enableindia.spelltree.service.CategoryService;
import org.enableindia.spelltree.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

/**
 * 
 * 
 */
@RestController
@RequestMapping(value = "spelltree/api")
public class Controller {

	// defining the slf4j Logger Object
	static Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ContentService contentService;
	
	/**
	 * Test implementation.
	 * 
	 * @param name
	 * @return returns the value of the path variable passed in.
	 */
	@Timed(name = "test", absolute = true)
	@RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
	public String test(@PathVariable String name) {
		LOGGER.info("test() received params: " + "name: " + name);
		return name;
	}
	
	/**
	 * Get the details of a category.
	 * 
	 * @param category id
	 * @return returns the details of category.
	 */
	@Timed(name = "category-details", absolute = true)
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public Category categoryDetails(@PathVariable String id) {
		
		return categoryService.getCategoryDetails(id);
	}
	
	/**
	 * Get the list of all the categories.
	 * 
	 * @param updated (optional)
	 * @return returns the list of categories.
	 */
	@Timed(name = "category-list", absolute = true)
	@RequestMapping(value = "/category/list", method = RequestMethod.GET)
	public List<Category> categoryList(@RequestParam(value = "updated", required = false) Boolean updated) {
		if(updated != null && updated == true)
			return categoryService.getAllUpdatedCategories();
		else
			return categoryService.getAllCategories();
	}
	
	/**
	 * Get the contents of a category.
	 * 
	 * @param id (category id)
	 * @param exercise id (optional)
	 * @return returns the list of categories.
	 */
	@Timed(name = "content-list", absolute = true)
	@RequestMapping(value = "/category/{id}/content", method = RequestMethod.GET)
	public List<Content> contentList(
			@PathVariable String id,
			@RequestParam(value = "exercise-id", required = false) String exerciseId) {
		if(exerciseId != null)
			return contentService.getAllContentForExerciseOfCategory(id, exerciseId);
		else
			return contentService.getAllContentForCategory(id);
	}

}
