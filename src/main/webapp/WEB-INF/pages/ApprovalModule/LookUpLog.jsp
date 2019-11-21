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
<title>审核部记录</title>

<style type="text/css">
.address_previous {
	margin: 2em 0 2em auto;
	border-bottom: 2px solid #b84848;
	height: 80px;
}

body>main>div {
	font-size: 22px;
	margin-top: 1rem;
}

body>main>div>p {
	margin: 12px;
}

.logs_records {
	margin: auto auto 45px 45px;
}

.pages_div_own {
	margin: auto auto 20rem 30%;
	font-size: 25px;
}

.pages_div_own li {
	margin: 18px;
	float: left;
	list-style: none;
}

.program_information {
	display: none;
}
</style>

</head>
<body>
	<header style="text-align: center;">
		<h2 class="address_previous">
			<a
				href="/stocker-manager/cross/generalAccess?moduleName=ApprovalModule/ApprovalWorkable&competence=1">返回审核部主页</a>
		</h2>
	</header>

	<p class="program_information">
		<em>下页否:</em><i class="has_next"></i> <br> <em>上页否:</em><i
			class="has_previous"></i>
	</p>

	<main>
		<div class="logs_records"></div>

		<div class="pages_div_own">
			<ol class="pages_ol_own">
				<li><a href="javascript:pageTurns(0)">首页</a></li>
				<li><a href="javascript:pageTurns(1)">上页</a></li>
				<li><a href="javascript:pageTurns(2)">下页</a></li>
				<li><a href="javascript:pageTurns(3)">尾页</a></li>
				<div class="index_pages_paras">
					<li><span>当前页:</span><b class="current_own"></b></li>
					<li><span>总页数:</span><b class="total_own"></b></li>
				</div>
			</ol>
		</div>

	</main>
</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/ApprovalDepartment/LookUpLog.js">
	
</script>
</html>