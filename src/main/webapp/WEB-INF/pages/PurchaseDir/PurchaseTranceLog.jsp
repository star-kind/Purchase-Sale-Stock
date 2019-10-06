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
<body>

	<br>
	<div
		style="text-align: center; font-size: 22px; font-family: monospace;">
		<a
			href="/stocker-manager/PurchaseController/jumpToPurchaseWorkableHandler">返回采购模块主页</a>
	</div>

	<hr>

	<div id="records_logs" style="margin-left: 100px; font-size: 18px;"></div>

</body>

<script type="text/javascript">
	/*=========================临时日志记录===========================*/
	$(function() {
		var uri = '/stocker-manager/PurchaseController/readOutputSubstanceLogHandler';

		$.ajax({
			url : uri,
			type : 'GET',
			dataType : 'json',
			success : function(rr) {
				if (rr.state === 200) {
					$('#records_logs').html(rr.data);
				} else {
					alert(rr.message);
				}
			}
		});

	});
</script>
</html>