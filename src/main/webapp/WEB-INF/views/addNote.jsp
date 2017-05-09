<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create a note</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style1.css" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Aldrich' rel='stylesheet'>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="noteForm" class="form-signin">
        <h2 class="form-signin-heading">Create a note</h2>
        <img class="relative" src="<c:url value="/resources/images/orange.PNG"/>" /> 
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        	<div class="form-group">
	        	    <spring:bind path="date">
	                <form:input type="text" path="date" class="form-control" placeholder="Date"
	                            autofocus="true"/>
	                </spring:bind>
	            </div>
	            <div class="form-group">
	        	    <spring:bind path="note">
	                <form:input type="text" path="note" class="form-control" placeholder="Note"
	                            autofocus="true"/>
	                </spring:bind>
	            </div>
	     
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
	</form:form>

</div>
<!-- /container -->

</body>
</html>
