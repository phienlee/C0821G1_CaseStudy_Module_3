<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12/9/2021
  Time: 1:58 PM
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
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=users">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>Customer Type:</th>
                <td>
                    <input type="text" name="customerType" size="45"
                           value="<c:out value='${customer.customerType}' />"
                    />
                </td>
            </tr>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="15"
                           value="<c:out value='${customer.birthday}' />"
                    />
                </td>
                <th>Id Card:</th>
                <td>
                    <input type="text" name="idCard" size="15"
                           value="<c:out value='${customer.idCard}' />"
                    />
                </td>
                <th>Phone:</th>
                <td>
                    <input type="text" name="phone" size="15"
                           value="<c:out value='${customer.phone}' />"
                    />
                </td>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="15"
                           value="<c:out value='${customer.email}' />"
                    />
                </td>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${customer.address}' />"
                    />
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
