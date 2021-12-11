<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.myServlet.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--prefix = "c" доступны все теги jsp через префекс CИ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--// форма для регистрации--%>
<%--// method="post" метод который будет использаван--%>
<%--// action="signUp" отпровлят в сервлет в метод doPost--%>

<div class="form-style-2">
    <form method="post" action="signUp">
        <label for="name">User name
            <input type="text" id="name" name="name">
        </label>
        <label for="birthDate">Birth date
            <input type="text" id="birthDate" name="birthDate">
        </label>
        <label for="password">Password
            <input type="text" id="password" name="password">
        </label>
        <input type="submit" name="Sign Up">
    </form>
</div>
<div class="form-style-2">
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
</div>
</body>
</html>