<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="${basePath}/AdminLTE/dist/css/AdminLTE.min.css">

<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/Ionicons/css/ionicons.min.css">

<!-- AdminLTE Skins -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/dist/css/skins/skin-blue.min.css">

<!-- jQuery 3 -->
<script
	src="${basePath}/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script
	src="${basePath}/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Slimscroll -->
<script
	src="${basePath}/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script
	src="${basePath}/AdminLTE/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/AdminLTE/dist/js/adminlte.min.js"></script>
<!-- iCheck -->
<script src="${basePath}/AdminLTE/plugins/iCheck/icheck.min.js"></script>

<!-- jQuery 3 -->
<script
	src="${basePath}/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap 3.3.7 -->
<script
	src="${basePath}/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/AdminLTE/dist/js/adminlte.min.js"></script>

<!-- layui javascript -->
<script src="${basePath}/CssFrame/layui/layui.js"></script>
<script src="${basePath}/CssFrame/layui/layui.all.js"></script>
<script src="${basePath}/CssFrame/layui/lay/modules/layer.js"></script>

<!-- layui css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/layui.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/layer/default/layer.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/code.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/layui/css/modules/laydate/default/laydate.css">

<!-- jquery ui js -->
<script src="${basePath}/jquery-ui-1.12.1/jquery-ui.js"></script>
<script src="${basePath}/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="${basePath}/jquery-ui-1.12.1/external/jquery/jquery.js"></script>

<!-- jquery ui css -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.min.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.structure.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.structure.min.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.theme.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/jquery-ui-1.12.1/jquery-ui.theme.min.css">

<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/BoxsCheckedAll.js"></script>

<meta charset="UTF-8">
<title>出库展示队列</title>
</head>

<style type="text/css" media="screen">
.tbl_belong_i thead tr th {
	border-top-width: 3px;
	border-top-style: solid;
	border-top-color: rgb(142, 167, 94);
}

li {
	list-style: none;
}

.mine_header_ol_0 li {
	float: left;
}

.mine_header_ol_0 {
	transform: translateX(16em);
}

.mine_header_ol_0 a {
	margin: 28px;
	color: #fff;
}

.mine_header {
	font-size: 32px;
}

.mine_header {
	height: 12rem;
	background: #566fda;
}

.header_div_0 {
	height: 6rem;
	transform: translateY(5rem);
}

/* -------------- */
main {
	font-size: 28px;
}

.main_div_0 table caption {
	width: 100%;
	text-align: left;
	/*margin: auto auto auto 34%;*/
}

.main_div_00 li {
	float: left;
}

.main_div_00 {
	height: 3em;
	margin: 8rem auto 3rem 26%;
}

.main_div_00 li a {
	margin: 25px;
}

.main_div_00 li span {
	margin: 25px;
}

/*------------------------*/
/* Border styles */
.tbl_belong_i {
	margin: auto auto auto 7%;
	width: 86%;
}

.tbl_belong_i thead, .tbl_belong_i tr {
	/*border-top-width: 1px;
border-top-style: solid;
border-top-color: rgb(235, 242, 224);*/
	border-top-width: 3px;
	border-top-style: solid;
	border-top-color: rgb(168, 211, 99);
}

.tbl_belong_i {
	/*border-bottom-width: 1px;
border-bottom-style: solid;
border-bottom-color: rgb(235, 242, 224);*/
	border-bottom-width: 3px;
	border-bottom-style: solid;
	border-bottom-color: rgb(126, 191, 24);
}

/* Padding and font style */
.tbl_belong_i td, .tbl_belong_i th {
	padding: 5px 10px;
	font-size: 27px;
	font-family: Verdana;
	color: rgb(149, 170, 109);
}

/* Alternating background colors */
.tbl_belong_i tr:nth-child(even) {
	background: rgb(230, 238, 214)
}

.tbl_belong_i tr:nth-child(odd) {
	background: #FFF
}

/*---------------*/
.hints_p {
	display: none;
}
</style>

<body>
	<header class="mine_header">
		<div class="header_div_0">

			<ol class="mine_header_ol_0">
				<li><a
					href="/stocker-manager/StockController/checkEnterCompetenceHandler">返回仓库</a></li>
				<li><a href="/stocker-manager/cross/toTransfer">返回导航</a></li>
				<li><a href="/stocker-manager/login.jsp">返回登录页</a></li>
			</ol>

		</div>
	</header>
	<!-- /header -->

	<br>
	<br>

	<main>
		<div class="main_div_0">
			<table class="tbl_belong_i">
				<caption>待处理出库队列表</caption>
				<thead>
					<tr>
						<th><input type="checkbox" id="head_check"
							onclick="headInfluence()"></th>
						<th>序号</th>
						<th>名称</th>
						<th>数量</th>
						<th>详情</th>

					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>

		</div>

		<div class="main_div_00">
			<ul>
				<li><a href="javascript:pageTurning(0)">首页</a></li>
				<li><a href="javascript:pageTurning(1)">上页</a></li>
				<li>当前页:<b><span class="span_current"></span></b></li>
				<li><a href="javascript:pageTurning(2)">下页</a></li>
				<li><a href="javascript:pageTurning(3)">尾页</a></li>
				<li>总页数:<span class="span_all_page"></span>
				</li>
			</ul>
		</div>
	</main>

	<br>
	<br>
	<footer>
		<p class="hints_p">
		<p>
			是否还有下:<i class="has_next"></i>
		</p>
		<p>
			是否还有上:<i class="has_prev"></i>
		</p>
		</p>
	</footer>
</body>
</html>
<script type="text/javascript"
	src="${basePath}/MineJavaScript/StockModule/OutStoreRoster.js"></script>

