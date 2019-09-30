<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统首页</title>
<!-- jquery libraries -->
<script src="jquery/jquery-3.2.1.min.js" type="text/javascript"></script>

<!-- 导入bootstrap -->
<link rel="stylesheet" type="text/css" href="CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="CssFrame/bootstrap-theme.css">

<!-- 自定义css -->
<link rel="stylesheet" type="text/css" href="PatternStyle/Login.css">

<!-- 校验表单提交 -->
<script src="jquery/OwnJavaScript/VerifyInput.js"></script>

</head>
<body>
	<div class="container" id="content">
		<div class="row"
			style="text-align: center; margin-left: 50%; margin-top: 58px;">
			<h3 class="col-md-5" style="width: 250px;">进销存管理系统登录</h3>
		</div>

		<div style="width: 320px; margin-bottom: 30px;">
			<span id="info-tip"
				style="font-size: 18px; color: #529725; font-family: Helvetica">
			</span>
		</div>

		<!--  -->
		<div class="panel panel-default" id="mine_panel">
			<div class="panel-heading">
				<div class="row">

					<form id="form_usr_login"
						class="bs-example bs-example-form col-md-5" role="form"
						style="margin: 20px 0 10px 0;">

						<div class="input-group">
							<input id="usrname" class="form-control input_txts"
								placeholder="请输入用户名" type="text" name="usrname" maxlength="28"
								style="width: 440px;">
						</div>

						<div class="input-group">
							<input id="password" class="form-control input_txts"
								placeholder="请输入密码" type="password" name="password"
								maxlength="22" style="width: 440px;">
						</div>

						<div class="input-group" style="width: 200px; margin-left: 80%;">

							<input type="button" id="commit_login" value="登录"
								class="btn btn-default btn-lg col-md-2">

							<!--  -->
							<div style="margin-top: 8%;">
								<a href="Registration.jsp" style="font-size: 20px;">注册账号</a>
							</div>
						</div>

					</form>

					<!--  -->
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(function() {
		$('#commit_login')
				.click(
						function() {
							//选中当前表单中,标签input,类型type="text"的节点对象
							var selector = $('.input_txts');

							//检查非空,返回开关量
							var booleans = verifyIsInputNull(selector);
							if (booleans == false) {
								return;
							}

							var url = 'account/login';
							var data = $('#form_usr_login').serialize();
							$
									.ajax({
										type : 'POST',
										url : url,
										data : data,
										dataType : 'json',
										success : function(rr) {
											if (rr.state == 200) {
												alert('登录成功');
												window.location.href = "cross/toTransfer";
											} else {
												document
														.getElementById('info-tip').innerText = rr.message;
											}
										}
									});
						});
	});
</script>
</html>
