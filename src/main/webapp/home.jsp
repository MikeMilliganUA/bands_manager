<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <script>
        function sendDeleteByIdRequest(id) {
            $.ajax({
                url: '/bands_manager_war/band?id=' + id,
                method: 'DELETE'
            }).done(function () {
                location.reload();
            });
        }
    </script>
    <title>
        Bands Manager
    </title>
</head>

<body>
<div class="ui main text container">
    <a href="createNewBand.jsp"  class="ui button">Add new band</a>
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
        <c:forEach var="band" items="${allBands}">
            <tr>
                <td class="center aligned">${band.id}</td>
                <td>
                    <a href="/bands_manager_war/band?id=${band.id}">
                        <strong>${band.name}</strong>
                    </a>
                </td>
                <td>${band.country}</td>
                <td>
                    <a href="/bands_manager_war/genre?genre=${band.genre}">
                    <div class="ui horizontal label">${band.genre}</div>
                    </a>
                </td>
                <td>${band.year}</td>
                <td>
                    <div class="ui small basic icon buttons">
                        <button class="negative ui button" onclick="sendDeleteByIdRequest('${band.id}')">
                            <i class="trash icon"></i>
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
