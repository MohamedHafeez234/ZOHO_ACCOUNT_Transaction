<%@ page import ="java.sql.*, java.io.*,java.util.*,org.json.JSONArray,org.json.*,org.json.simple.JSONObject.*" %>
<html>
<head>
<title> TRANSACTION PAGE</title>
</head>
<body><center><br>
<br>
<h3>  ENTER THE AMOUNT TO BE TRANSFERRED </h3>
<br><br>
<br>
EXISTING BALANCE IN YOUR ACCOUNT : <%=getServletContext().getAttribute("balance")%>
<br>
<br>
BENEFICIARY DETAILS  :<%= getServletContext().getAttribute("beneficiary")%>
 <% JSONArray arr=(JSONArray)getServletContext().getAttribute("beneficiary");%>
<br>
s
<br>
<form  action="Transfer"  method="post"><br>
BENEFICIARY ACCOUNT TO BE TRANSFERRED  : <input list="Accountnumber" name ="num">
  <datalist id="Accountnumber">
 <% for(Integer i = 0; i < arr.length(); i++){%>
    <option value="<%=arr.getJSONObject(i).getString("Number")%>,<%=arr.getJSONObject(i).getString("Name")%>">
<%}%>	</datalist><br><br>
AMOUNT TO BE TRANSFERRED : <input  type="number"  name="transfer" required style="width:250px; height:25px;padding: 10px; LINE-HEIGHT:1.9;"><br>
<br>
<br>
<input type="Submit"  value ="   TRANSFER   " ><br>
<br>
<br>
</form>
<h4>RETURN TO HOME </h4>
<form  action="Homepage.jsp"  method="post">
<br>
<input type="Submit"  value ="  HOME  " >
</form>
</center>
</body>
</html>
