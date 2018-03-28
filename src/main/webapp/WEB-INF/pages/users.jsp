<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employees Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
            text-align: center;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>

<h2>Employees List</h2>

<c:if test="${!empty listUsers}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="150">Name</th>
            <th width="150">Id passport</th>
            <th width="150">number</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.passport.id}</td>
                <td>${user.passport.number}</td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${listPassports}" var="passport">
            <tr>
                <td>${passport.user.id}</td>
                <td>${passport.user.name}</td>
                <td>${passport.id}</td>
                <td>${passport.number}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
