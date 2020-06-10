<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Band</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Add" method="post">
   Name <input type="text" name="name">
    <br><br>
   Country <input type="text" name="country">
    <br><br>
    Genre <input type="text" name="genre">
    <br><br>
    Year <input type="number" name="year">
    <br><br>
    <button type="submit">Add</button>
</form>
</body>
</html>
