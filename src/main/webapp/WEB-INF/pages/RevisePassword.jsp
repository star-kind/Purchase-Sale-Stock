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

<!-- 延时跳转 -->	
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/Prompt.js"></script>	

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

<!-- 0053.css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/RevisePassword.css">
</head>

<style type="text/css">
/*  */
</style>

<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>

	<!--SIGN UP-->
	<h1>修改密码</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<!-- <img src="images/avtar.png"> -->
		</div>
		<form id="mineForm">
			<h2 style="color: aliceblue;">请输入旧密码</h2>
			<input type="password" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}"
				name="oldPassword" maxlength="16">

			<h2 style="color: aliceblue;">请输入新密码</h2>
			<input type="password" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}"
				maxlength="16" name="firstNewPassword" id="lockWord01">

			<h2 style="color: aliceblue;">请再次输入新密码</h2>
			<input type="password" class="text" value="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}"
				maxlength="16" name="newPassword" id="lockWord02">


			<!-- <div class="key">
        <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
                        </div> -->
		</form>
		<div class="signin">
			<input type="submit" value="Confirm" onclick="confirmUpdate()">
			<!-- <input type="button" value="Confirm" class="btn btn-lg btn-primary"
                    id="confirm" onclick="confirmUpdate()"> -->
		</div>


	</div>
	<h1>
		<a href="/stocker-manager/cross/toTransfer">返回导航页</a>
	</h1>
	<br>
	<br>
	<br>
	<br>
	<!--  <div class="copy-rights">
                    <p>Copyright © 2015.Company name All rights reserved.More Templates</p>
            </div> -->
</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/AccountJS/RevisePassword.js"></script>
</html>