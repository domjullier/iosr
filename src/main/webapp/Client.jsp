<%@ page import="servlet.*"%>
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
<c:forEach items="${students.testIndexes}" var="index">
    <p>${index}</p>
</c:forEach>




</body>
</html>