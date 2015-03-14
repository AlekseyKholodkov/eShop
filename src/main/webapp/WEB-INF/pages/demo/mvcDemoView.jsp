<%--Servlet#5-1 time 2:09:20; 2:31:50--%>
<%@page import="com.kholodkov.entity.demo.DemoEntityB" %>
<html>
<body>
<b>MVC Demo View</b>
<br/>requestAttribute.string = ${requestAttribute.string}
<br/>requestAttribute.map['key-0'] = ${requestAttribute.map['key-0']}
<br/>requestAttribute.mockEntityB = ${requestAttribute.mockEntityB.string}
<br/>sessionAttribute.array[1] = ${sessionAttribute.array[1]}
<br/>servletContextAttribute.list[0] = ${servletContextAttribute.list[0]}
<hr/>
<jsp:useBean id="pageBean" scope="page" class="com.kholodkov.entity.demo.DemoEntityB"/>
<br/>pageBean.string = ${pageBean.string}
<hr/>
<br/>(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt 10) =
   ${(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt 10)}
<hr/>
<br/>testContext = ${testContext}
</body>
</html>