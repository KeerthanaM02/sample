<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
</head>
<body>
 <spring:url value="/user/save" var="saveURL" />
 <form:form modelAttribute="userForm" method="post" action="${saveURL }" >
  <form:hidden path="user_name"/>
  <table>
   <tr>
    <td>User Name: </td>
    <td>
     <form:input path="user_name"/>
    </td>
   </tr>
   <tr>
    <td>Email Id: </td>
    <td>
     <form:input path="mail_id"/>
    </td>
   </tr>
   <tr>
    <td>Password: </td>
    <td>
     <form:input path="password"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Submit</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>