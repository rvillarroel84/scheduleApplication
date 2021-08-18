<%--
  Created by IntelliJ IDEA.
  User: rvillarroel
  Date: 8/17/2021
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Register Student</title>
</head>
<body>
<h1> <spring:message code="title" /> </h1>

<form:form modelAttribute="student">
    <table>
        <tr>
            <td>
                <spring:message code="student.firstname" />
            </td>
            <td>
                <form:input path="firstName" />
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="student.lastname" />
            </td>
            <td>
                <form:input path="lastName" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value=<spring:message code="save.changes"/> >
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
