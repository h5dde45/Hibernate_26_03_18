<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Contacts Page</title>

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

        /*.tg .tg-4eph {*/
            /*background-color: #f9f9f9*/
        /*}*/
    </style>
</head>
<body>

<h2>Contacts List</h2>

<c:if test="${!empty listContacts}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="150">
                <a href="/contacts/orderAscFirstName" style="text-decoration: none">First name</a>
            </th>
            <th width="150">Last name</th>
            <th width="150">Birth date</th>
            <th width="150">Version</th>
        </tr>
        <c:forEach items="${listContacts}" var="contact">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.birthDate}</td>
                <td>${contact.version}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Add</h2>

<c:url var="addAction" value="/contacts/add"/>

<form:form action="${addAction}" commandName="contact">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="FirstName"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthDate">
                    <spring:message text="BirthDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthDate" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="version">
                    <spring:message text="Version"/>
                </form:label>
            </td>
            <td>
                <form:input  path="version" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty contact.firstName}">
                    <input type="submit"
                           value="<spring:message text="Edit contact"/>"/>
                </c:if>
                <c:if test="${empty contact.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add contact"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>