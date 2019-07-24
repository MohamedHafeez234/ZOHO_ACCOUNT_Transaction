import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.json.simple.JSONObject.*;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import  org.json.*;
public class Validate extends HttpServlet{
public int accid ;
public String accname1;
public int balance;
Connection connect;
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,NullPointerException {
        try{
		 response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		ServletContext sc = getServletContext();
		accid=Integer.parseInt(request.getParameter("accid"));
        accname1=request.getParameter("accname");
		sc.setAttribute("accid",accid);	
		sc.setAttribute("accname1",accname1);	
	    JSONObject Obj=new JSONObject();    
		Obj.put("accid", accid);
        Obj.put("accname1", accname1);
		String acc1=Operation.valid(accid,accname1);
		String str = JSONValue.toJSONString(Obj);  
		sc.setAttribute("object",str);
		if(accname1.equals(acc1)){		
		balance=Operation.calcbalance(accname1);
		sc.setAttribute("balance",balance);	
		JSONArray user=Operation.getuser(accname1);
		sc.setAttribute("beneficiary",user);
		RequestDispatcher rw =request.getRequestDispatcher("/Homepage.jsp");
		rw.forward(request, response); 			
			}
		else {
			out.println("Sorry AccountName or Account Number Error!");  
			RequestDispatcher rw=request.getRequestDispatcher("/index.jsp");  
			rw.include(request, response);  
				}
		}catch(Exception e){
		}	
}
}