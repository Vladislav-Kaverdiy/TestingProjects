<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Worker</title>
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
            <h2>Please add a new Worker</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="addWorker"/>
                <input type="hidden" name="departmentId" value="${departmentId}"/>
                <div class="form-group">
                    <label for=first>First Name:</label>
                    <input name="firstName" type="text" class="form-control" id="first" placeholder="Enter first name">
                </div>
                <div class="form-group">
                    <label for="last">Last Name:</label>
                    <input name="lastName" type="text" class="form-control" id="last" placeholder="Enter last name">
                </div>
                <div class="form-group">
                    <label for="a">Age:</label>
                    <input  name="age" type="text" class="form-control" id="a" placeholder="Enter age">
                </div>
                <div class="form-group">
                    <label for="eml">Email (For example: ****@mail/gmail.ru/ua/com)</label>
                    <input name="email" type="text" class="form-control" id="eml" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="ph">Phone Number (For example: 380*********)</label>
                    <input name="phone" type="text" class="form-control" id="ph" placeholder="Enter phone">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4>ADD</h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jspf/siteFooter.jspf"%>