<%@ page import ="java.sql.*, java.io.*,java.util.*,org.json.JSONArray,org.json.*,org.json.simple.JSONObject.*" %>
<html>
<body><center><br>
<br>

<%JSONObject obj=(JSONObject)request.getAttribute("object1");%>
<%=obj.getString("THANKS")%>
<br>
<br>
<h4> WOULD YOU LIKE TO CONTINUE ...</h4>
<form  action="Transaction.jsp"  method="post">
<br>
<input type="Submit"  value ="   ANOTHER TRANSACTION  " >
<br>
</form>
<h4>WANNA  EXIT </h4>
<form action="index.jsp" method ="post">
<br><%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");%>
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