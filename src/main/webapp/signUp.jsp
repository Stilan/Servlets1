<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.myServlet.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--prefix = "c" доступны все теги jsp через префекс CИ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>User name</th>
        <th>Birth Date</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.birthDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>