<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- 表单样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/FormCommon.css">
<!-- 表格样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/TableCommom.css">

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css">

</head>

<style type="text/css">
div {
	font-family: 楷体;
}

.own_only_main {
	margin: 105px auto 99px auto;
}

.title_i {
	margin: auto auto 6px 49%;
}

.address_div {
	margin: 25rem auto 2rem 51%;
	font-size: 26px;
}

.mine_form_only {
	margin: 1em auto 0 40%;
	width: 470px;
	height: 350px;
	background: antiquewhite;
	font-size: 36px;
	border-style: solid;
	border-color: beige;
}

.mine_form_only_div {
	margin: 17px auto 15px 26%;
}

.mine_form_only input {
	margin: 22px auto;
}

.btn_div {
	margin: 3px 0 0 5%;
}

#confirm {
	margin: 40px 0 0 49%;
}
</style>

<body>
	<div class="own_only_main">

		<h3 class="col-md-5 title_i">更改密码</h3>

		<div>
			<span id="span_hint"
				style="font-size: 28px; color: #eb3131; padding-top: 32px; padding-bottom: 32px;"></span>
		</div>

		<br>
		<form id="mineForm"
			class="bs-example bs-example-form col-md-5 mine_form_only">
			<div class="input-group mine_form_only_div">
				<input type="password" placeholder="请输入原旧密码" id="lockWord00"
					name="oldPassword" maxlength="16" class="form-control">
			</div>

			<div class="input-group mine_form_only_div">
				<input type="password" placeholder="请输入密码" id="lockWord01"
					name="firstNewPassword" maxlength="16" class="form-control">
			</div>

			<div class="input-group mine_form_only_div">
				<input type="password" placeholder="请确认新密码" id="lockWord02"
					name="newPassword" maxlength="16" class="form-control">
			</div>

			<div class="input-group mine_form_only_div">
				<input type="button" value="Confirm" class="btn btn-lg btn-primary"
					id="confirm" onclick="confirmUpdate()">
			</div>
		</form>

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="address_div">
		<a href="/stocker-manager/cross/toTransfer" style="margin-top: 18px;">返回</a>
	</div>

</body>
<script type="text/javascript"
	src="${basePath}/MineJavaScript/AccountJS/RevisePassword.js"></script>
</html>