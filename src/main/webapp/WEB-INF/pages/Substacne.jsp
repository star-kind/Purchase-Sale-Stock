<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>账号活动日志记录</title>
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
p {
	margin-bottom: 16px;
	font-family: 中文楷体;
}
</style>

<body>
	<!-- 账号活动日志记录 -->
	<div class="detail_zone div_module col-md-10" style="display: block;" id="room4">
		<div class="col-md-10">

			<!--  -->
			<div style="text-align: center;">
				<a href="${basePath}/account/toAdminWorkable">返回</a> <br>
				<h3 class="col-md-5">账号活动日志记录</h3>
			</div>

			<br>
			<div id="log_substance" class="row"></div>

		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		readOutSubstacne();
	});
</script>
</html>