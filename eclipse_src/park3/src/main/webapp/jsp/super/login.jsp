<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Super User Login</title>
</head>
<body>
<h3>Register for a prize by completing this form.</h3>

<s:form action="doSuperLogin">
<div><s:fielderror fieldName="password"/></div>
 	  <s:textfield name="password" label="password" />
 	  
   	  <s:submit/>
   	  
</s:form>	
 
</body>
</html>