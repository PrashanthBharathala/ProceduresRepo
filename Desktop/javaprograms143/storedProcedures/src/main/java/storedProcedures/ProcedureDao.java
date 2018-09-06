package storedProcedures;



import java.sql.Date;
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
       
       Map<String,Object> newmap =   (Map<String, Object>) map1.get("paramoutput");
       
                  List<Map<String,Object>> list =  (List<Map<String, Object>>) map1.get("paramoutput");
                 System.out.println(list);
                  Map<String,Object> map5=list.get(0);
                  //this will return all keys present in the table(cursour)
                  System.out.println(map5.keySet());
                  
                  System.out.println(map5.get("id"));
                  //retriving values from map
                  
                  Customer c1=new Customer();
             
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
               
                  c.setCid(Integer.parseInt(map5.get("id").toString()));
                  c.setFirstname((String)map5.get("firstname"));
                  c.setLastname((String)map5.get("lname"));
                  //Sysout
                  
     System.out.println(list);
		
		
		return c;
	}
	
	


	public DashBoard_Pojo getAllCount(String userid,String role){
		
		
		//Customer c=new Customer();
		
jt.withProcedureName("Hlm_sp_getDashBoard").
 declareParameters(
		     new SqlParameter("P_UserId",Types.VARCHAR),
		     new SqlParameter("P_UserRole",Types.VARCHAR),
		       new SqlOutParameter("P_Cur", OracleTypes.CURSOR),
               new SqlOutParameter("P_Cur1", OracleTypes.CURSOR),
               new SqlOutParameter("P_Cur2", OracleTypes.CURSOR),
               new SqlOutParameter("P_Cur3", OracleTypes.CURSOR));

       Map<String, Object> map=new HashMap<>();
       map.put("P_UserId", userid);
       map.put("P_UserRole", role);
       Map<String, Object> map1=  jt.execute(map);
       
      
             int topiccount=(int)  map1.get("P_Cur");
                 System.out.println(topiccount);
                 
                 
                 int rolecount=(int)  map1.get("P_Cur1");
                 System.out.println(rolecount);
                 
                 int actioncount=(int)  map1.get("P_Cur2");
                 System.out.println(actioncount);
                 
                 int authcount=(int)  map1.get("P_Cur3");
                 System.out.println(authcount);
              DashBoard_Pojo da=new DashBoard_Pojo();
              da.setRuleCount(rolecount);
              da.setTopicCount(topiccount);
              da.setActionCount(actioncount);
              da.setAuthCount(authcount);
                 
               return da;  
                 
               
               //2nd process if above not works
           /*    
               
              
              
               List<Map<String,Object>> list =  (List<Map<String, Object>>) map1.get("P_Cur");
               System.out.println(list);
                 
                  Map<String,Object> map5=list.get(0);
                  //this will return all keys present in the table(cursour)
                  System.out.println(map5.keySet());
                  
                  System.out.println((int)map5.get("TopicCount"));
                  
                  
                   List<Map<String,Object>> list1 =  (List<Map<String, Object>>) map1.get("P_Cur1");
               System.out.println(list1);
                 
                  Map<String,Object> map6=list1.get(0);
                  //this will return all keys present in the table(cursour)
                  System.out.println(map6.keySet());
                  
                  System.out.println(map6.get("TopicCount"));
               
		
		
		 
                 DashBoard_Pojo da=new DashBoard_Pojo();
              da.setRuleCount(rolecount);
              da.setTopicCount((int)map5.get("TopicCount"));
              da.setActionCount(actioncount);
              da.setAuthCount(authcount);
              
		
		return  da;*/
	}


	
	//get last login
	
	
	public Date getLastLogin(String p_userid,String p_sessionid){
		
		
		
		
   jt.withProcedureName("HLCM_SP_GETLASTLOGIN").
 declareParameters(
		     new SqlParameter("p_UserId",Types.VARCHAR),
		     new SqlParameter("p_SessionId",Types.VARCHAR),
		       new SqlOutParameter("p_LoginDate", Types.DATE));

       Map<String, Object> map=new HashMap<>();
       map.put("p_UserId", p_userid);
       map.put("p_SessionId", p_sessionid);
       Map<String, Object> map1=  jt.execute(map);
       //This is retriving cursor object(i.e is table data)
       
 
                  List<Map<String,Object>> list =  (List<Map<String, Object>>) map1.get("p_LoginDate");
                 System.out.println(list);
                  Map<String,Object> map5=list.get(0);
                  //this will return all keys present in the table(cursour)
                  System.out.println(map5.keySet());
                  
                  System.out.println(map5.get("l_TimeofAction"));
                  //retriving values from map
                  
                  Date d=(Date) map5.get("l_TimeofAction");
                  
                 
             
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
               
       
		
		
		return d;
	}
	
	


}
