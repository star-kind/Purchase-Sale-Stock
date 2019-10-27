<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<!-- jquery -->
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css"></link>

<!-- jquery ui js -->
<script src="${basePath}/jquery-ui-1.12.1/jquery-ui.js"></script>
<script src="${basePath}/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="${basePath}/jquery-ui-1.12.1/external/jquery/jquery.js"></script>

<!-- jquery ui css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.min.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.structure.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.structure.min.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.theme.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.theme.min.css"></link>

<!-- layui javascript -->
<script src="${basePath}/CssFrame/layui/layui.js"></script>
<script src="${basePath}/CssFrame/layui/layui.all.js"></script>
<script src="${basePath}/CssFrame/layui/lay/modules/layer.js"></script>

<!-- layui css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/layui.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/layer/default/layer.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/code.css"></link>
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/laydate/default/laydate.css"></link>

<meta charset="UTF-8">
<title>待处理之申请单</title>

<style type="text/css">
.hor_minimalist_a {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	background: #fff;
	margin: 45px;
	width: 480px;
	border-collapse: collapse;
	text-align: left;
}

.hor_minimalist_a th {
	font-size: 14px;
	font-weight: normal;
	color: #039;
	padding: 10px 8px;
	border-bottom: 2px solid #6678b1;
}

.hor_minimalist_a td {
	color: #669;
	padding: 9px 8px 0px 8px;
}

.hor_minimalist_a tbody tr:hover td {
	color: #009;
}
</style>

</head>
<body>
	<div>
		<table class="hor_minimalist_a">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox">序号</th>
					<th scope="col">申请单类型</th>
					<th scope="col">原部门</th>
					<th scope="col">查看</th>
				</tr>
			</thead>

			<tbody>
			</tbody>

		</table>
	</div>
</body>

<script
	src="${basePath}/MineJavaScript/ApprovalDepartment/WaitingApproved.js"></script>
</html>