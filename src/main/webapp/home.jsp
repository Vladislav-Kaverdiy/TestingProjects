    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <%@ include file="WEB-INF/jspf/siteHeader.jspf"%>
    </head>
<body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
        <div class="navbar-header">
        <a  class="btn btn-primary btn-lg" href="home.jsp">Home</a>
        <a class="btn btn-success btn-lg navbar-btn" href="servlet.do?command=manageDepartment">List Departments</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
        <a class="btn btn-success btn-lg navbar-btn" href="createDepartment.jsp">Create Department</a>
            <a class="btn btn-success btn-lg navbar-btn" href="test.jsp">Test</a>
        </ul>
        </div>
        </div>
        </nav>


        <div class="container"a>
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <div class="alert alert-success">
                <h1>Welcome to the test site</h1>
            </div>
        </div>
    </div>
</div>

<%@ include file="WEB-INF/jspf/siteFooter.jspf"%>