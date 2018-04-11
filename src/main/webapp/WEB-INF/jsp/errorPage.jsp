        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
        <html xmlns:background="http://java.sun.com/xml/ns/javaee">
        <head>
        <title>ERROR</title>
            <%@ include file="/WEB-INF/jspf/siteHeader.jspf"%>
        </head>
        <body>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <nav class="navbar navbar-inverse">
            <div class="container-fluid">
            <div class="navbar-header">
            </div>
            </div>
            </nav>

        <div class="container">
        <div class="row">
        <div class="col-md-offset-3 col-md-9">
        <a type="#" class="btn btn-danger btn-block"><h4>This is Error page!</h4></a>
        <h4>${exceptionMessage}</h4>
        </div>
        </div>
        </div>

            <%@ include file="/WEB-INF/jspf/siteFooter.jspf"%>