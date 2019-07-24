import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.json.simple.parser.*;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject.*;
import  org.json.*;
public class Deposit extends HttpServlet{
int accountNo;
Connection connect ;
private int balance;
private  int cash1;
private String user;
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException ,NullPointerException {
	try{
		RequestDispatcher rew = request.getRequestDispatcher("/Validate");
		rew.include(request,response);
		ServletContext sc = getServletContext();
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		try{
		cash1=Integer.parseInt(request.getParameter("cashdeposit"));
		}catch(NumberFormatException e1){
		}
		String s=(String)sc.getAttribute("object");
		JSONObject jsonObject = new JSONObject(s);
		connect =ConnectionManager.getConnection();
		accountNo=(int)jsonObject.get("accid");
		user=(String)jsonObject.get("accname1");
	    balance=Operation.calcbalance(user);
		balance = balance + cash1;
		boolean time=Operation.gettimeupdate(user,cash1 ,"Deposit");
		boolean update =Operation.updatebal(balance,accountNo);
		JSONObject json = new JSONObject();
		if(update==true){
		sc.setAttribute("balance",balance);
		String st=cash1 +"   is deposited   "+ "in the Account no : "+ accountNo +" Your current balance is :" +balance+"Successfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",st);
		request.setAttribute("object1",json);
		}else{
		String th="UnSuccessfully saved your Transaction .....Thank You   "+user;
		json.put("THANKS",th);
		//String sd = JSONValue.toJSONString(json);  
		request.setAttribute("object1",json);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/Endpage.jsp");  
        rd.include(request, response);  
  }

catch(InstantiationException | IllegalAccessException |ClassNotFoundException| NullPointerException |JSONException e){
	
}
}          
}


