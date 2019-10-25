<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>采办申请</title>

<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- bootstrap JS -->
<script src="${basePath}/jquery/bootstrap.js"></script>
<script src="${basePath}/jquery/bootstrap.min.js"></script>

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css">

<!-- 校验表单提交 -->
<script src="${basePath}/jquery/OwnJavaScript/VerifyInput.js"></script>

</head>
<body>
	<div style="text-align: center; font-size: 28px; margin-top: 10px;">
		<br>
		<h4 style="color: #EF9999; margin-top: 36px;"></h4>

		<form id="form_purchase" role="form"
			style="margin-top: 36px; width: 80%; margin-left: 10%; margin-bottom: 150px;">
			<label>采购申请单</label>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请输入货品名称</label>
				<!--  -->
				<input type="text" class="form-control" name="commodity"
					placeholder="采购之货品名" maxlength="42">
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请输入供货商</label>
				<!--  -->
				<input class="form-control" maxlength="42" type="text"
					name="supplier" placeholder="供应商">
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请输入采购数量</label>
				<!--  -->
				<span></span>
				<!--  -->
				<input maxlength="10" class="form-control quantity" type="text"
					name="quantity" placeholder="采购数量">
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请输入采购金额</label> <input
					type="text" name="amountMoney" class="form-control amountMoney"
					maxlength="26" placeholder="采购金额(单位:元,精确至小数点后2位)">
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请选择支付方式</label>
				<!--  -->
				<select name="paymentMethod" class="form-control">
					<option value="0">现金</option>
					<option value="1">网银</option>
					<option value="2">信用卡</option>
					<option value="3">其它</option>
				</select>
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">请选择商品分类</label>
				<!--  -->
				<select name="classify" class="form-control">
					<option value="0">电器</option>
					<option value="1">食品</option>
					<option value="2">服装</option>
					<option value="3">日用品</option>
					<option value="4">饮品</option>
					<option value="5">其它</option>
					<option value="6">玩具</option>
					<option value="7">家具</option>
					<option value="8">药品</option>
				</select>
			</div>

			<div class="form-group">
				<label for="name" style="font-size: medium;">是否已取货(部分或全部都算已取)</label>
				<!--  -->
				<select name="hasTakeGoods" class="form-control">
					<option value="0">未取货</option>
					<option value="1">已取货</option>
				</select>
			</div>

			<button type="button" onclick="submits();"
				class="btn btn-default btn-primary">Commit</button>
		</form>

	</div>
</body>

<script type="text/javascript">
	function submits() {
		var selector = $('#form_purchase :input[type="text"]');

		//检查非空,返回开关量
		var verify = verifyIsInputNullPlus(selector);
		if (verify == false) {
			return;
		}

		var quantity = $('.quantity').val();
		var amountMoney = $('.amountMoney').val();

		//检查货品数量是否为正整数
		var expression = new RegExp(/^\+?[1-9][0-9]*$/);
		if (expression.test(quantity) == false) {
			$('.quantity').css('background-color', '#EF9999');
			$('.quantity').prev('span').text('货品数量必须为正整数');
			return;
		}

		//验证金额与货物数量是否为非零正数
		var r = judges(quantity, amountMoney, null, null, null, null);
		if (r == false) {
			$('#form_purchase').prev('h4').text('输入的数字不合规');
			return;
		}

		var formData = $('#form_purchase').serialize();

		$
				.ajax({
					url : '/stocker-manager/PurchaseController/addNewPurchaseAppFormHandler',
					data : formData,
					type : 'POST',
					dataType : 'json',
					success : function(js) {
						if (js.state === 200) {
							alert('采进申请单已成功备案');
							location.href = '/stocker-manager/PurchaseController/jumpToPurchaseDeptHandler';
						} else {
							alert(js.message);
						}
					}
				});
	}
</script>
</html>