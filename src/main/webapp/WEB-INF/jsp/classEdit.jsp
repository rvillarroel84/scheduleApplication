<%--
  Created by IntelliJ IDEA.
  User: rvillarroel
  Date: 8/21/2021
  Time: 8:26 PM
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

    <title>Edit Class</title>
</head>
<body>

<div class="container">


    <h1><spring:message code="menu.tituloApp" /></h1>

    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="student"><spring:message code="menu.student" /></a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="class"><spring:message code="menu.class" /></a>
        </li>
    </ul>

    <h2> <spring:message code="class.headerTitle" /> </h2>

    <form:form modelAttribute="class">
        <div class="mb-3">
            <label for="InputClassCode" class="form-label"><spring:message code="class.code" /></label>
            <form:input path="code" class="form-control" id="InputClassCode" aria-describedby="codelHelp" value="${editClass.get().code}"/>
            <div id="codeHelp" class="form-text">Insert a Class Code</div>
        </div>
        <div class="mb-3">
            <label for="InputTitle" class="form-label"><spring:message code="class.title" /></label>
            <form:input path="title" class="form-control" id="InputTitle" value="${editClass.get().title}"/>
        </div>
        <div class="mb-3">
            <label for="InputDescription" class="form-label">  <spring:message code="class.description" /></label>
            <form:input path="description" class="form-control" id="InputDescription" value="${editClass.get().description}"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
</body>
</html>