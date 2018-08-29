package storedProcedures;


import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleTypes;


@Component("dao")
public class ProcedureDao implements ProcedureDaoInterface{
	@Autowired
  private SimpleJdbcCall jt;
	
	
	@Override
	public Customer getCustomerprodure(int sid,int hash){
		
		
		Customer c=new Customer();
		
jt.withProcedureName("customerprocedure").
 declareParameters(
		     new SqlParameter("cid",Types.INTEGER),
		     new SqlParameter("hashvalue",Types.INTEGER),
		       new SqlOutParameter("paramoutput", OracleTypes.CURSOR));

       Map<String, Object> map=new HashMap<>();
       map.put("cid", sid);
       map.put("hashvalue", hash);
       Map<String, Object> map1=  jt.execute(map);
       //This is retriving cursor object(i.e is table data)
                  List<Map<String,Object>> list =  (List<Map<String, Object>>) map1.get("paramoutput");
                 System.out.println(list);
                  Map<String,Object> map5=list.get(0);
                  //this will return all keys present in the table(cursour)
                  System.out.println(map5.keySet());
                  
                  System.out.println(map5.get("id"));
                  //retriving values from map
                  
                  c.setCid(Integer.parseInt(map5.get("id").toString()));
                  c.setFirstname((String)map5.get("firstname"));
                  c.setLastname((String)map5.get("lname"));
                  //Sysout
                  
     System.out.println(list);
		
		
		return c;
	}




}
