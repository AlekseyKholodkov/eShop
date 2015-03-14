<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>
<h3>All products page</h3>
<ul>
    <c:forEach var="product" items="${productList}">
    <li>
    ${product.id} <a href="./product.do?id=${product.id}">${product.name}</a>
    </li>
    </c:forEach>
</ul>
</body>
</html>
