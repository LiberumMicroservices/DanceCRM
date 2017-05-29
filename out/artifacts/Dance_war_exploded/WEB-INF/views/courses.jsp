<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file = "header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function(){
        $("#courses").DataTable();
    })
</script>

<c:set var="courses" value="${requestScope.courses}" />

<div class="container-fluid">
    <div id="res"></div><br />
    <a href="#" type="button" class="btn btn-default" onclick="newCourse()"> New course </a> <br /><br />
    <div id="newCourse" style="display: none;">
        <div class="col-xs-2" style="padding: 10px;">
            <b>Title:</b> <br />
            <input type="text" class="form-control" id="title"><br />

            <b>Subtitle:</b><br />
            <input type="text" class="form-control" id="subtitle"><br />

            <b>Description:</b><br />
            <textarea class="form-control" rows="2" id="description"></textarea><br />

            <b>Price:</b><br />
            <input type="number" class="form-control" id="price" min="0" data-bind="value:replyNumber"><br />

            <!-- Include Required Prerequisites -->
            <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
            <!-- Include Date Range Picker -->
            <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
            <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />

            <b>Date:</b> <input type="text" name="daterange" id="dates" /> <br /><br />
            <script type="text/javascript">
                $(function() {
                    $('input[name="daterange"]').daterangepicker();
                });
            </script>

            <a href="#" type="button" class="btn btn-default" onclick="addCourse()"> Add new </a><br /><br />
        </div>
    </div>

    <table class="table table-striped table-condensed" id="courses">
        <thead>
        <tr>
            <th></th>
            <th>Course</th>
            <th>Start course</th>
            <th>End course</th>
            <th>Price</th>
            <th>Teacher</th>
        </tr>
        </thead>
        <c:forEach items="${courses}" var="course">
            <tr>
                <c:set var="title" value="${course.title}"/>
                <c:set var="start" value="${course.startDate}"/>
                <c:set var="end" value="${course.endDate}"/>
                <c:set var="price" value="${course.price}"/>
                <td><a href="detaleCourse.do?title=<c:out value="${title}"/>" type="button" class="btn btn-link btn-xs"> Detail </a> </td>
                <td><c:out value="${title}"/></td>
                <td><c:out value="${start}"/></td>
                <td><c:out value="${end}"/></td>
                <td><c:out value="${price}"/></td>
                <td>Teacher</td>
            </tr>
        </c:forEach>
        <tbody>

        </tbody>
    </table>
</div>

<script>
    function newCourse(){
        var current = document.getElementById("newCourse").getAttribute("style");
        if(current == 'display: none;') {
            document.getElementById("newCourse").style.display = 'block';
        }else {
            document.getElementById("newCourse").style.display = 'none';
        }
    }

    function addCourseData(){
        var title = document.getElementById("title").value;
        var subtitle = document.getElementById("subtitle").value;
        var description = document.getElementById("description").value;
        var price = document.getElementById("price").value;
        var dates = document.getElementById("dates").value;

        var body = "title=" + title + "&subtitle=" + subtitle + "&description=" + description
                    + "&price=" + price + "&dates=" + dates;

        return body;
    }

    function addCourse(){
        var body = addCourseData();
        var res = "";
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'courses.do', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send(body); // (1)
        xhr.onreadystatechange = function() { // (3)
            if (xhr.readyState != 4) return;

            if (xhr.status != 200) {
                alert(xhr.status + ': ' + xhr.statusText);
            } else {
                res = xhr.responseText;
                document.getElementById("res").innerHTML = res;
            }
        }
        document.getElementById("res").innerHTML = 'Loading...'; // (2)
        return res;
    }

</script>

<%@ include file = "footer.jsp"%>