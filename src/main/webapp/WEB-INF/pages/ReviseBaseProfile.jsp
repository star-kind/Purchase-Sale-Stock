<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>修改基本资料(名字和密码)</title>
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

</head>

<style type="text/css">
body {
	font-family: 楷体;
}

.title_I {
	width: 100%;
	height: 88px; /*! text-align: center; */
	margin: 36px auto;
}

.title_I h1 {
	margin: 27px auto 22px 42%;
}

.mine_form_I {
	width: 100%;
	height: 530px;
	font-size: 26px;
}

.mine_form_I form { /*! margin: 39px 43%; */
	width: 499px;
	height: 399px;
	margin: 30px auto 38px 35%;
	background: beige;
}

.inut_mine_div {
	width: 100%;
	margin: 55px auto;
}

.input_div_btn_0 {
	margin: auto;
}

.input_div_btn_0 input {
	margin: auto 15px;
}

.input_div_btn_0 input.btn:nth-child(2) {
	font-size: 21px;
}

.address_div {
	text-align: center;
	font-size: 33px;
}
</style>

<body>
	<div class="title_I">
		<h1 class="col-md-5">修改基础资料</h1>
	</div>


	<div>
		<!-- <span id="span_hint"
                style="font-size: 28px; color: #eb3131; padding-top: 32px; padding-bottom: 32px;"></span> -->
	</div>

	<br>

	<div class="mine_form_I">
		<form id="mineForm" class="bs-example bs-example-form col-md-5">
			<div class="input-group inut_mine_div">
				<label>用户名</label>
				<!--  -->
				<input type="text" placeholder="" id="input00" name="usrname"
					maxlength="46" class="form-control">
			</div>

			<div class="input-group inut_mine_div">
				<label>电话号码</label>
				<!--  -->
				<input type="text" placeholder="" id="input01" name="phone"
					maxlength="20" class="form-control">
			</div>

			<div class="input-group input_div_btn_0">
				<input type="button" value="提交" class="btn btn-lg btn-primary"
					id="confirm" onclick="confirmChange()"> <input type="reset"
					value="重置" class="btn btn-lg btn-default">
			</div>

		</form>
	</div>

	</div>

	<div class="address_div">
		<a href="/stocker-manager/cross/toTransfer" style="margin-top: 18px;">返回导航界面</a>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/AccountJS/ReviseBaseProfile.js"></script>
</html>
