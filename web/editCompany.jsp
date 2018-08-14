<%--
  Created by IntelliJ IDEA.
  User: Silence
  Date: 24.12.13
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="companies" method="post">
    <table>
        <tr><th style="width: 12px;"><th style="width: 12px;"></tr>
        <tr><td><input type='hidden' value="${requestScope.company.id}" name='id'/></td></tr>
        <tr><label for="name" style="width: 120px;">Name</label><input type="text" name="name" value="${requestScope.company.name}"/></tr>
        <tr><label for="owner">Owner</label><input type="text" name="owner" value="${requestScope.company.owner}"/></tr>
        <tr><label for="country">Country</label><input type="text" name="country" value="${requestScope.company.country}"/></tr>
        <tr><label for="planesQuantity">Planes quantity</label><input type="text" name="planesQuantity" value="${requestScope.company.planesQuantity}"/></tr>
    </table>
    <input type="submit"/>
</form>
<form action='deleteCompany' method='post'>
    <input type='hidden' value="${requestScope.company.id}" name='id'/><br>
    <input type='submit' value='Delete'/>
</form>
</body>
</html>
