<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    
    </head>
    <body>
       <div style="text-align:center">
        <h3>------------Login Page-----------</h3>
     <form  modelAttribute="login" action="login" method="post">
           
           <div class="form-group">
                   <label for="name">Username:</label>
                   <input path="name" type="text" class="form-control" id="name" placeholder="Enter username" name="name">
               </div>
               <div class="form-group">
                   <label for="pwd">Password:</label>
                   <input path="password" type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
               </div>
               <button id="button" type="submit" class="btn btn-primary">Login</button>
           </form>
           ${message}
          </div>
</html>