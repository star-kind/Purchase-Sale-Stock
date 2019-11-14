<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

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

<head>
<meta charset="UTF-8">
<title>填写销售记录</title>

<style type="text/css" media="screen">
.form-bottom>form:nth-child(1) {
	margin: 75px auto 190px auto;
	font-size: 22px;
}

.form-group {
	margin: auto auto 2em auto;
}

.submit {
	margin-left: 50%;
}

.head_title {
	margin: 88px 0 0 0;
}

select {
	width: 35rem;
}

.inner-bg {
	background: beige;
}

.form-bottom form input {
	height: 45px;
}
</style>

</head>
<body>
	<div class="top-content"">

		<div class="inner-bg">
			<div class="container">

				<div style="text-align: center;" class="head_title">
					<h2>填写销售记录单</h2>
				</div>
				<div class="form-bottom contact-form">

					<form role="form" class="saler_form">

						<div class="form-group">
							<span>耗资金额</span>
							<!-- 非零正数,最多2位小数 -->
							<input type="text" name="amountMoney"
								class="amountMoney contact-email form-control" maxlength="16">
						</div>

						<div class="form-group">
							<span>已付款金额</span>

							<p style="color: rgb(223, 31, 31)"></p>

							<!-- 非零正数,最多2位小数 -->
							<input type="text" name="amountPaid"
								class="amountPaid contact-email form-control" maxlength="16"
								onblur="setIsPay()">
						</div>

						<div class="form-group">
							<span>存货类型</span> <select class="classify_store"
								onchange="findByClassify()">
								<option value="0">电器</option>
								<option value="1">食品</option>
								<option value="2">服装</option>
								<option value="3">日用品</option>
								<option value="4">饮品</option>
								<option value="5">其它</option>
								<option value="6">家具</option>
								<option value="7">玩具</option>
								<option value="8">药品</option>
								<option value="9">尚未具体分类</option>
							</select>
						</div>

						<div class="form-group">
							<span>货物名称</span> <select name="commodity"
								class="commodity_select">

							</select>
						</div>

						<!-- 自动赋值 -->
						<div class="form-group">
							<span>客户付款情况</span> <input type="text"
								class="contact-email form-control is_pay" readonly="readonly">

							<input type="text" name="isPay"
								class="contact-email form-control isPay" style="display: none;">
						</div>

						<div class="form-group">
							<span>付款方式</span> <select name="paymentMethod">
								<option value="0">现金</option>
								<option value="1">网银</option>
								<option value="2">信用卡</option>
								<option value="3">其它</option>
							</select>
						</div>

						<div class="form-group">
							<span>销售数量</span>
							<!-- 正整数 -->
							<input type="text" name="quantity"
								class="quantity contact-email form-control" maxlength="11"
								onblur="getQuantityByStockID()">
							<!--  -->

						</div>

						<div class="form-group">
							<span>客户名</span> <input type="text" name="customer"
								class="contact-email form-control customer" maxlength="44">
						</div>

						<div class="form-group">
							<span>仓内存货数量</span>
							<!--  -->
							<input type="number" class="mine_number contact-email form-control"
								readonly="readonly">
						</div>

						<!-- 自动赋值 -->
						<div class="form-group" style="display: none;">
							<span>存货是否足够</span>
							<!--  -->
							<input type="text" class="contact-email form-control"
								readonly="readonly">
							<!--  -->
							<input type="text" name="isEnoughStock"
								class="contact-email form-control isEnoughStock"
								style="display: none;">
						</div>

						<div class="form-group">
							<span>销售分部所属地</span> <select name="regionDepartment">
								<option value="0">滨河</option>
								<option value="1">上天院</option>
								<option value="2">鸣皋</option>
								<option value="3">焦王</option>
								<option value="4">申坡</option>
								<option value="5">遵王</option>
								<option value="6">常海山</option>
								<option value="7">老君堂</option>
								<option value="8">鸦岭</option>
								<option value="9">酒后</option>
								<option value="10">平等</option>
								<option value="11">夏堡</option>
								<option value="12">富留店</option>
							</select>
						</div>

						<div class="form-group">
							<button type="button" class="btn btn-lg btn-primary submit"
								onclick="prevent()">提交</button>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>
</body>

<script src="${basePath}/MineJavaScript/SaleRecords/AddRecord.js"></script>
</html>