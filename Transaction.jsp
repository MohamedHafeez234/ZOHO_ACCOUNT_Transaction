<%@ page import ="java.sql.*,java.util.*" %>
<html>
<head>
<title> TRANSACTION PAGE</title>
</head>
<body><center><br>
<br>
<h3>  CHOOSE THE TRANSACTION YOU WANNA DO </h3>
<br>
<br>
EXISTING BALANCE  :   ${balance}
<br>
<form  action="deposit.jsp"  method="post">
<br>
<input type="Submit"  value ="    DEPOSIT    " ><br>
<br>
</form>
<form action="withdraw.jsp" method ="post">
<br>
<input type="Submit"  value ="    WITHDRAW    " >
<br>
</form>
<form  action="transfer.jsp"  method="post">
<br>
<input type="Submit"  value ="    TRANSFER   " ><br>
<br>
</form>
<form  action="Homepage.jsp"  method="post">
<br>
<input type="Submit"  value ="  HOME  " >
</form>
</center>
</body>
</html>