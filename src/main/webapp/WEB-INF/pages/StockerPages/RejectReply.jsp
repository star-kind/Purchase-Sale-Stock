<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回绝入库回复报告</title>

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

</head>

<body class="hold-transition skin-blue sidebar-mini">
	<!-- Main Header -->
	<header class="main-header"> ... </header>

	<main>

		<div class="box box-primary"
			style="margin: 8rem 8rem 8rem 19rem; width: 70%; background: #a3ead1;">
			<div class="box-header with-border" style="text-align: center;">
				<h3 class="box-title">回绝入库报告单</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">申单号</label>
						<!--  -->
						<input type="text" value="${p.purchaseId}" readonly="readonly"
							name="purchaseId" class="form-control" placeholder="申单序号">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">货物称谓</label>
						<!--  -->
						<input type="text" value="${p.commodity}" readonly="readonly"
							name="commodity" class="form-control" placeholder="货物称谓">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">供货商</label>
						<!--  -->
						<input type="text" value="${p.supplier}" name="supplier"
							readonly="readonly" class="form-control" placeholder="供应商">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">数量</label>
						<!--  -->
						<input type="text" value="${p.quantity}" name="quantity"
							class="form-control" readonly="readonly" placeholder="数量">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">金额</label>
						<!--  -->
						<input type="text" value="${p.amountMoney}" name="amountMoney"
							readonly="readonly" class="form-control" placeholder="金额">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">采买负责人</label>
						<!--  -->
						<input type="text" value="${p.operator}" class="form-control"
							name="operator" readonly="readonly" placeholder="采买负责人">
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">采进时间</label>
						<!--  -->
						<input type="datetime" value="${p.purchaseTime}"
							class="form-control" readonly="readonly" name="purchaseTime"
							placeholder="采进时间">
					</div>

					<div class="form-group" style="display: none;">
						<label for="exampleInputPassword1">货品类型</label>
						<!-- no name -->
						<input type="text" class="form-control" name="classify"
							value="${p.classify}" readonly="readonly">
					</div>

					<div class="form-group">
						<label>回复理由</label>
						<!-- no name -->
						<textarea class="form-control" rows="3" placeholder="Enter ..."
							maxlength="70"></textarea>
					</div>

				</div>
				<!-- /.box-body -->

				<div class="box-footer"
					style="background: #a3ead1; text-align: center;">
					<button type="button" class="btn btn-primary" id="submits">Submit</button>
				</div>
			</form>
		</div>

	</main>
</body>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript"
	src="${basePath}/MineJavaScript/StockModule/RejectReply.js"></script>
</html>