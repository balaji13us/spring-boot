package me.bs.java.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Profile("HSQL")
@Configuration
public class DataSourceConfig {
		
	@Bean
	public DataSource dataSource(){
		//jdbc:hsqldb:mem:testdb		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
			.addScript("db/hsqldb/db.sql")
			.build();
		return db;
	}
	
}