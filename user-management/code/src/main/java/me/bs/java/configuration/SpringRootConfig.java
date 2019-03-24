package me.bs.java.configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Profile("HSQL")
@Configuration
@Import({DataSourceConfig.class})
@ComponentScan({ "com.mkyong" })
public class SpringRootConfig {
	
	@Autowired
	DataSource dataSource;

	@Bean
	public JdbcTemplate getJdbcTemplate(){
	  return new JdbcTemplate(dataSource);
	}
	
	//default username : sa, password : ''
	@PostConstruct
	public void getDbManager(){
	   //DatabaseManagerSwing.main(
		//new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
	}
}