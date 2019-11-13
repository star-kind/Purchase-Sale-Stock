<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>销售部门主页</title>

<style type="text/css">
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
			<span class="header_span01"> <a href="javascript:opens(1)">
					<b> 填写销售记录报告 </b>
			</a> <!--  --> <!--  --> <!--  --> <a href="javascript:opens(2)"> <b>
						全部销售记录单 </b>
			</a> <!--  --> <!--  --> <!--  --> <!--  --> <a
				href="/stocker-manager/cross/generalAccess?moduleName=SaleRecords/ViewLog&competence=3">
					<!--  --> <b> 查看日志记录 </b>
			</a> <!--  --> <!--  --> <!--  --> <a
				href="/stocker-manager/cross/toTransfer"> <b> 返回导航页 </b>
			</a> <!--  --> <!--  -->
				<!--  --> <!--  -->
				<!--  --> <!--  --> <a href="/stocker-manager/login.jsp"> <b>
						返回首页 </b>
			</a></span>
		</div>
	</header>

	<div>
		<!-- 填写销售记录报告 -->
		<div class="div_module" style="display: none;" id="room1">
			<jsp:include page="AddRecord.jsp"></jsp:include>
		</div>

		<!-- ExhibitionTable.jsp -->
		<div class="div_module" style="display: none;" id="room2">
			<jsp:include page="ExhibitionTable.jsp"></jsp:include>
		</div>

	</div>
</body>
</html>