<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Department</title>
        <%@ include file="/WEB-INF/jspf/siteHeader.jspf"%>
    </head>
<body>
    <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
        <a  class="btn btn-primary btn-lg" href="home.jsp">Home</a>
    </div>
    </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-7">
                <c:if test= "${not empty errors}">
                    <c:forEach var="error" items="${errors}">
                        <div class="alert alert-danger">
                                ${error}
                        </div>
                    </c:forEach>
                </c:if>

        <div class="col-md-offset-3 col-md-9">
            <h2>Please editing Department</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="editDepartment"/>
                <input type="hidden" name="departmentId" value="${departmentId}"/>
                <div class="form-group">
                    <label for="fullName">Full_Name:</label>
                    <input name="fullName" type="text" class="form-control" id="fullName" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label for="importance">Importance(1-10):</label>
                    <input name="importance" type="text" class="form-control" id="importance" placeholder="Enter importance">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4>Edit Department</h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/siteFooter.jspf"%>