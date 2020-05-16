<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bithappens.repository.BandRepository" %>
<%@ page import="com.bithappens.repository.JdbcBandRepository" %>
<%@ page import="com.bithappens.entity.Band" %>
<%@ page import="java.util.List" %>

<%
    BandRepository bandRepository = new JdbcBandRepository();
    List<Band> allBands = bandRepository.findAll();
    request.setAttribute("allBands", allBands);
%>

<html>
    <body>
        <table>
            <thead style="text-align:left">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Genre</th>
                    <th>Year</th>
                    <th>Albums Count</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="band" items="${allBands}">
                    <tr>
                        <td>${band.id}</td>
                        <td>${band.name}</td>
                        <td>${band.country}</td>
                        <td>${band.genre}</td>
                        <td>${band.year}</td>
                        <td>${band.albumsCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
