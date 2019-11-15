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
<title>全部已处理</title>

<style type="text/css">
.table_6 thead th {
	background-color: rgb(128, 102, 160);
	color: #fff;
	border-bottom-width: 0;
}

/* Column Style */
.table_6 td {
	color: #000;
}
/* Heading and Column Style */
.table_6 tr, .table_6 th {
	border-width: 1px;
	border-style: solid;
	border-color: rgb(128, 102, 160);
}

/* Padding and font style */
.table_6 td, .table_6 th {
	padding: 5px 10px;
	font-size: 22px;
	font-family: Verdana;
	font-weight: bold;
}

.table_6>a {
	margin: 20px;
	text-decoration: underline;
}

.table_6 tr:nth-child(even) {
	background: rgb(230, 238, 214)
}

.table_6 tr:nth-child(odd) {
	background: #FFF
}

.header_div01 {
	border-bottom: 3px solid #1d7c70;
	padding: 40px 20px 20px 20px;
}

.header_span01 {
	font-size: x-large;
	margin: 4rem 0 0 4rem;
}

.header_span01>a {
	margin: 20px;
	text-decoration: underline;
}
</style>

</head>
<body>

	<header>
		<div class="header_div01">
			<span class="header_span01"> <a
				href="/stocker-manager/cross/generalAccess?moduleName=ApprovalModule/ApprovalWorkable&competence=1">
					<b> 返回部门主页 </b>
			</a> <a href="/stocker-manager/account/obtainIDAndNamesHandler"> <b>全部已处理</b>
			</a> <a
				href="/stocker-manager/cross/generalAccess?moduleName=ApprovalModule/LookUpLog&competence=1">
					<b>查看记录</b>
			</a> <a href="/stocker-manager/cross/toTransfer"> <b> 返回导航页 </b>
			</a> <a href="/stocker-manager/login.jsp"> <b> 返回首页 </b>
			</a>
			</span>
		</div>
	</header>

	<!--  -->
	<div>
		<br>
		<table class="table_6" cellspacing="0" cellpadding="0" border="1"
			style="margin: 6rem auto 10em auto; width: 80%;">
			<thead>
				<tr>
					<th><input type="checkbox" class="tbl_head_check"
						onclick="boxsInfluence()">复选</th>
					<th>归属部门</th>
					<th>处理时间</th>
					<th>批复意见</th>
					<th>原始序号</th>
					<th>审核决定</th>
					<th>审核者</th>
					<th>删除</th>
					<th>再次审核</th>
				</tr>
			</thead>

			<tbody class="table_boby">
			</tbody>
		</table>

	</div>

	<div class="uid_uname" style="display: none; text-align: center;">
		<c:forEach items="${map}" var="e">
			<p>
				<i class="result_index">${e.key}</i><b id="result_element_${e.key}">${e.value}</b>
			</p>
		</c:forEach>
	</div>

</body>

<script
	src="${basePath}/MineJavaScript/ApprovalDepartment/AllProcessed.js"></script>

<script src="${basePath}/jquery/OwnJavaScript/BoxsCheckedAll.js"></script>
</html>