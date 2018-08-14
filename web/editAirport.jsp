<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Airport" %>
<%@ page import="db.DbProcessor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    Long id = null;
%>
<html>
<head>
    <title></title>
</head>
<body>
<form action="airports" method="post">
    <table>
        <tr><th style="width: 12px;"><th style="width: 12px;"></tr>
        <tr><td><input type='hidden' value="${requestScope.airport.id}" name='id'/></td></tr>
        <tr><label for="airport" style="width: 120px;">Airport</label><input type="text" name="airport" value="${requestScope.airport.airport}"/></tr>
        <tr><label for="city">City</label><input type="text" name="city" value="${requestScope.airport.city}"/></tr>
        <tr><label for="terminal">Terminal</label><input type="text" name="terminal" value="${requestScope.airport.terminals}"/></tr>
    </table>
    <input type="submit"/>
</form>
    <form action='/deleteAirport' method='post'>
    <input type='hidden' value="${requestScope.airport.id}" name='id'/><br>
    <input type='submit' value='Delete'/>
</form>

</body>
</html>
