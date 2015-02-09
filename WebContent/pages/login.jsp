<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CMS admin</title>
<link href="${ctx }/assets/css/ajax-loading.css" rel="stylesheet">
<link href="${ctx }/assets/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="${ctx }/assets/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${ctx }/assets/js/ajax-loading.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#user").focus();

		$("#pwd").bind("keyup", function(evt) {
			if (evt.keyCode == 13) {
				$("#btnLogin").click();
			}
		});

		$("#btnLogin").bind("click", function() {
			var user = $("#user").val();
			var pwd = $("#pwd").val();

			var $error = $("#errorMsg");
			$error.hide();

			$.post("${ctx}/login", {
				user : user,
				pwd : pwd
			}, function(res) {
				if (res.code == 200) {
					window.location = '${ctx}/admin';
				} else {
					$error.html("<label>" + res.data + "</label>");
					$error.show();
				}
			}, "json");
		});

	});
</script>
</head>
<body>

	<div class="container">

		<form method="post" action="${ctx }/login" class="form-signin">

			<h2 class="form-signin-heading">后台管理</h2>

			<label for="user" class="sr-only">Username</label> <input type="text" id="user" name="user"
				class="form-control" placeholder="Username" autofocus> <label for="pwd" class="sr-only">Password</label>
			<input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password">

			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>

			<div id="errorMsg"></div>

			<button class="btn btn-lg btn-primary btn-block" type="button" id="btnLogin">提交</button>
		</form>


		<p class="admin_copyright">
			<a tabindex="5" href="${ctx }/">返回首页</a> &copy; 2015
		</p>
	</div>
	<!-- /container -->


</body>
</html>