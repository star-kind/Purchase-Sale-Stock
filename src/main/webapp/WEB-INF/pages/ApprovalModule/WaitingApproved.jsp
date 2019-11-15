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
	font-size: 22px;
	background: #fff;
	margin: 40px auto 155px auto;
	width: 1480px;
	border-collapse: collapse;
	text-align: left;
}

.hor_minimalist_a th {
	font-size: 22px;
	font-weight: normal;
	color: #039;
	padding: 10px 8px;
	border-bottom: 2px solid #6678b1;
	border-top: 2px solid #6678b1;
	border-left: 2px solid #6678b1;
}

.hor_minimalist_a td {
	color: #1313b8;
	padding: 9px 8px 0px 8px;
}

.hor_minimalist_a tbody tr:hover td {
	color: #009;
}

.saler_men {
	background: #bfe6c2;
}

.store_people {
	background: #eaf1b8;
}

.purchases {
	background: #ebcaef;
}

.index_div li {
	list-style: none;
	float: left;
}

.index_div ol {
	margin: 0 0 0 50rem;
	font-size: 24px;
}

.index_div ol a {
	margin: 20px;
	text-decoration: underline;
}

.data_hint {
	display: none;
}

.hor_minimalist_a>thead:nth-child(1)>tr:nth-child(1)>th:nth-child(1) {
	border-left: none;
}
</style>

</head>
<body>
	<div>

		<div class="index_div">

			<div class="data_hint">
				<b> <i>是否还上页:</i> <i class="has_prev"></i></b> <b><i>是否还下页:</i>
					<i class="has_next"></i></b> <b><i>每张表行数:</i> <i
					class="each_tbl_rows"></i></b>
			</div>

			<br> <br>

			<ol>
				<li><a href="javascript:pageJump(0)">首页</a></li>

				<li><a href="javascript:pageJump(1)">上页</a></li>

				<li>当前页 <span class="current_index"></span>
				</li>

				<li><a href="javascript:pageJump(2)">下页</a></li>

				<li><a href="javascript:pageJump(3)">尾页</a></li>

				<li>合计 <span class="total_pages"></span> 页
				</li>
			</ol>
		</div>

		<br> <br>
		<table class="hor_minimalist_a">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" id="head_check"
						onclick="headInfluence()">多选</th>
					<th scope="col">名称</th>
					<th scope="col">申请单类型</th>
					<th scope="col">原部门</th>
					<th scope="col">查看</th>
				</tr>
			</thead>

			<tbody class="tbl_body_a">
			</tbody>

		</table>
	</div>

</body>

<script
	src="${basePath}/MineJavaScript/ApprovalDepartment/WaitingApproved.js"></script>

<script src="${basePath}/jquery/OwnJavaScript/BoxsCheckedAll.js"></script>

</html>