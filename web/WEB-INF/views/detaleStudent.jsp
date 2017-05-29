<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="student" value="${requestScope.student}" />
<c:set var="id" value="${student.id}"/>
<c:set var="fName" value="${student.fName}"/>
<c:set var="lName" value="${student.lName}"/>
<c:set var="courses" value="${student.courses}"/>
<c:set var="email" value="${student.email}"/>
<c:set var="skype" value="${student.skype}"/>
<c:set var="phone" value="${student.phone}"/>
<c:set var="phone2" value="${student.phone2}"/>
<c:set var="birthday" value="${student.birthday}"/>

<div class="container-fluid">
    <b>Name: </b><c:out value="${fName}"/> <c:out value="${lName}"/> <br />
    <b>Courses: </b> | <c:forEach items="${courses}" var="course"><c:out value="${course.title}"/> | </c:forEach> <br />
    <b>E-mail: </b><c:out value="${email}"/> <br />
    <b>Skype: </b><c:out value="${skype}"/> <br />
    <b>Phone 1: </b><c:out value="${phone}"/> <br />
    <b>Phone 2: </b><c:out value="${phone2}"/> <br />
    <b>Birthday: </b><c:out value="${birthday}"/> <br />

    <hr>
</div>
<%@ include file = "footer.jsp"%>