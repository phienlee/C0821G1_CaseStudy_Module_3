<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12/9/2021
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management</title>
</head>
<body>
<div align="center">
<a href="customers">Back to list</a>
    <form method="post" action="customers">
        <input type="hidden" name="action" value="create">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Type Id:</th>
                <td>
                    <input type="text" name="customerType" id="customerType" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>BirthDay:</th>
                <td>
                    <input type="text" name="birthDay" id="birthDay" size="45"/>
                </td>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
