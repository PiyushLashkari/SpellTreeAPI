package org.enableindia.spelltree.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.enableindia.spelltree.pojo.Category;
import org.springframework.jdbc.core.RowMapper;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Category category = new Category();
		category.setCategory_Id(rs.getInt("Category_Id"));
		category.setCategory_Name(rs.getString("Category_Name"));
		category.setWeight(rs.getInt("Weight"));
		
		return category;
	}
}
