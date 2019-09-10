<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>修改基本资料(名字和密码)</title>
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
		<h3 class="col-md-5">填入新内容</h3>

		<div>
			<span id="span_hint" style="font-size: 28px; color: #eb3131; padding-top: 32px; padding-bottom: 32px;"></span>
		</div>

		<br>
		<form id="mineForm" class="bs-example bs-example-form col-md-5">
			<div class="input-group">
				<label>用户名</label>
				<!--  -->
				<input type="text" placeholder="" id="input00" name="usrname" maxlength="46" class="form-control">
			</div>

			<div class="input-group">
				<label>用户电话号码</label>
				<!--  -->
				<input type="text" placeholder="" id="input01" name="phone" maxlength="20" class="form-control">
			</div>

			<div class="input-group">
				<input type="button" value="提交" class="btn" id="confirm">
			</div>
		</form>

		<!--  -->
		<a href="/stocker-manager/cross/toTransfer" style="margin-top: 18px;">返回</a>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		emergeProfile();
	});

	/* 展示待改资料 */
	function emergeProfile() {
		var uname = $("#input00");
		var phone = $("#input01");
		var spanHint = $("#span_hint");

		$.ajax({
			url : '/stocker-managet/account/exhibitionBaseProfileHandler',
			type : 'GET',
			dataType : 'json',
			success : function(json) {
				if (json.state == 200) {
					uname.prop('placeholder', json.data.usrname);
					phone.prop('placeholder', json.data.phone);
				} else {
					spanHint.text('系统繁忙,请刷新页面再重试');
				}
			}
		});

	}

	/* 提交 */
	$('#confirm').on('click', function() {
		var form = document.getElementById('mineForm');
		var fd = new FormData(form);

		var usrname = fd.get("usrname");
		var phone = fd.get("phone");

		$.ajax({
			url : '/stocker-manager/account/reviseBaseProfileHandler',
			data : {
				"usrname" : usrname,
				"phone" : phone
			},
			type : 'POST',
			dataType : 'json',
			success : function(json) {
				if (json.state == 200) {
					alert('修改资料成功');
					location.href = '/stocker-manager/cross/toTransfer';
				} else {
					$('#span_hint').text(json.message);
				}
			}
		});

	});
</script>
</html>