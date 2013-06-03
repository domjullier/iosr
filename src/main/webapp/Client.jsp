<%@ page import="servlet.ClientController"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
//Cli
	//ClientBean clientBean = new ClientBean();

//List<String> myIndexes = clientBean.getMyIndexes(request);

@SuppressWarnings("unchecked")
List<String> myIndexes = (List<String>) request.getAttribute("myIndexes");

pageContext.setAttribute("myIndexes", myIndexes);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <!-- General meta information -->
    <title>Broker Client - Main menu </title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <!-- // General meta information -->


    <!-- Load Javascript -->
    <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript" src="./js/jquery.query-2.1.7.js"></script>
    <script type="text/javascript" src="./js/rainbows.js"></script>
    <!-- // Load Javascipt -->

    <!-- Load stylesheets -->
    <link type="text/css" rel="stylesheet" href="css/style.css" media="screen"/>
    <!-- // Load stylesheets -->

    <script type="text/javascript">


        $(document).ready(function () {

        $("#submit1").hover(
        function () {
        $(this).animate({"opacity": "0"}, "slow");
        },
        function () {
        $(this).animate({"opacity": "1"}, "slow");
        });
        });


    </script>

</head>
<body>

<div id="wrapper">
    <div id="wrappertop"></div>

    <div id="wrappermiddle" style="height: auto;">


        <H2><form method="POST" action="/Logout.jsp">
    <input type="submit" value="Logout">
    </form>Welcome <%= request.getRemoteUser() %><br/>Your indexes:</H2>  <br/><br/><br/><br/>
<c:forEach items="${myIndexes}" var="item">
    <FORM METHOD=POST ACTION="ClientSend"><p>
	Enter new value for index ${item}  <INPUT TYPE=TEXT NAME="Value" SIZE=20><BR>
	<input type="hidden" name="index" value=${item} />
	<INPUT TYPE=SUBMIT></p>
</FORM>
</c:forEach>

</div>

    <div id="wrapperbottom"></div>

    <div id="powered">
        <p>Powered by <a href="http://www.premiumfreebies.eu">Premiumfreebies Control Panel</a></p>
    </div>
</div>

</body>
</html>