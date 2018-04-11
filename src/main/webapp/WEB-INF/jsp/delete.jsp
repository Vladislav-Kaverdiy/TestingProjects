<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jspf/siteHeader.jspf" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a  class="btn btn-primary btn-lg" href="home.jsp">Home</a>
        </div>
    </div>
</nav>
            <div class="col-md-offset-3 col-md-9">
                <h2>Please write whom you want to remove:</h2>
                <form action="servlet.do" method="post" >
                    <input type="hidden" name="command" value="delete"/>
                    <input type="hidden" name="departmentId" value="${departmentId}"/>
                    <input type="hidden" name="workerId" value="${workerId}"/>
                    <div class="form-group">

                        <input name="delete" type="text" class="form-control" id="delete" placeholder="Enter word">
                    </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success "><h4>Delete</h4></button>
                            </div>
                    </form>

                    <br/>
                </div>
            </div>
        </td>
    </tr>

<%@include file="/WEB-INF/jspf/siteFooter.jspf" %>