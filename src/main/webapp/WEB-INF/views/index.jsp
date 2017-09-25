<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Insert title here</title>
    <link href="${ctx }/assets/css/ajax-loading.css" rel="stylesheet">
    <script type="text/javascript" src="${ctx }/assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${ctx }/assets/js/ajax-loading.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnSessionTimeout").bind("click", function () {
                $.get("${ctx}/admin/ajaxTimeout", null, function (res) {
                    alert(JSON.stringify(res));
                }, "json");
            });

        });
    </script>
</head>
<body>
<div class="container">
    hello home. go to <a href="${ctx }/admin">backend</a>

    <p/>

    <button id="btnSessionTimeout">test ajax timeout</button>
</div>
</body>
</html>
