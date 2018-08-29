package storedProcedures;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleTypes;

@Component("daonew")
public class ProcedureDaoNew  implements ProcedureDaoInterface{

	
	@Autowired
	  private SimpleJdbcCall jt;
		
		public Customer getCustomerprodure(int sid,int hash){
			Customer c=new Customer();
			
	jt.withProcedureName("customerprocedure").
	 declareParameters(
			     new SqlParameter("cid",Types.INTEGER),
			     new SqlParameter("hashvalue",Types.INTEGER),
			       new SqlOutParameter("paramoutput", OracleTypes.CURSOR,new RowMapper<Customer>() {

					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						
						c.setCid(rs.getInt(1));
						c.setFirstname(rs.getString(3));
						c.setLastname(rs.getString(5));
						return c;
					}
				}));
											
					
			

	       Map<String, Object> map=new HashMap<>();
	       map.put("cid", sid);
	       map.put("hashvalue", hash);
	       Map<String, Object> map1=  jt.execute(map);
	                  
			return c;
		}

}
