<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="students" value="${requestScope.students}" />
<script>
    $(function(){
        $("#students").DataTable();
    })
</script>

<div class="container-fluid">
    <table class="table table-striped table-condensed" id="students">
        <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Courses</th>
            <th>E-mail</th>
            <th>Phone</th>
            <th>Teacher</th>
        </tr>
        </thead>
        <c:forEach items="${students}" var="students">
            <tr>
                <c:set var="id" value="${students.id}"/>
                <c:set var="fName" value="${students.fName}"/>
                <c:set var="lName" value="${students.lName}"/>
                <c:set var="courses" value="${students.courses}"/>
                <c:set var="email" value="${students.email}"/>
                <c:set var="phone" value="${students.phone}"/>
                <td><a href="detaleStudent.do?id=<c:out value="${id}"/>" type="button" class="btn btn-link btn-xs"> Detail </a> </td>
                <td><c:out value="${fName}"/> <c:out value="${lName}"/></td>
                <td>
                    <c:forEach items="${courses}" var="course">
                        <c:out value="${course.title}"/><br />
                    </c:forEach>
                </td>
                <td><c:out value="${email}"/></td>
                <td><c:out value="${phone}"/></td>
                <td>Teacher Name</td>
            </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>
</div>

<%@ include file = "footer.jsp"%>