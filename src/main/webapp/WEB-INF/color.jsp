<%--
  Created by IntelliJ IDEA.
  User: bit
  Date: 5/17/20
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>colors</title>
    </head>
    <body>
        <form name="Form1" action="myTestServlet2">
            <B>Color:</B>
            <select name="color" size="1">
                <option value="Red">Red</option>
                <option value="Green">Green</option>
                <option value="Blue">Blue</option>
            </select>
            <br><br>
            <input type=submit value="Submit">
        </form>
        <a href="/myTestServlet2"></a>
    </body>
</html>
