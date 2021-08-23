<%--
  Created by IntelliJ IDEA.
  User: rvillarroel
  Date: 8/21/2021
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <title>Class Students</title>
</head>
<body>
<div class="container">

    <h1><spring:message code="menu.tituloApp" /></h1>

    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="../../student"><spring:message code="menu.student" /></a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="../../class"><spring:message code="menu.class" /></a>
        </li>
    </ul>


    <h2> <spring:message code="class.headerTitle" /> </h2>

    <form:form modelAttribute="class">

        <div class="mb-3">
            <label for="InputStudentName" class="form-label"><spring:message code="student.firstname" /></label>
            <form:input path="code"  class="form-control" id="InputStudentName" aria-describedby="codelHelp" value="${editClass.get().code}" readonly="true" />
            <div id="codeHelp" class="form-text">Insert a Class Code</div>
        </div>
        <div class="mb-3">
            <label for="InputStudentLastName" class="form-label"><spring:message code="student.lastname" /></label>
            <form:input path="title" class="form-control" id="InputStudentLastName" value="${editClass.get().title}" readonly="true" />
        </div>
        <div class="mb-3">
            <label for="InputStudentLastName" class="form-label"><spring:message code="student.lastname" /></label>
            <form:input path="description" class="form-control" id="InputStudentLastName" value="${editClass.get().description}" readonly="true" />
        </div>

        <div class="mb-3">
            <form:select path="students">
                <c:forEach var="studentItem" items="${studentList}">
                    <option value="${studentItem.id}">${studentItem.firstName} ${studentItem.lastName}</option>
                </c:forEach>
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">Add Student</button>
    </form:form>

    <h2>Registered Students in the Class</h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Student</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${classStudentList}" var="classStudent">
            <tr>
                <td scope="row">${classStudent.firstName} - ${classStudent.lastName}</td>
                <td scope="row"><a href="student/${classStudent.id}/delete" class="btn btn-danger">Delete</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
