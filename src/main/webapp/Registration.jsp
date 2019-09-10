<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>账号注册</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript" src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- 表单样式 -->
<link rel="stylesheet" type="text/css" href="${basePath}/PatternStyle/FormCommon.css">
<!-- 表格样式 -->
<link rel="stylesheet" type="text/css" href="${basePath}/PatternStyle/TableCommom.css">

</head>
<body>
	<!-- reg area -->
	<div class="col-md-10 ex_div div_module" style="display: block; text-align: center;" id="room1">

		<!-- 错误信息提示 -->
		<div style="width: 320px; margin-bottom: 30px; text-align: center;">
			<span id="info-tip" style="font-size: 20px; color: #e71212; font-family: Microsoft YaHei;"> </span>
		</div>

		<!-- 注册资料填写 -->
		<div class="panel panel-default" style="margin-top: 100px;">
			<div class="panel-heading">
				<div class="row">

					<form id="form_usr" class="form_diy bs-example bs-example-form col-md-5" role="form"
						style="width: 88%; margin-left: 60px;">

						<p class="form_title">Add A New Account</p>

						<!-- 名字 -->
						<div class="form-group input-group">
							<p>plz input uname</p>
							<input class="input_text form-control" placeholder="plz input uname" type="text" name="usrname" maxlength="12"
								minlength="3">
						</div>

						<!-- phone -->
						<div class="form-group input-group">
							<p>plz input phone</p>
							<input class="input_text form-control" placeholder="plz input phone" type="text" name="phone" maxlength="30"
								minlength="5">
						</div>

						<!-- 部门 -->
						<div class="form-group input-group">
							<p>plz input dept number</p>
							<input class="input_text form-control" placeholder="plz input deptno" type="text" name="regionDepartment"
								maxlength="3" minlength="2">
						</div>

						<!-- 职权 -->
						<div class="form-group input-group">
							<p>plz input competence</p>
							<input class="input_text form-control" placeholder="plz input competence" type="text" name="competence"
								maxlength="1" minlength="1">
						</div>

						<div class="form-group input-group">
							<input type="button" class="commit_admin00 btn-primary" value="Submit" onclick="commit00()">
						</div>
					</form>

				</div>

				<br>
				<div class="row">
					<a href="login.jsp">返回登录页</a>
				</div>

			</div>
		</div>
	</div>

</body>


<script type="text/javascript">
	/** 注册账号*/
	function commit00() {
		var profile = $('#form_usr').serialize();
		$.ajax({
			type : 'POST',
			url : 'account/reg',
			data : profile,
			dataType : 'json',
			success : function(rr) {
				if (rr.state == 200) {
					alert('注册成功');
					location.href = 'login.jsp';
				} else {
					document.getElementById('info-tip').innerText = rr.message;
				}
			}
		});
	}
</script>
</html>