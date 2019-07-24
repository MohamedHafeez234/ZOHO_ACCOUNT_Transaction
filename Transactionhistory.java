import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.json.*; 
import org.json.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import org.json.simple.JSONObject.*;
public class Transactionhistory extends HttpServlet{
private  int cash1;
private String user;
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,NumberFormatException ,NullPointerException {
	try{
		RequestDispatcher rew = request.getRequestDispatcher("/Validate");
		rew.include(request,response);
		ServletContext sc = getServletContext();
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String s=(String)sc.getAttribute("object");
		JSONObject jsonObject = new JSONObject(s);
		user=jsonObject.getString("accname1");
		JSONArray ar=Operation.gettable(user);  		
		request.setAttribute("object2",ar);
		RequestDispatcher rd=request.getRequestDispatcher("/Transactionhistory.jsp");  
		rd.include(request, response);  
	   }

catch(Exception e){
}
}          
}


