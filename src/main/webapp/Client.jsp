<%@ page import="servlet.ClientBean"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
//ClientBean clientBean = new ClientBean();

//List<String> myIndexes = clientBean.getMyIndexes(request);

@SuppressWarnings("unchecked")
List<String> myIndexes = (List<String>) request.getAttribute("myIndexes");

pageContext.setAttribute("myIndexes", myIndexes);
%>

<html>
<head>
<title>Broker Client - Main menu </title>
</head>
<body>

<jsp:useBean id="students" 
                    class="servlet.ClientBean"> 
   
</jsp:useBean>
<form method="POST" action="/Logout.jsp">  
 <input type="submit" value="Logout">  
</form>

<H1>Welcome <%= request.getRemoteUser() %></H1><br>


<H2>Your indexes:</H2>
<c:forEach items="${myIndexes}" var="item">
    ${item} <br />
    <FORM METHOD=POST ACTION="ClientSend">
	Enter new value for index ${item}  <INPUT TYPE=TEXT NAME="Value" SIZE=20><BR>
	<input type="hidden" name="index" value=${item} />
	<P><INPUT TYPE=SUBMIT>
</FORM>
</c:forEach>
<p>end<p>






</body>
</html>