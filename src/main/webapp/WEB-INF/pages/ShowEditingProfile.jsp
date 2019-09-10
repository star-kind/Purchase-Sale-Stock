<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Showing Editing Profile</title>
<!-- 导入jQuery -->
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript" src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- 导入bootstrap -->
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap-theme.css">

</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="Top.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="container" id="content">
		<div class="panel panel-default">
			<div class="panel-body">

				<div class="panel-heading">
					<div class="row">
						<h1 style="text-align: center;">修改账号资料</h1>
					</div>
				</div>

				<form class="form-horizontal" role="form" id="form_modify">

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">账号ID</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" readonly="readonly" name="usrid" value="${accounts.usrid}"
								style="color: gray;" id="usrid">
						</div>
					</div>


					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">账号名</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="usrname" placeholder="${accounts.usrname}" id="usrname"
								maxlength="26">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="phone" placeholder="${accounts.phone}" id="phone" maxlength="28">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">权限编号</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="competence" placeholder="${accounts.competence}" id="competence"
								maxlength="1">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">地区部门编号</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" name="regionDepartment" placeholder="${accounts.regionDepartment}"
								id="regionDepartment" maxlength="4">
						</div>
					</div>

					<div class="form-group" style="text-align: center">
						<div class="col-sm-10">
							<input class="btn btn-default" type="button" value="Submit" id="commit_admin01">
							<button class="btn btn-default" type="reset">Restore</button>
						</div>
					</div>

				</form>

			</div>
		</div>
		<div class="col-md-2" style="text-align: center">
			<a href="toAdminWorkable">Back To Roster</a>
		</div>
	</div>
</body>

<script type="text/javascript">
	/* 请求将填好的新简介资料发与后端 */
	$('#commit_admin01').click(function() {
		var profile = $('#form_modify').serialize();
		var path = 'execute_revamp';

		$.ajax({
			data : profile,
			url : path,
			type : 'POST',
			dataType : 'json',
			success : function(rr) {
				if (rr.state == 200) {
					alert('执行改动成功');
					location.href = "toAdminWorkable";
				} else {
					alert(rr.message)
				}
			}
		});
	});
</script>
</html>