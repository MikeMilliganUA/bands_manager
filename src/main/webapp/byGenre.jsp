<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
    <style>
        body {
            margin-top: 3em;
        }
    </style>
    <title>
        Your Genre
    </title>
</head>
<body>
<div class="ui main text container">

<table class="ui black celled striped table">
        <thead style="text-align:left">
        <tr>
            <th class="center aligned">Id</th>
            <th>Name</th>
            <th>Country</th>
            <th>Genre</th>
            <th>Year</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="band" items="${bands}">
            <tr>
                <td>${band.id}</td>
                <td>${band.name}</td>
                <td>${band.country}</td>
                <td>${band.genre}</td>
                <td>${band.year}</td>
                <td>${band.id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
