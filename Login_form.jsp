<%@ page import ="java.sql.*,java.util.*" %>
<html>
<head>
<title>Registration Form</title>
<center><h2>REGISTRATION FORM </h2></center>
</head>
<body><center>
<form action="Register" method="post">
Enter your Account Number :<input type="number" name="accid" required style="width:250px; height:25px;padding: 10px; LINE-HEIGHT:1.3;" ><br><br>
Enter your Account Holder Name : <input type="text" name="accname" required style="width:250px; height:25px;padding: 10px; LINE-HEIGHT:1.3;" ><br><br>
Set up a Minimum Deposit  : <input type="number" name="password" required style="width:250px; height:25px;padding: 10px; LINE-HEIGHT:1.3;"><br><br>
<input type="Submit" name="Submit" value= "REGISTER" style="LINE-HEIGHT:1.3;">

</center>
</body>
</html>
