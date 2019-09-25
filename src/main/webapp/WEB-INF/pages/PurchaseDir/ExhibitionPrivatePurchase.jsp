<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>历史采办申请单列表</title>

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- bootstrap JS -->
<script src="${basePath}/jquery/bootstrap.js"></script>
<script src="${basePath}/jquery/bootstrap.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css">

<!-- 校验表单提交 -->
<script src="${basePath}/jquery/OwnJavaScript/VerifyInput.js"></script>

</head>
<body>
	<div style="text-align: center; font-size: 25px; margin-top: 80px;">

		<table id="purchase_table"
			style="width: 80%; margin-left: 10%; text-align: center;"
			class="table table-striped table-bordered table-hover table-condensed">
			
			<caption>申请单列表</caption>
			
			<thead>
				<tr class="active" style="text-align: center;">
					<th><input type="checkbox" id="head_check" class="head-box">行序号</th>
					<th>单号</th>
					<th>货品名</th>
					<th>供货商</th>
					<th>办理时间</th>
					<th>修改</th>
					<th>查详</th>
					<th>删除</th>
				</tr>
			</thead>

			<tbody id="purchase_table_tbody"></tbody>

		</table>

		<!--  -->
		<br> <a href="${basePath}/cross/toTransfer">返回中转页</a> <br>
	</div>
</body>

<script
	src="${basePath}/jquery/OwnJavaScript/ExhibitionPrivatePurchase.js"></script>
</html>