package org.enableindia.spelltree.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.enableindia.spelltree.pojo.Content;
import org.springframework.jdbc.core.RowMapper;

public class ContentMapper implements RowMapper<Content>{

	@Override
	public Content mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Content content = new Content();
		content.setContent_Id(rs.getInt("Content_Id"));
		content.setContent_Example(rs.getString("Content_Example"));
		content.setContent_Link_Id(rs.getString("Content_Link_Id"));
		content.setContent_Meaning(rs.getString("Content_Meaning"));
		content.setContent_String(rs.getString("Content_String"));
		
		return content;
	}

}
