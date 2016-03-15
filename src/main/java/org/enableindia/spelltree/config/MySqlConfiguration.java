package org.enableindia.spelltree.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Represents the configuration for JDBC connection attributes
 *
 */
@Configuration
public class MySqlConfiguration {

	@Resource
	private MySqlConfigParams mySqlConfigParams;

	@Bean
	public BasicDataSource dataSource() throws Exception {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(mySqlConfigParams.getUrl());
		dataSource.setDriverClassName(mySqlConfigParams.getDriverClassName());
		dataSource.setUsername(mySqlConfigParams.getUsername());
		dataSource.setPassword(mySqlConfigParams.getPassword());
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		return new JdbcTemplate(dataSource());
	}
}