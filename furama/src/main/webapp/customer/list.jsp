<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12/9/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/customers?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.name}"/></td>
<%--                <td><c:out value="${customer.email}"/></td>--%>
<%--                <td><c:out value="${customer.country}"/></td>--%>
<%--                <td><c:out value="${customer.country}"/></td>--%>
<%--                <td><c:out value="${customer.country}"/></td>--%>
<%--                <td><c:out value="${customer.country}"/></td>--%>
<%--                <td><c:out value="${customer.country}"/></td>--%>
                <td>
                    <a href="/customers?action=edit&id=${customer.id}">Edit</a>
                    <a href="/customers?action=delete&id=${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
