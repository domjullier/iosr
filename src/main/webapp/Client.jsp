<%@ page import="servlet.ClientBean"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Broker Client - Main menu</title>
</head>
<body>

<jsp:useBean id="students" 
                    class="servlet.ClientBean"> 
   
</jsp:useBean>

<H1>Welcome <%= request.getRemoteUser() %></H1><br>

<p>You can change the following indexes:<p>
<c:forEach items="${students.testIndexes}" var="testindex">
    <p>${testindex}</p>
</c:forEach>

<p>All available indexes:<p>
<c:forEach items="${students.indexes}" var="index">
    <p>${index}</p>
</c:forEach>

<%
ClientBean clientBean = new ClientBean();
List<String> myIndexes = (clientBean.getMyIndexes(request));
for( Iterator i = myIndexes.iterator() ; i.hasNext(); ) {
	   out.println( (String) i.next() );
}
%>



<p>My indexes:<p>
<c:forEach items=myIndexes var="index">
    <p>${index}</p>
</c:forEach>







</body>
</html>