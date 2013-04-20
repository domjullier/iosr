<%@ page import="servlet.*"%>
<html>
<head>
<title>get and set properties Example</title>
</head>
<body>

<jsp:useBean id="students" 
                    class="servlet.TestJSP"> 
   <jsp:setProperty name="students" property="firstName"
                    value="Zara"/>
   <jsp:setProperty name="students" property="lastName" 
                    value="Ali"/>
   
</jsp:useBean>

<p>Student First Name: 
   <jsp:getProperty name="students" property="firstName"/>
</p>
<p>Student Last Name: 
   <jsp:getProperty name="students" property="lastName"/>
</p>
<p>Student Age: 
   <jsp:getProperty name="students" property="age"/>
</p>

</body>
</html>