<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>采购事务日志记录</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- bootstrap JS -->
<script src="${basePath}/jquery/bootstrap.js"></script>
<script src="${basePath}/jquery/bootstrap.min.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css">

</head>

<style type="text/css">
body {
	font-size: 23px;
}

p {
	margin-bottom: 16px;
	font-family: 中文楷体;
}

.page_div {
	margin: 15px 0 0 27%;
}

.page_div li {
	list-style: none;
	float: left;
	margin: 0 25px 0 25px;
}

/* +++++++++++++ */
.mine_index_invoke, .mine_hints {
	display: none;
}

.log_substance {
	margin: 3px 0 200px 90px;
}
</style>

<body>
	<br>

	<div
		style="text-align: center; font-size: 22px; font-family: monospace;">
		<a
			href="/stocker-manager/PurchaseController/jumpToPurchaseWorkableHandler">返回采购模块主页</a>
	</div>

	<p class="mine_hints">
		P:<em class="pr"></em> || N:<em class="ne"></em>
	</p>

	<br>

	<div class="page_div">
		<ol>
			<li><a href="javascript:pageTurning(0)">首页</a></li>
			<li><a href="javascript:pageTurning(1)">上页</a></li>

			<li><a href="javascript:pageTurning(2)">下页</a></li>
			<li><a href="javascript:pageTurning(3)">尾页</a></li>

			<li><span>当前 <b class="mine_current_page"></b> 页
			</span></li>
			<li><span>总共 <b class="total_page"></b> 页
			</span></li>
		</ol>
	</div>

	<br>
	<hr>
	<br>

	<div class="records_logs log_substance"></div>

</body>

<script
	src="${basePath}/MineJavaScript/PurchaseModule/PurchaseTranceLog.js"></script>
</html>