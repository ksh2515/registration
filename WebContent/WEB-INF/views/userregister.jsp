<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
 <div align="center">
  <h1>REGISTRATION FORM</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="background-color: skyblue;margin-left:20px;margin-right:20px;">
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstName" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastName" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="contact" /></td>
    </tr>
   </table>
   <input type="submit" value="Register" />
  </form>
 </div>
</body>
</html>