<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>

        <body>
            <form:form id="regForm" modelAttribute="user" action="registerForm" method="post">

                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userName">Username</form:label>
                        </td>
                        <td>
                            <form:input path="userName" name="userName" id="userName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                          <tr>
                        <td>
                            <form:label path="active">status</form:label>
                        </td>
                        <td>
                            <form:select path="active" name="active" id="active">
                           <form:option value="	1">	Active</form:option>
                           <form:option value="0">Desactive</form:option>
                            </form:select>
                        </td>
                    </tr>  
                    <tr>
                        <td>
                            <form:label path="roles">roles</form:label>
                        </td>
                        <td>
                            <form:select path="roles" name="roles" id="roles">
                            <form:option value="ROLE_ADMIN">ROLE_ADMIN</form:option>
                            <form:option value="ROLE_USER">ROLE_USER</form:option>
                            </form:select>
                        </td>
                    </tr>  
                    <tr>  
                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
            </form:form>

        </body>

        </html>