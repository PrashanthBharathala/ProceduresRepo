package storedProcedures;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("storedProcedures")
public class ProcedureConfig {
	@Bean
	DriverManagerDataSource getDatasource(){
		
		
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("USERNAME");
		ds.setPassword("PASSWORD");
		return ds;
		
	}
	
	@Bean
	SimpleJdbcCall getJdbcCall(){
		
		SimpleJdbcCall jt=new SimpleJdbcCall(getDatasource());
		return jt;
	}

}
