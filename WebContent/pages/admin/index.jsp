<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx }/assets/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${ctx }/assets/js/jsrender.min.js"></script>
<script id="theTmpl" type="text/x-jsrender">
	<tr><td>{{:name}}</td><td>{{:content}}</td>
</script>
<script type="text/javascript">
	function loadAllMsgs() {
		$.getJSON("${ctx}/admin/msg", null, function(res){
			var template = $.templates("#theTmpl");
			var htmlOutput = template.render(res.data);
			$("#msgContainer").html("<table>" + htmlOutput + "</table>");
		});
		
	}
</script>
</head>
<body>
	<div class="container">
		<h4>hello ${sessionScope.user.adminUser }, now it's ${time}.</h4>
		<div>
			<a href="${ctx }/admin/logout">logout</a>
		</div>

		<div>
			<a href="#" onclick="javascript: loadAllMsgs()">MsgController.list() : RESTful method</a>
		</div>
		
		<div>
			<a href="${ctx }/admin/msg">MsgController.list() : View-based method</a>
		</div>
		
		<div id="msgContainer">
		</div>
		
	</div>

</body>
</html>