<%@ page 
		import="jrod.practice.jdbc.JrodJdbcHelper, java.util.List, jrod.practice.jdbc.Account"
		language="java" 
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"
    	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accounts</title>
</head>
<body>
<div id="systemPropertiesExample" style="border: solid 1px; margin: 10px;">
	<h3>Write a JSP to output the values returned by System.getProperty for various system properties such as java.version, java.home, os.name, user.name, user.home, user.dir etc. </h3>
	<table border="all">
		<tr>
			<td>java.version</td>
			<td><%= System.getProperty("java.version") %></td>
		</tr>
		<tr>
			<td>java.home</td>
			<td><%= System.getProperty("java.home") %></td>
		</tr>
		<tr>
			<td>os.name</td>
			<td><%= System.getProperty("os.name") %></td>
		</tr>
		<tr>
			<td>user.name</td>
			<td><%= System.getProperty("user.name") %></td>
		</tr>
		<tr>
			<td>user.home</td>
			<td><%= System.getProperty("user.home") %></td>
		</tr>
		<tr>
			<td>user.dir</td>
			<td><%= System.getProperty("user.dir") %></td>
		</tr>
	</table>
</div> 

<div id="scriptletExample"J style="border: solid 1px; margin: 10px;">
	<h3>Scriptlet Example</h3>
	<% out.println("IP Address: " + request.getRemoteHost()); %>
</div>

All Accounts as of <%= new java.util.Date() %>:<br />

<table border="all">
<%
	List<Account> accounts = JrodJdbcHelper.getAccounts();
	for (Account a : accounts) {
		%>
		<tr>
			<td>
				<%= a.getId() %>
			</td>
			<td>
				<%= a.getName() %>
			</td>
		</tr>
		<%
	}
%>
</table>

</body>
</html>