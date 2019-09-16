<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>采购事务模块</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript" src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- bootstrap JS -->
<script src="${basePath}/jquery/bootstrap.js"></script>
<script src="${basePath}/jquery/bootstrap.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${basePath}/CssFrame/bootstrap-theme.css">

<!-- address tag css -->
<link rel="stylesheet" type="text/css" href="${basePath}/PatternStyle/Accesses.css">

</head>
<body>
	<main>
	<div class="accesses">
		<ul>
			<li><a href="#" class="a_links" onclick="opens(1)">申请采购货品</a></li>

			<li><a href="javascript:opens(2);" class="a_links">查看全部申请单</a></li>

			<li><a href="#" class="a_links">采买活动记录</a></li>

			<li><a href="${basePath}/cross/toTransfer" class="a_links">返回Transfer</a></li>
		</ul>
	</div>

	<div class="detail_zone div_module" style="display: none;" id="room1">
		<jsp:include page="AddApp.jsp"></jsp:include>
	</div>
	
	<div class="detail_zone div_module" style="display: none;" id="room2">
		<jsp:include page="ExhibitionAllPurchase.jsp"></jsp:include>
	</div>

	</main>
</body>
</html>