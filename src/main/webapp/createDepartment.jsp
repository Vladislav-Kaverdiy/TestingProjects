<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Create Department</title>
    <%@ include file="/WEB-INF/jspf/siteHeader.jspf"%>
</head>


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
            </div>
            <div class="col-md-offset-3 col-md-9">
                <h2>Please create a new Department</h2>
                <form action="servlet.do" method="post" >
                    <input type="hidden" name="command" value="createDepartment"/>
                    <div class="form-group">
                        <label for="fullName">Full Name:</label>
                        <input name="fullName" type="text" class="form-control" id="fullName" placeholder="Enter name">

                    </div>
                    <div class="form-group">
                        <label for="importance">Importance(1-10):</label>
                        <input name="importance" type="text" class="form-control" id="importance" placeholder="Enter importance">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-block" onclick="validate(this.form)"><h4>Create</h4></button>
                    </div>

                </form>


            </div>
        </div>
    </div>

    </div>

        <script>
            function showError(container, errorMessage) {
                container.className = 'error';
                var msgElem = document.createElement('span');
                msgElem.className = "error-message";
                msgElem.innerHTML = errorMessage;
                container.appendChild(msgElem);
            }

            function resetError(container) {
                container.className = '';
                if (container.lastChild.className == "error-message") {
                    container.removeChild(container.lastChild);
                }
            }

            function validate(form) {
                var elems = form.elements;

                resetError(elems.fullName.parentNode);
                if (!elems.fullName.value) {
                    showError(elems.fullName.parentNode, 'Full Name cannot be empty!');
                }

                resetError(elems.importance.parentNode);
                if (!elems.importance.value) {
                    showError(elems.importance.parentNode, 'Importance cannot be empty!');
                }


            }
        </script>


<%@ include file="/WEB-INF/jspf/siteFooter.jspf"%>