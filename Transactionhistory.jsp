<%@ page import ="java.sql.*, java.io.*,java.util.*,org.json.JSONArray,org.json.*,org.json.simple.JSONObject.*" %>
<html>
<body><center><br>
<table border="1px solid #ddd" style="padding:25px ;border-collapse: collapse; width: 80%;Height:40px ;text-align: center">
<tr>
<th>AMOUNT</th>
<th>TIME</th>
<th>TRANSACTION MADE </th>
<th>MODE OF TRANSACTION</th>
</tr>

<%JSONArray arr=(JSONArray)request.getAttribute("object2");
for(Integer i = 0; i < arr.length(); i++){%>
<tr>
<td><%=arr.getJSONObject(i).getString("Amount")%></td>
<td><%=arr.getJSONObject(i).getString("Time")%></td>
<td><%=arr.getJSONObject(i).getString("User")%></td>
<td><%=arr.getJSONObject(i).getString("Type")%></td></tr>
<%}%>
</table>
<br>
<h4> WOULD YOU LIKE TO CONTINUE ...</h4>
<form  action="Transaction.jsp"  method="post">
<br>
<input type="Submit"  value ="   ANOTHER TRANSACTION  " >
<br>
</form>
<h4>WANNA  EXIT </h4>
<form action="index.jsp" method ="post">
<br>
<input type="Submit"  value ="    LOGOUT  " >
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