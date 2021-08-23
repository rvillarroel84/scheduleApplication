<%--
  Created by IntelliJ IDEA.
  User: rvillarroel
  Date: 8/21/2021
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <title><spring:message code="student.headerTitle" /> </title>
</head>
<body>

<div class="container">


    <h1><spring:message code="menu.tituloApp" /></h1>

    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="student"><spring:message code="menu.student" /></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="class"><spring:message code="menu.class" /></a>
        </li>
    </ul>



    <h2> <spring:message code="student.headerTitle" /> </h2>

    <form:form modelAttribute="student">
        <div class="mb-3">
            <label for="InputStudentName" class="form-label"><spring:message code="student.firstname" /></label>
            <form:input path="firstName"  class="form-control" id="InputStudentName" aria-describedby="codelHelp"/>
            <div id="codeHelp" class="form-text">Insert a Class Code</div>
        </div>
        <div class="mb-3">
            <label for="InputStudentLastName" class="form-label"><spring:message code="student.lastname" /></label>
            <form:input path="lastName" class="form-control" id="InputStudentLastName"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <form:form modelAttribute="student" method="get" action="student/search" class="d-flex">
        <form:input path="firstName" class="form-control me-2" placeholder="Search" aria-label="Search"/>
        <button type="submit" class="btn btn-outline-success">Search</button>
    </form:form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col"><spring:message code="student.firstname" /></th>
            <th scope="col"><spring:message code="student.lastname" /></th>

            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
            <th scope="col">Registered</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td scope="row">${student.firstName}</td>
                <td scope="row">${student.lastName}</td>
<%--                <td scope="row">${student.classes}</td>--%>
                <td scope="row"><a href="student/${student.id}/update" class="btn btn-success">Edit</a> </td>
                <td scope="row"><a href="student/${student.id}/delete" class="btn btn-danger">Delete</a> </td>
                <td scope="row"><a href="student/${student.id}/classes" class="btn btn-info">Classes</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
