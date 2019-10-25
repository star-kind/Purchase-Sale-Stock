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

<meta charset="UTF-8"></meta>
<title>按各种条件查找</title>
</head>
<body>

	<div>

		<!-- 按条件搜索 -->
		<div class="col-md-10" style="margin: 1em 0 1em 45em;">
			<!--  -->
			<select id="select_id01"
				class="btn-lg btn btn-default dropdown-toggle"
				style="height: 55px; margin: 6% 0 0 0;">
				<!-- 输入 -->
				<option value="0">按名称搜索</option>
				<option value="1">按ID搜索</option>
				<option value="2">按供应商搜索</option>
				<!-- 无需输入 -->
				<option value="3">按是否支付搜索</option>
				<option value="4">按支付方式</option>
				<option value="5">按是否已取货搜索</option>
				<option value="6">按货品类型搜索</option>
				<option value="7">按是否获批搜索</option>
			</select>
			<!--  -->
		</div>

		<div class="col-md-12">

			<!-- 亚层:第二层select -->
			<div id="second_select_area"
				style="width: 130px; margin: 1em 0 1em 45em; display: none;">

				<select id="select_id12"
					class="btn-lg btn btn-default dropdown-toggle"
					style="height: 55px; margin-right: 82%; margin-top: 6%; width: 199px;">
				</select>
				
			</div>

			<!-- 亚层:用于显示input -->
			<div id="second_input_area"
				style="margin: 15px 0 0 0; display: none;">
				<div class="input-group input-group-lg"
					style="margin: 0 0 35px 40%; width: 350px;">

					<input type="text" class="form-control" placeholder="请输入..."></input>
					<span class="input-group-addon btn btn-default"
						id="submitCondition"> 确定 </span>

				</div>
			</div>

		</div>

		<div>
			<table border="1"
				class="table table-bordered table-striped table-condensed"
				style="font-size: 24px; width: 85%; margin: 20px 0 0 7%;">

				<caption>Account List</caption>
				<thead>
					<tr class="active">
						<th><input type="checkbox" onclick="headInfluence()">行序号</input></th>
						<th>单号</th>
						<th>货品名</th>
						<th>供货商</th>
						<th>办理时间</th>
						<th>修改</th>
						<th>查详</th>
						<th>删除</th>
					</tr>
				</thead>

				<tbody id="table_body"></tbody>
			</table>
		</div>

		<!-- 多选按钮 -->
		<div class="input-group"
			style="text-align: center; left: 68rem; top: 30px;">
			<button onclick="multipleDeleted()" class="btn btn-lg btn-warning"
				type="button">批量删除</button>
		</div>

		<div style="margin-top: 48px;text-align: center;font-size: x-large;">
			<br> <a href="${basePath}/cross/toTransfer"
				style="text-decoration: underline;">返回中转页</a> <br>
		</div>

	</div>

</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/PurchaseModule/SearchPurchasesByCondition.js"></script>

</html>