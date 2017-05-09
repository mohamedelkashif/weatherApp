<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>ADMIN SYSTEM</title>
  
  
  
      
      <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

  
</head>

<body>
  <div class='wrapper'>

  <search>
    <form>
      <input class='searchbar transparent' id='search' type='text' placeholder='enter city, country' />
      <input class='button button-right transparent' id='button' type="submit" value='GO' />
    </form>
  </search>

  <div class='panel'>
    <h2 class='city' id='city'></h2>
    <div class='weather' id='weather'>
      <div class='group secondary'>
        <h3 id='dt'></h3>
        <h3 id='description'></h3>
      </div>
      <div class='group secondary'>
        <h3 id='wind'></h3>
        <h3 id='humidity'></h3>
      </div>
      <div class='temperature' id='temperature'>
        <h1 class='temp' id='temp'><i id='condition'></i> <span id='num'></span><a class='fahrenheit active' id='fahrenheit' href="#">&deg;F</a><span class='divider secondary'>|</span><a class='celsius' id='celsius' href="#">&deg;C</a></h1>
      </div>
      <div class='forecast' id='forecast'></div>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
   </c:if>
   <button class ="button button-right transparent" onclick="document.forms['logoutForm'].submit()">Logout</button>
   <a href = "${contextPath}/addNote" type="button" class ="button button-left transparent">Create Note</a>
  </div>
   
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    
    <script src="${contextPath}/resources/js/index.js"></script>

</body>
</html>
