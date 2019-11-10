<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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

<!-- 表格样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/TableCommom.css">

<title>销售记录单展示列表</title>

<style type="text/css">
.mine_address_0 {
	margin: 18px;
	text-decoration: underline;
}
</style>

</head>
<body>

	<div style="text-align: center;">
		<!--  -->
		<table border="1" class="member-table table salers_tbl_list">
			<br>
			<br>
			<caption>销售记录单列表</caption>
			<thead>
				<tr>
					<th class="table-head">全选 <input type="checkbox"
						id="head_check" class="head-box" onclick="headInfluence()">
					</th>
					<th class="table-head">次序号</th>
					<th class="table-head">售出货物之名</th>
					<th class="table-head">客户名</th>
					<th class="table-head">客户定购货物之数量</th>
					<th class="table-head">时间</th>
					<th class="table-head">查看详情</th>
					<th class="table-head">删除</th>
				</tr>
			</thead>

			<tbody>

			</tbody>
		</table>

		<br>
		<div class="mine_div_00" style="display: none;">
			<p class="total_page_nums"></p>
			<p class="current_page_nums"></p>
			<p class="previous_page_bool"></p>
			<p class="next_page_bool"></p>
			<p class="shows_rows"></p>
		</div>

		<br>
		<div class="mine_div_11" style="font-size: 24px;">
			<a href="#" class="mine_address_0">首页</a>
			<!--  -->
			<a href="#" class="mine_address_0">上一页</a>
			<!--  -->
			<a href="#" class="mine_address_0">下一页</a>
			<!--  -->
			<a href="#" class="mine_address_0">尾页</a>
		</div>
	</div>
</body>

<!-- 复选框 -->
<script src="${basePath}/jquery/OwnJavaScript/BoxsCheckedAll.js"></script>

<!-- 当页JavaScript -->
<script src="${basePath}/MineJavaScript/SaleRecords/ExhibitionTable.js"></script>
</html>