import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import org.json.*; 
import org.json.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import org.json.simple.JSONObject.*;
public class Operation {
public static Connection connect=null;
public static String user1;
public static int calcbalance(String user){
int balance =0;
try{
		connect=ConnectionManager.getConnection();
		user1=user;
		String sql2="select * from employee.accountdetails where accountname= '"+user1+"'";
		Statement smt =connect.createStatement();
		ResultSet rs= smt.executeQuery(sql2);
		if (rs.next()){
				String query= "select balance from employee.accountdetails where accountname= '"+user1+"'";
    	        Statement stmt  = connect.createStatement();
    			ResultSet r =stmt.executeQuery(query);
    		    r.first();
    	        balance=r.getInt(1);
				
			} 
    }
	catch(Exception e){}
	return balance;
	}
public static boolean updatebal(int balance,int accountNo){
	boolean flag=false;
	try{
		connect=ConnectionManager.getConnection();
		String sql= "UPDATE accountdetails SET balance="+  balance +" WHERE accountno="+accountNo;
		PreparedStatement stmt  = connect.prepareStatement(sql);
		int count =stmt.executeUpdate(sql);
		if(count>0){
			flag=true;
		}else{
			flag=false;
		}
	}catch(Exception e){}
		return flag;
}
public static String valid(int accid , String accname1){
	String acc=null;
	try{
		 connect =ConnectionManager.getConnection();
		String query="Select * from accountdetails where accountno="+accid+" and accountname ='"+accname1+"'";
        Statement ps = connect.createStatement();
        ResultSet re= ps.executeQuery(query);
            if(re.next()){
			acc= re.getString(2);
			}	
	}catch(Exception e){}
	return acc; 
}
public static boolean checkuser(int eid2,String ename,int pwd){
	boolean flag=false;
	try{
		connect=ConnectionManager.getConnection();
		String query="Select * from accountdetails where accountno="+eid2;
        Statement ps = connect.createStatement();
        ResultSet re= ps.executeQuery(query);
		if(re.next()){
		flag=true;
		}else{
			flag=false;
			ps.executeUpdate("insert into accountdetails (accountno,accountname,balance) values ("+eid2+",'"+ename+"',"+pwd+")"); 
		}
	}catch(Exception e){}
	return flag;
}
public static void createuser(String user){
String name =user;
	try{
		connect=ConnectionManager.getConnection();
		String sql="CREATE TABLE `employee`.`"+name+"` (`Amount` INT UNSIGNED NOT NULL,`TimeTrans` DATETIME NOT NULL,`User` VARCHAR(45) NOT NULL,`Type` VARCHAR(20) NOT NULL ,PRIMARY KEY (`Amount`, `TimeTrans`, `User`,`Type`))";
		Statement ps = connect.createStatement();
		ps.executeUpdate(sql);
	}catch(Exception e){
		System.err.format("SQL State: %s", e.getMessage());
	}
}
public static boolean gettimeupdate(String user,int cash,String type){
	boolean flag=false;
	String name=user;
	String method=type;
	int money=cash;
	try{
	SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");  
    Date date = new Date();   
	String time=formatter.format(date);
	connect=ConnectionManager.getConnection();
	Statement ps = connect.createStatement();
	int count=ps.executeUpdate("insert into employee.`"+name+"`  (Amount, TimeTrans, User ,Type ) values ("+money+", '"+time+"','"+name+"','"+method+"')");
	if(count>0){
	flag=true;	
	}
	}
	catch(Exception e){
	}
	return flag;
}
public static  ResultSet gettime(String user){
	ResultSet rs=null;
	try{
	connect=ConnectionManager.getConnection();
    String query="Select time from '"+user+"'";
	Statement ps = connect.createStatement();
	rs =ps.executeQuery(query);
}catch(Exception e){}
return rs;
}
public static JSONArray gettable(String user){
	ResultSet rs =null;
	String name=user;
	JSONArray array =new JSONArray();
	try{
		connect=ConnectionManager.getConnection();
		String sql="Select * from `employee`.`"+name+"` ORDER BY TimeTrans  DESC";
		Statement ps = connect.createStatement();
		 rs =ps.executeQuery(sql);
		 while(rs.next()){
			 JSONObject obj=new JSONObject();
			 obj.put("Amount",rs.getString(1));
			 obj.put("Time",rs.getString(2));
			 obj.put("User",rs.getString(3));
			 obj.put("Type",rs.getString(4));
			 array.put(obj);
		 }
	   }catch(Exception e){}
	return array;
}
public static boolean gettransupdate(String user,int cash,String user1){
	boolean flag=false;
	String name=user;
	String name1=user1;
	int money=cash;
	try{
	SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");  
    Date date = new Date();   
	String time=formatter.format(date);
	connect=ConnectionManager.getConnection();
	Statement ps = connect.createStatement();
	int count=ps.executeUpdate("insert into employee.`"+name+"`  (Amount, TimeTrans, User ,Type) values ("+money+", '"+time+"','"+name1+"','transfer')");
	if(count>0){
	flag=true;	
	}
	}
	catch(Exception e){
	}
	return flag;
}
public static JSONArray getuser(String user){
	ResultSet rs =null;
	String name=user;
	JSONArray array =new JSONArray();
	try{
	connect=ConnectionManager.getConnection();
	String sql="Select * from `employee`.`accountdetails` ";
	Statement ps = connect.createStatement();
	rs =ps.executeQuery(sql);
	while(rs.next()){
		JSONObject obj=new JSONObject();
		if(rs.getString(2).equals(name)){
			continue;
		}
		obj.put("Number",rs.getString(1));
		obj.put("Name",rs.getString(2));
		array.put(obj);
	}
	}catch(Exception e){}
return array;
	}

}

