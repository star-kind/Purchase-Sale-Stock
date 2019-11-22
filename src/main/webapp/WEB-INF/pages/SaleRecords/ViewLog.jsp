<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看日志记录</title>

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

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

</head>

<style type="text/css" media="screen">
body {
	font-size: 25px;
}

.mine_div_00 {
	margin: 30px 0 20px 0;
}

.mine_address_00 {
	text-decoration: underline;
}

.mine_div_01 {
	margin: 0 0 0 36%;
}

.mine_div_01 ul li {
	float: left;
	list-style: none;
}

.mine_div_01 ul li a {
	margin: 25px;
	text-decoration: underline;
}

.mine_title {
	margin: 4px 0 45px 0;
	font-size: 32px;
}

.p_page {
	display: none;
}

hr {
	height: 3px;
	background-color: #1a927c;
}

.log_substance {
	margin: 0 0 150px 0;
}
</style>

<body>

	<header>
		<!--  -->
		<div style="text-align: center;" class="mine_div_00">
			<a class="mine_address_00"
				href="/stocker-manager/cross/generalAccess?moduleName=SaleRecords/SalerWorkable&competence=3">返回销售部主页</a>

			<br> <br>

			<h3 class="mine_title">日志记录</h3>
		</div>

		<div class="mine_div_01">
			<ul>
				<li><a href="javascript:pageTurn(0)" class="first_page">首页</a></li>
				<li><a href="javascript:pageTurn(-1)" class="up_page">上页</a></li>
				<li><a href="javascript:pageTurn(-2)" class="down_page">下页</a></li>
				<li><a href="javascript:pageTurn(-3)" class="last_page">尾页</a></li>
			</ul>
		</div>

		<p class="p_page">
			<!--  -->
			<i class="total_pages"></i>
			<!--  -->
			<i class="current_page"></i>
			<!--  -->
			<i class="has_previous"></i>
			<!--  -->
			<i class="has_next"></i>
		</p>
	</header>

	<br>
	<hr>
	<br>

	<main>
		<!-- 日志记录内容 -->
		<div class="col-md-10">
			<div class="col-md-10">

				<div class="log_substance row"></div>

			</div>

		</div>
	</main>


</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/SaleRecords/ViewLog.js"></script>
</html>