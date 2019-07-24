import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.json.*; 
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import org.json.simple.JSONObject.*;
public class Transfer extends HttpServlet{
Connection connect ;
int accountNo;
private int balance;
public int bal;
private  int cash1;
public int acctr;
public String accntr;
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
		connect =ConnectionManager.getConnection();
		cash1=Integer.parseInt(request.getParameter("transfer"));
		String sp=request.getParameter("num");
		String []values=sp.split(",");
		acctr=Integer.parseInt(values[0]);
		accntr=values[1];
		bal=Operation.calcbalance(accntr);
		String s=(String)sc.getAttribute("object");
		JSONObject jsonObject = new JSONObject(s);
		accountNo=(int)jsonObject.get("accid");
		user=(String)jsonObject.get("accname1");
	    balance=Operation.calcbalance(user);
		balance = balance - cash1;
		bal = bal + cash1;
		boolean time=Operation.gettransupdate(user,cash1,accntr);
		boolean time1=Operation.gettransupdate(accntr,cash1,user);
		//String st= cash1+"   is transferred  in the Account no :"+ acctr +"<br> Your current balance is :" +balance;
		//json.put("success",st);
		boolean update =Operation.updatebal(balance,accountNo);
		boolean update1 =Operation.updatebal(bal,acctr);
		JSONObject json = new JSONObject();
		if(update==true && update1==true){
		sc.setAttribute("balance",balance);
		String th=cash1+"   is transferred  in the Account no :"+ acctr +"<br> Your current balance is :" +balance+ "   Successfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",th);
		request.setAttribute("object1",json);
		}
		else{
		String th="UnSuccessfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",th);
		request.setAttribute("object1",json);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/Endpage.jsp");  
		rd.include(request, response);  
	   }

catch(InstantiationException | IllegalAccessException |ClassNotFoundException|NumberFormatException| NullPointerException|JSONException e){
}
}          
}


