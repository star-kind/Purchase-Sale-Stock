<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>全部采办申请单列表</title>

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- bootstrap JS -->
<script src="${basePath}/jquery/bootstrap.js"></script>
<script src="${basePath}/jquery/bootstrap.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap-theme.css">

<!-- 校验表单提交 -->
<script src="${basePath}/jquery/OwnJavaScript/VerifyInput.js"></script>

</head>
<body>
	<div style="text-align: center; font-size: 33px; margin-top: 10px;">
		<table id="purchase_table">
			<caption>申请单列表</caption>
			<thead>
				<tr>
					<th><input type="checkbox" id="head_check" class="head-box">表格行序号</th>
					<th>采购单单号</th>
					<th>货品名</th>
					<th>供货商</th>
					<th>经手人</th>
					<th>修改</th>
					<th>查看详情</th>
				</tr>
			</thead>

			<tbody id="purchase_table_tbody"></tbody>

			<!--  -->
			<tfoot>
				<tr>
					<td>
						<!--  -->共<span id="total_pages"></span>页
					</td>
				</tr>

				<tr>
					<td>
						<!--  --> 现在是第<span id="current_page"></span>页
					</td>
				</tr>
			</tfoot>
		</table>

		<!--  -->
		<div>
			<span>跳至指定页</span>
			<p>
				<input type="text" name="pageNum" id="assign_page">
				<!--  -->
				<input type="button" value="GO" onclick="void();">
			</p>
		</div>

		<!--  -->
		<br> <a href="${basePath}/cross/toTransfer">返回中转页</a> <br>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		exhibits();
	});
	
	var url='/stocker-manager/PurchaseController/exhibitionAllPurchaseHandler';
	
	/**申请单数据展览*/
	function exhibits() {
		
	}
</script>
</html>