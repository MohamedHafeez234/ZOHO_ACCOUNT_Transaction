<%@ page import="java.io.*"%>
<!----- page import="Myapp.index.jsp"----->
<html>
<head>
<title> Account Homepage</title>
</head>
<body><center>
<br><br>
<h3>"Hi hello and welcome to your account  "</h3>
<br>
<br>
ACCOUNT NUMBER: ${accid}
<br>
<br>
ACCOUNT HOLDER NAME : ${accname1}
<br>
<br>
EXISTING BALANCE  : ${balance}
<br>
<br>
<br>
The Time on the Server is <%=new java.util.Date()%><br/>
<br>
<form action="Transaction.jsp"  method="post">
<input type="submit" value=" Make Transaction">
</form>
<br>
<br>
<form action="Transactionhistory"  method="post">
<input type="submit" value="Transaction History">
</form>
</center>
</body>
</html>