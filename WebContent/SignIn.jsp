<%@ page import="dao.AccountDao,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<script> 
function validate()
{ 
     var email = document.form.email.value; 
     var password = document.form.password.value;
 
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}
</script> 
</head>
<body>
    <iframe src="header.html" id="header" frameBorder="0"></iframe>
    <h1>Login </h1> </div>
    <br>
    <form name="form" action="AccoundDao" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td>Email</td>
         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="text" name="password" /></td>
         </tr>
         <tr> 
         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="SignIn"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
</body>
</html>
