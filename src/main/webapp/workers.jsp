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
                    <th>First_Name</th>
                    <th>Last_Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Phone_number</th>
                    <th>Registration_date</th>

                </thead>
                <tbody>
                <c:forEach items="${worker}" var="worker">
                    <tr class="warning">
                        <td>${worker.firstName}</td>
                        <td>${worker.lastName}</td>
                        <td>${worker.age}</td>
                        <td>${worker.email}</td>
                        <td>${worker.phone}</td>
                        <td>${worker.registerDate}</td>
                        <td></td>
                        <td><a class="btn btn-success" href="servlet.do?command=showEditWorker&workerId=${worker.getWorkerId()}" >Edit</a></td>
                        <td><a class="btn btn-success" href="servlet.do?command=showDeleteWorker&workerId=${worker.getWorkerId()}" >Delete</a></td>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="col-md-offset-1 col-md-2">
                <a href="servlet.do?command=showWorker&departmentId=${departmentId}" class="btn btn-primary btn-lg">Add new Worker</a>
            </div>
        </div>
    </div>
</div>
<%@include file="WEB-INF/jspf/siteFooter.jspf" %>