<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>账号活动日志记录</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- 表单样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/FormCommon.css">
<!-- 表格样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/TableCommom.css">

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
	margin: 15px 0 0 32%;
}

.page_div li {
	list-style: none;
	float: left;
	margin: 0 25px 0 25px;
}

.mine_index_invoke {
	display: none;
}

.log_substance {
	margin: 3px 0 200px 80px;
}
</style>

<body>
	<!-- 账号活动日志记录 -->
	<div class="detail_zone div_module col-md-10" style="display: block;"
		id="room4">
		<div class="col-md-10">

			<!--  -->
			<div style="text-align: center;">
				<br> <a href="/stocker-manager/account/toAdminWorkable">返回</a>
				<br> 
				<h3 class="col-md-5">账号活动日志记录</h3>

				<br>
				<div class="page_div">
					<ol>
						<li><a href="javascript:pageTurning(0)">首页</a></li>
						<li><a href="javascript:pageTurning(1)">上页</a></li>
						<li><span>当前: <b class="mine_current_page"></b> 页
						</span></li>
						<li><a href="javascript:pageTurning(2)">下页</a></li>
						<li><a href="javascript:pageTurning(3)">尾页</a></li>
					</ol>
				</div>

				<br>
			</div>

			<br>
			<div class="mine_index_invoke">
				<p>
					<i> 总共:<i class="total_page"></i>
					</i> <br> <i> 是否还有上页:<i class="has_previous"></i>
					</i> <br> <i> 是否还有下页:<i class="has_next"></i>
					</i>

				</p>
			</div>

			<hr>
			<br>

			<div class="log_substance row"></div>

		</div>
	</div>
</body>

<script type="text/javascript"
	src="${basePath}/MineJavaScript/AccountJS/Substacne.js"></script>
</html>