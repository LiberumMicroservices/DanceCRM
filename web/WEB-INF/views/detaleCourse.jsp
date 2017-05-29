<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="course" value="${requestScope.course}" />

<div class="container-fluid">
    <b>Title:</b> <c:out value="${course.title}"/> <br />
    <b>Subtitle:</b> <c:out value="${course.subtitle}"/> <br />
    <b>Description:</b> <c:out value="${course.description}"/> <br />
    <b>Start date:</b> <c:out value="${course.startDate}"/> <br />
    <b>End date:</b> <c:out value="${course.endDate}"/> <br />
    <b>Teachers:</b> Max Voloshin, Olga Strelets <br /><br />

    <hr>
    <c:set var="students" value="${course.students}"/>
    <table class="table table-striped table-condensed" id="courses">
        <thead>
        <tr>
            <th>Photo</th>
            <th>Name</th>
            <th>Balance</th>
            <th>Phone</th>
            <th>E-mail</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="students">
            <tr>
                <c:set var="fName" value="${students.fName}"/>
                <c:set var="lName" value="${students.lName}"/>
                <c:set var="phone" value="${students.phone}"/>
                <c:set var="email" value="${students.email}"/>
                <td><img src="img/male.png" width="50"></td>
                <td><c:out value="${fName}"/> <c:out value="${lName}"/></td>
                <td>balance</td>
                <td><c:out value="${phone}"/></td>
                <td><c:out value="${email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</div>

<%@ include file = "footer.jsp"%>