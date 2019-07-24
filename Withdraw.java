import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.*;
import  org.json.*; 
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import org.json.simple.JSONObject.*;
public class Withdraw extends HttpServlet{
int accountNo;
Connection connect ;
private int balance;
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
		cash1=Integer.parseInt(request.getParameter("cashwithdraw"));
		connect =ConnectionManager.getConnection();
		String s=(String)sc.getAttribute("object");
		JSONObject jsonObject = new JSONObject(s);
		connect =ConnectionManager.getConnection();
		accountNo=(int)jsonObject.get("accid");
		user=(String)jsonObject.get("accname1");
	    balance=Operation.calcbalance(user);
		balance = balance - cash1;
		boolean time=Operation.gettimeupdate(user,cash1,"Withdrawal");
		JSONObject json = new JSONObject();
		boolean update =Operation.updatebal(balance,accountNo);
		if(update==true){
		sc.setAttribute("balance",balance);
		String  sr=cash1 +"  is withdrawn   "+ "in the Account no :"+ accountNo +" Your current balance is :" +balance+" \n Successfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",sr); 
		request.setAttribute("object1",json);
		}else{
		String th="UnSuccessfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",th); 
		request.setAttribute("object1",json);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/Endpage.jsp");  
		rd.include(request, response);  
	   }

catch(Exception e){
}
}          
}


