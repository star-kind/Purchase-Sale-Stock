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

		<form id="form_purchase" role="form" style="margin-top: 76px;">
			<label>采购申请单</label>

			<div class="form-group">
				<input type="text" class="form-control" name="commodity"
					placeholder="采购之货品名" maxlength="42">
			</div>

			<div class="form-group">
				<input class="form-control" maxlength="42" type="text"
					name="supplier" placeholder="供应商">
			</div>

			<div class="form-group">
				<span></span>
				<!--  -->
				<input maxlength="10" class="form-control quantity" type="text"
					name="quantity" placeholder="采购数量">
			</div>

			<div class="form-group">
				<input type="text" name="amountMoney"
					class="form-control amountMoney" maxlength="26"
					placeholder="采购金额(单位:元,精确至小数点后2位)">
			</div>

			<div class="form-group">
				<label for="name">请选择支付方式</label>
				<!--  -->
				<select name="paymentMethod" class="form-control">
					<option value="0">现金</option>
					<option value="1">网银</option>
					<option value="2">信用卡</option>
					<option value="3">其它</option>
				</select>
			</div>

			<div class="form-group">
				<label for="name">请选择是否已经入仓库</label>
				<!--  -->
				<select name="isEnterStore" class="form-control">
					<option value="0">未入仓库</option>
					<option value="1">已入仓库</option>
				</select>
			</div>

			<button type="button" onclick="submits();"
				class="btn btn-default btn-primary">Commit</button>
		</form>

	</div>
</body>

<script type="text/javascript">
	function submits() {
		//返回开关量
		var verify = veifyIsInputNull();
		if (verify === false) {
			return;
		}

		var quantity = $('.quantity').val();
		var amountMoney = $('.amountMoney').val();

		//检查物量是否为正整数
		var expression = new RegExp(/^\+?[1-9][0-9]*$/);
		if (expression.test(quantity) == false) {
			$('.quantity').css('background-color', '#EF9999');
			$('.quantity').prev('span').text('货品数量必须为正整数');
			return;
		}

		//验证金额与货物数量是否为非零正数
		var r = judges(quantity, amountMoney, null, null, null, null);
		if (r == false) {
			alert('输入的数字不合规');
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