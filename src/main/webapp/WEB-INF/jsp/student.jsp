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
<h1> <spring:message code="title" /> </h1>

<div class="container">
    <h1> <spring:message code="student.headerTitle" /> </h1>

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
        <div class="mb-3">
            <label for="InputStudentClass" class="form-label">  <spring:message code="student.class" /></label>
            <form:select path="aclass.id" items="${classList}" itemLabel="code" itemValue="title" class="form-select" id="InputStudentClass" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>


    <table class="table">
        <thead>
        <tr>
            <th scope="col"><spring:message code="student.firstname" /></th>
            <th scope="col"><spring:message code="student.lastname" /></th>
            <th scope="col"><spring:message code="student.class" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td scope="row">${student.firstName}</td>
                <td scope="row">${student.lastName}</td>
                <td scope="row">${student.aclass.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>
