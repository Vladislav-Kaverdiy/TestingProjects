    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@include file="WEB-INF/jspf/siteHeader.jspf" %>

        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
        <div class="navbar-header">
            <a  class="btn btn-primary btn-lg" href="home.jsp">Home</a>
        </div>
        </div>
        </nav>

        <div class="container">
        <div class="row">
        <div class="col-md-offset-2 col-md-8">
        <table class="table table-striped text-info">
        <thead>
        <tr>
        <th>Full Name</th>
        <th>Importance</th>
        <th>Registration date</th>

        </thead>
        <tbody>
        <c:forEach items="${department}" var="department">
            <tr class="warning">
            <td>${department.fullName}</td>
            <td>${department.importance}</td>
            <td>${department.registerDate}</td>
            <td></td>
            <td><a class="btn btn-success" href="servlet.do?command=showEditDepartment&departmentId=${department.getDepartmentId()}" >Edit</a></td>
            <td><a class="btn btn-success" href="servlet.do?command=showDeleteDepartment&departmentId=${department.getDepartmentId()}" >Delete</a></td>
            <td> <a class="btn btn-success" href="servlet.do?command=manageWorker&departmentId=${department.getDepartmentId()}" >List workers</a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        <div class="col-md-offset-1 col-md-2">
        <a href="createDepartment.jsp" class="btn btn-primary btn-lg">Add new Department</a>
        </div>
        </div>
        </div>
        </div>
        <%@include file="WEB-INF/jspf/siteFooter.jspf" %>