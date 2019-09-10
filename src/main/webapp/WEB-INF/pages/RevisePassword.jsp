<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript" src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript" src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- 表单样式 -->
<link rel="stylesheet" type="text/css" href="${basePath}/PatternStyle/FormCommon.css">
<!-- 表格样式 -->
<link rel="stylesheet" type="text/css" href="${basePath}/PatternStyle/TableCommom.css">

</head>

<style type="text/css">
.input-group {
	margin-bottom: 18px;
}
</style>

<body>
	<div style="text-align: center; font-family: 楷体;">
		<h3 class="col-md-5">填入密码</h3>

		<div>
			<span id="span_hint" style="font-size: 28px; color: #eb3131; padding-top: 32px; padding-bottom: 32px;"></span>
		</div>

		<br>
		<form id="mineForm" class="bs-example bs-example-form col-md-5">
			<div class="input-group">
				<input type="password" placeholder="请输入原旧密码" id="lockWord00" name="oldPassword" maxlength="16" class="form-control">
			</div>

			<div class="input-group">
				<input type="password" placeholder="请输入密码" id="lockWord01" name="firstNewPassword" maxlength="16"
					class="form-control">
			</div>

			<div class="input-group">
				<input type="password" placeholder="请确认新密码" id="lockWord02" name="newPassword" maxlength="16" class="form-control">
			</div>

			<div class="input-group">
				<input type="button" value="Confirm" class="btn" id="confirm">
			</div>
		</form>
		<a href="/stocker-manager/cross/toTransfer" style="margin-top: 18px;">返回</a>
	</div>
</body>
<script type="text/javascript">
	$('#confirm').on('click', function() {
		var lockWord01 = $('#lockWord01').val();
		var lockWord02 = $('#lockWord02').val();

		if (lockWord01 != lockWord02) {
			alert('两次新密码相异')
			return;
		}

		var form = document.getElementById('mineForm');
		var fd = new FormData(form);

		var oldPassword = fd.get("oldPassword");
		var newPassword = fd.get("newPassword");

		$.ajax({
			url : '/stocker-manager/account/revisePasswordHandler',
			data : {
				'oldPassword' : oldPassword,
				'newPassword' : newPassword
			},
			type : 'POST',
			dataType : 'json',
			success : function(json) {
				if (json.state == 200) {
					alert('修改密码成功');
					location.href = '/stocker-manager/login.jsp';
				} else {
					//alert(json.message);
					$('#span_hint').text(json.message);
				}
			}
		});

	});
</script>
</html>