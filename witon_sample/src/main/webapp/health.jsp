<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>health</title>
</head>
<body>
	<h1>Hello World!</h1>
	<p>This is the health page!</p>

	<%
	    out.println("xxxxxxxxxx");
	%>
	<br/>
	<%
	Enumeration<String> headernames = request.getHeaderNames();
	while(headernames.hasMoreElements()){
	    String headername = headernames.nextElement();
	    // out.println(String.format("%s = %s", headername, ""));
	    String str = String.format("%s = %s", headername, request.getHeader(headername));
	    out.println(str);
	%>
	   <br/>
	<%
		System.out.println(str);
	}
	%>



</body>
</html>
