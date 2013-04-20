<%@ page import="servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>get and set properties Example</title>
</head>
<body>

<jsp:useBean id="students" 
                    class="servlet.ClientBean"> 
   
</jsp:useBean>

<c:forEach items="${indexes}" var="index">
    <p>Question: ${index}</p>
</c:forEach>




</body>
</html>