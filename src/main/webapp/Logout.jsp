<%@page import="java.util.*" %>

<%session.invalidate();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


    <!-- General meta information -->
    <title>Logout</title>
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

    <div id="wrappermiddle">

        <h2>You have logged out.</h2> <br/> <br/> <br/>

        <p>Please <a href="index.html"><b>Login</b></a></p>
    </div>

    <div id="wrapperbottom"></div>

    <div id="powered">
        <p>Powered by <a href="http://www.premiumfreebies.eu">Premiumfreebies Control Panel</a></p>
    </div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
</body>
</html>