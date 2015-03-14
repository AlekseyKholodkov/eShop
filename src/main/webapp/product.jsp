<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product</title>
</head>
<body>
  <h5>PRODUCT PAGE</h5>
  <p><a href="index.jsp">Go to main page</a></p>

  <p>Id: ${product.id}</p> <%--EL=Expression Language--%>
  <%--<p>Id: <%=((Product)request.getAttribute("product")).getId()%></p> &lt;%&ndash;Scriplet&ndash;%&gt;--%>
  <p>Name: ${product.name}. <a href="./productAddToCart.do?id=${product.id}"/>add to cart</p>
  <p><a href="./productAll.do">All products</a></p>


  <h2>Product in cart</h2>
  <ul>
    <c:forEach var="productInCart" items="${productsInCart}">
      <li>
      <a href="./product.do?id=${productInCart.key.id}">${productInCart.key.name}</a> = ${productInCart.value}
<%--remove from cart Servlet#6-2 35:32--%>
      </li>
    </c:forEach>
  </ul>
</body>
</html>
