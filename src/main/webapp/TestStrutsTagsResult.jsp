<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The result is...</title>
</head>
<body>
	<p>
	<% int i = 0; %>
	<s:iterator value="users" id="usrs">
		<h3><s:property value="#usrs"/><%=i %></h3>
		<% i=i+1; %>
	</s:iterator>
	</p>
</body>
</html>