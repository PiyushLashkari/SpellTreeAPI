package org.enableindia.spelltree.service;

import java.util.List;

import org.enableindia.spelltree.dao.ContentMapper;
import org.enableindia.spelltree.pojo.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

	// defining the slf4j Logger Object
	static Logger LOGGER = LoggerFactory.getLogger(ContentService.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Get all the content for a category.
	 * 
	 * @param category id
	 * @return
	 */
	public List<Content> getAllContentForCategory(String categoryId) {
		List<Content> list = jdbcTemplate.query(
				"SELECT Content_Id, Content_String, Content_Meaning, Content_Example, Content_Link_Id FROM Contents, Practice_Test_Mapping "
				+ "where Contents.Content_Link_Id = Practice_Test_Mapping.Exercise_Id "
				+ "AND Practice_Test_Mapping.Category_Id = " + categoryId,
				new ContentMapper());

		return list;
	}
	
	/**
	 * Get all the content for a exercise of a category.
	 * 
	 * @param category id
	 * @param exercise id
	 * @return
	 */
	public List<Content> getAllContentForExerciseOfCategory(String categoryId, String exerciseId) {
		List<Content> list = jdbcTemplate.query("Select * from Contents where Content_Link_Id = " + exerciseId, new ContentMapper());

		return list;
	}
}
