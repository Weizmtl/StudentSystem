<%--
  Created by IntelliJ IDEA.
  User: weizm
  Date: 2023/1/18
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>R.I.P</title>
</head>
<body>
<c:forEach items="${arr}" var="item">
    Subject:${item.getMajor1()}&nbsp;&nbsp;&nbsp;Score:${item.getMajor2()}<br>
</c:forEach>
</body>
</html>
