
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <c:url value="/login" var="loginUrl"/>  
    <form action="${loginUrl}" method="post">         
        <c:if test="${param.error != null}">          
            <p>  
                Invalid username and password.  
            </p>  
        </c:if>  
        <c:if test="${param.logout != null}">         
            <p>  
                You have been logged out.  
            </p>  
        </c:if>  
        <p>  
            <label for="username">Your Username</label>  
            <input type="text" id="username" name="username"/>      
        </p>  
        <p>  
            <label for="password">Your Password</label>  
            <input type="password" id="password" name="password"/>      
        </p>  
        <input type="hidden"                          
            name="${_csrf.parameterName}"  
            value="${_csrf.token}"/>  
        <button type="submit" class="btn">Log in</button>  
        
      
    </form>  
     
</body>
</html>