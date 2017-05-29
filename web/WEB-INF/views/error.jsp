<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="error" value="${requestScope.error}" />
<div class="container-fluid">

    <h3 style="color: cornflowerblue">Sory, good luck next time (:</h3><br />

    <b>Detale:</b><br />
    <c:out value="${error}" />

</div>

<%@ include file = "footer.jsp"%>