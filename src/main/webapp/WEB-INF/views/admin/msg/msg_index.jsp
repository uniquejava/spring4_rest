<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <table width="100%">
        <tr>
            <th>name</th>
            <th>content</th>
        </tr>
        <c:forEach items="${msgs}" var="o">
            <tr>
                <td>${o.name}</td>
                <td>${o.content}</td>
            </tr>

        </c:forEach>

    </table>
</div>
</body>
</html>
