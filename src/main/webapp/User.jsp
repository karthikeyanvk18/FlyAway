<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body >
<br>
<a href=Index.jsp style="color:black;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
<br><br>
<h2>User Login</h2>
<div style="border:2px solid black;width:25%;border-radius:20px;padding:20px" align="center" class="w3-container w3-deep-purple">

<form action=User method=post >
    <table >
    <tr>
    <td><label for=email>Email</label><br></td>
    <td><input type="email" name=email id=email /></td>
    </tr>
    <tr>
    <td><label for=pass>Password</label><br></td>
    <td><input type="password" name=password id=pass /></td>
    </tr>
    
    <tr>
    <td ><input type=submit value=Submit /></td>
    <td><input type=reset /></td>
    </tr>
    </table>
	
</form>
</div>
<br><br>
<i>New User-Create account</i>
<h4><a href=RegistrationForm.jsp style="font-size:25;color:red;">Create Account</a></h4>

<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<p style="color:silver;"><%=message %></p>
<%
		session.setAttribute("message", null);
	}
%>
</body>
</html>