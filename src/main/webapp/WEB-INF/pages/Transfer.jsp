<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- introduce -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/TransferClaim.css">

<title>导航页</title>

<style type="text/css">
.revamp_link {
	margin-left: 25px;
	margin-right: 25px;
}
</style>

</head>
<body>
	<div id="total_area">

		<div
			style="text-align: center; margin-top: 30px; margin-bottom: 25px;">
			<!--  -->
			<a href="${basePath}/cross/toRevisePassword" class="revamp_link">修改密码</a>
			<!--  -->
			<a href="${basePath}/cross/toReviseBaseProfile" class="revamp_link">修改基本资料</a>
		</div>

		<table>
			<h4 style="text-align: center;">选择模块</h4>

			<tbody>

				<tr class="t_rows">
					<td class="data_cells"><a
						href="${basePath}/account/toAdminWorkable" class="links_dept">信息技术部</a></td>
				</tr>

				<tr class="t_rows">
					<td class="data_cells"><a href="#" class="links_dept">销售部</a></td>
				</tr>

				<tr class="t_rows">
					<td class="data_cells"><a
						href="${basePath}/PurchaseController/jumpToPurchaseDeptHandler"
						class="links_dept">采购部</a></td>
				</tr>

				<tr class="t_rows">
					<td class="data_cells"><a
						href="/stocker-manager/StockController/checkEnterCompetenceHandler"
						class="links_dept">仓库管理</a></td>
				</tr>

				<tr class="t_rows">
					<td class="data_cells"><a
						href="/stocker-manager/cross/generalAccess?moduleName=ApprovalModule/ApprovalWorkable&competence=1"
						class="links_dept">审核部</a></td>
				</tr>

			</tbody>
		</table>
	</div>

	<div style="text-align: center; font-size: 18px; color: #d01d24;"
		class="into-info">
		<p>${info}</p>
		<p>${information}</p>
	</div>

	<div class="back_to" style="text-align: center;">
		<button class="btn_A" type="button">
			<a href="/stocker-manager/login.jsp">返回登录页</a>
		</button>
	</div>
</body>
</html>