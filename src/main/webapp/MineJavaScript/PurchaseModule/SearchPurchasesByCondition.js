/**
 * 第一层级联change事件
 * 
 * @returns
 */
$(document).on('change', '#select_id01', function() {
	var condition = $('#select_id01').val();
	console.log(condition);
	console.log(typeof (condition));

	switchBlockByText(condition);
})

/**
 * switch be based on #select_id01.value case to generate which content.
 * 显示哪个生成的亚层内容
 * 
 * @param condition
 * @returns
 */
function switchBlockByText(condition) {

	switch (condition) {
	/* 以下为click提交 */
	case 2 + '':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	case 1 + '':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	case 0 + '':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	/* 以下为change提交 */
	case 3 + '':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateIsPay();
		$('#select_id12').html(content);
		break;

	case 4 + '':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generatePaymethod();
		$('#select_id12').html(content);
		break;

	case 5 + '':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateTakedGoods();
		$('#select_id12').html(content);
		break;

	case 6 + '':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateCommodityType();
		$('#select_id12').html(content);
		break;

	case 7 + '':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateIsAgree();
		$('#select_id12').html(content);
		break;
	}

}

/**
 * 
 * @returns
 */
function generateIsPay() {
	var content = '<option value="0">未支付</option>';
	content += '<option value="1">已支付</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generatePaymethod() {
	var content = '<option value="0">现金</option>';
	content += '<option value="1">网银</option>';
	content += '<option value="2">信用卡</option>';
	content += '<option value="3">其它</option>';

	return content;
}

/**
 * 
 * @returns
 */
function generateTakedGoods() {
	var content = '<option value="0">未取货</option>';
	content += '<option value="1">已取货</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generateCommodityType() {
	var content = '<option value="0">电器</option>';
	content += '<option value="1">食品</option>';
	content += '<option value="2">服装</option>';
	content += '<option value="3">日用品</option>';
	content += '<option value="4">饮品</option>';
	content += '<option value="5">其它</option>';
	content += '<option value="6">玩具</option>';
	content += '<option value="7">家具</option>';
	content += '<option value="8">药品</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generateIsAgree() {
	var content = '<option value="0">未批准</option>';
	content += '<option value="1">已同意</option>';
	return content;
}

/* ----------------------------------------------------------- */

/**
 * 输入框点击事件提交
 * 
 * @returns
 */
$('#submitCondition').click(function() {
	var parameter = $('#submitCondition').prev('input').val();

	if (parameter == '' || null) {
		layer.alert('您尚未输入任何字符', {
			icon : 2
		});
		return;
	}
	console.log(parameter);

	var condition = $('#select_id01').val();
	console.log(condition);

	checkRegularExpression(condition, parameter);

	submitToBackstage(condition, parameter);
});

/**
 * 校验正则表达式
 * 
 * @param condition
 * @param parameter
 * @returns
 */
function checkRegularExpression(condition, parameter) {
	// 正则校验输入框提交参数,根据搜索条件condition.
	switch (condition) {

	case 1 + '':
		// 只允许是非0正整数
		var exp = new RegExp(/^[1-9]\d*$/);
		if (exp.test(parameter) == false) {
			layer.alert('输入的ID不合规', {
				icon : 2
			});

			return;
		}

		break;

	default:
		console.log('参数通过校验');
		break;
	}

}

/**
 * 级联标签change事件提交
 * 
 * @returns
 */
$('#select_id12').change(function() {
	var parameter = $('#select_id12').val();
	console.log(parameter);

	var condition = $('#select_id01').val();
	console.log(condition);

	submitToBackstage(condition, parameter);
})

/**
 * 交给后台
 * 
 * @param condition
 *            条件:condition
 * @param parameter
 *            具体参数:parameter
 * @returns
 */
function submitToBackstage(condition, parameter) {
	$.ajax({
		url : '/stocker-manager/PurchaseController/submitToBackstageHandler',
		data : {
			'condition' : condition,
			'parameter' : parameter
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				if (rr.data != null || '') {
					var list = rr.data;

					// 先初始化table body
					$('#table_body').empty();

					// 将数据追加至table body
					appendToTableBody(list);
				}
			} else {
				layer.alert(rr.message, {
					icon : 2
				});
			}
		}

	})
}

/**
 * 追加至table body
 * 
 * @param list
 * @returns
 */
function appendToTableBody(list) {
	var n = 0;

	for (var i = 0; i < list.length; i++) {
		var tr = '<tr id="pid_#{purchaseId}" class="active">'
				+ '<td>'
				+ '<input type="checkbox" class="td_order_number" value="#{purchaseId}">'
				+ ++n
				+ '</td>'
				+ '<td>#{purchaseId}</td>'
				+ '<td>#{commodity}</td>'
				+ '<td>#{supplier}</td>'
				+ '<td>#{purchaseTime}</td>'
				+ '<td><a href="javascript:revampPrepare(#{purchaseId})">修改</a></td>'
				+ '<td><a href="javascript:surveyDetail(#{purchaseId})">详情</a></td>'
				+ '<td><a href="javascript:deleteOne(#{purchaseId})">删除</a></td>'
				+ '</tr>';

		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);
		tr = tr.replace(/#{commodity}/g, list[i].commodity);
		tr = tr.replace(/#{supplier}/g, list[i].supplier);
		tr = tr.replace(/#{purchaseTime}/g, list[i].purchaseTime);

		$('#table_body').append(tr);

		if (list[i].isAgree == 0) {// 如若未获批,字体异色
			$('#pid_' + list[i].purchaseId).css('color', '#eb3871');
		}

	}

	n = 0;
}

/*
 * 101 101 101 101 101 101 101 101 101 101 101 101 101 101 101 101 101 101 101
 */

/**
 * 查看采购单详情
 * 
 * @param purchaseId
 * @returns
 */
function surveyDetail(purchaseId) {
	var url = '/stocker-manager/PurchaseController/findPurchaseByIdHandler';

	$.ajax({
		url : url,
		data : {
			'purchaseId' : purchaseId
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				var p = rr.data;

				var detail = generatePurchaseContent(p);

				eject(detail);
			} else {
				alert(rr.message);

			}

		}
	})

}

/**
 * 采购申请单弹出
 * 
 * @param content
 * @returns
 */
function eject(detail) {
	// console.log(detail);

	layer.open({
		type : 1,// 若为页面层
		title : '采购申请单',
		closeBtn : true,// 关闭窗体按钮,真,显示
		shade : 0.4,
		id : 'detail_of_purchase',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假,禁止
		moveType : 1,
		area : [ '800px', '480px' ],// 宽,高
		content : detail
	});

}

/**
 * 生成单份申请单数据内容
 * 
 * @param p
 * @returns
 */
function generatePurchaseContent(p) {
	/* 是否支付 */
	if (p.isPay === 0) {
		p.isPay = '未支付';
	} else {
		p.isPay = '已支付';
	}

	/* 是否已取货 */
	if (p.hasTakeGoods === 0) {
		p.hasTakeGoods = '未取货'
	} else {
		p.hasTakeGoods = '已取货'
	}

	/* 是否获批 */
	if (p.isAgree == 0) {
		p.isAgree = '未获批'
	} else {
		p.isAgree = '已获批'
	}

	/* 支付方式 */
	switch (p.paymentMethod) {
	case 0:
		p.paymentMethod = '现金'
		break;

	case 1:
		p.paymentMethod = '网银'
		break;

	case 2:
		p.paymentMethod = '信用卡'
		break;

	case 3:
		p.paymentMethod = '其他'
		break;
	}

	/* 分类 */
	switch (p.classify) {
	case 0:
		p.classify = '电器'
		break;

	case 1:
		p.classify = '食品'
		break;

	case 2:
		p.classify = '服装'
		break;

	case 3:
		p.classify = '日用品'
		break;

	case 4:
		p.classify = '饮品'
		break;

	case 5:
		p.classify = '其它'
		break;

	case 6:
		p.classify = '家具'
		break;

	case 7:
		p.classify = '玩具'
		break;

	case 8:
		p.classify = '药品'
		break;

	}

	var formHtml = '<div style="text-align:center;font-size:26px;margin-left:0%;">';
	formHtml += '<form>';

	formHtml += '<p>采购申请单单号';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.purchaseId + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购货物名';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.commodity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已批准';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.isAgree + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>供应商';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.supplier + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购数量';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.quantity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购金额';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.amountMoney + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>支付方式';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.paymentMethod + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已支付';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.isPay + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已取货';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.hasTakeGoods + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购经办人';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.operator + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购时间';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.purchaseTime + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>商品分类';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ p.classify + ' ">';
	formHtml += '</p>';

	formHtml += '</form>';

	formHtml += '<br>';
	formHtml += '</div>';
	formHtml += '<br>';

	return formHtml;
}

/* ============================ 分隔-修改单份采购申请============================ */

/**
 * 显示准备修改的内容
 * 
 * @param purchaseId
 * @returns
 */
function revampPrepare(purchaseId) {
	console.log(purchaseId);

	// 获取原有资料数据
	getPurchaseProfile(purchaseId);

}

/**
 * 获取原有申请单
 * 
 * @param argument
 * @returns
 */
function getPurchaseProfile(argument) {
	var uri = '/stocker-manager/PurchaseController/findPurchaseByIdHandler';

	$.ajax({
		url : uri,
		data : {
			'purchaseId' : argument
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data);
				var profile = rr.data;

				// 将原数据传入动态HTML生成函数
				geneateEditFormContent(profile);

			} else {
				alert(rr.message);

			}
		}
	})

}

/**
 * 生成待改之表单内容
 * 
 * @param profile
 * @returns
 */
function geneateEditFormContent(profile) {
	var formContent = '<div style="text-align: left;">';

	formContent += '<span></span>';
	formContent += '<form id="own_edit_form" style="font-size: 20px;">';

	formContent += '<div style="margin-top: 5%;margin-left: 18%;">';

	formContent += '<p style="visibility: hidden;">';
	formContent += '<input type="text" name="purchaseId"  readonly="readonly" value='
			+ profile.purchaseId + '>';
	formContent += '</p>';

	formContent += '<p>输入新货品名:';
	formContent += '<input type="text" class="purchase_input" name="commodity" value='
			+ profile.commodity + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新货商:';
	formContent += '<input type="text" class="purchase_input" name="supplier" value='
			+ profile.supplier + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新采购数量:';
	formContent += '<span></span>';
	formContent += '<input type="text" class="purchase_input" id="quantity" name="quantity" value='
			+ profile.quantity + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新采买金额:';
	formContent += '<input type="text" class="purchase_input" id="amountMoney" name="amountMoney" value='
			+ profile.amountMoney + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>选择新支付方式:';
	formContent += '<select name="paymentMethod" value='
			+ profile.paymentMethod + '>';
	formContent += '<option value="0">现金</option>';
	formContent += '<option value="1">网银</option>';
	formContent += '<option value="2">信用卡</option>';
	formContent += '<option value="3">其它</option>';
	formContent += '</select>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>选择是否已取货:';
	formContent += '<select name="hasTakeGoods" value=' + profile.hasTakeGoods
			+ '>';
	formContent += '<option value="0">未入</option>';
	formContent += '<option value="1">已入</option>';
	formContent += '</select>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>选择商品分类:';
	formContent += '<select name="classify" value=' + profile.classify + '>';
	formContent += '<option value="0">电器</option>';
	formContent += '<option value="1">食品</option>';
	formContent += '<option value="2">服装</option>';
	formContent += '<option value="3">日用品</option>';
	formContent += '<option value="4">饮品</option>';
	formContent += '<option value="5">其它</option>';
	formContent += '</select>';
	formContent += '</p>';

	formContent += '</div>';

	formContent += '<br>';

	formContent += '<div style="text-align: center;">';
	formContent += '<input type="button" value="提交" onclick="submitPurchaseData()" style="margin:15px;">';
	formContent += '<input type="reset" value="重置" style="margin:15px;">';
	formContent += '</div>';

	formContent += '<br>';

	formContent += '</form>';
	formContent += '</div>';

	// console.log(formContent);

	// 代入html内容,并弹出窗体
	ejects2(formContent);

}

/**
 * 弹出待编辑之表单
 * 
 * @param formContent
 * @returns
 */
function ejects2(formContent) {
	layer.open({
		type : 1,
		title : '修改采买申购单',
		area : [ '600px', '480px' ],
		id : [ 'form_area' ],
		resize : true,
		closeBtn : true,
		shade : 0.4,// 遮罩透明度
		content : formContent
	})
}

/**
 * 提交新数据
 * 
 * @returns
 */
function submitPurchaseData() {
	var selector = $('.purchase_input');

	// 校验输入非空
	var verify = verifyIsInputNullPlus(selector);
	console.log('verify-' + verify);
	if (verify === false) {
		return;
	}

	var quantity = $('#quantity').val();
	var amountMoney = $('#amountMoney').val();

	// 检查货品数量是否为正整数
	var expression = new RegExp(/^\+?[1-9][0-9]*$/);
	if (expression.test(quantity) == false) {
		$('#quantity').css('background-color', '#EF9999');
		$('#quantity').prev('span').text('货品数量必须为正整数');
		return;
	}

	// 验证金额与货物数量是否为非零正数
	var r = judges(quantity, amountMoney, null, null, null, null);
	if (r == false) {
		$('#own_edit_form').prev('span').css('color', '#e11d45');
		$('#own_edit_form').prev('span').text('输入的数字不合规');
		return;
	}

	var data = $('#own_edit_form').serialize();

	console.log(data);

	var uri = '/stocker-manager/PurchaseController/editOnePurchaseByIdHandler';

	$.ajax({
		url : uri,
		data : data,
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {

				layer.alert('修改成功', function() {
					location.reload();

				})
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/* =======================DELETE=========================== */
/**
 * 删除
 * 
 * @param purchaseId
 * @returns
 */
function deleteOne(purchaseId) {
	var uri = '/stocker-manager/PurchaseController/deleteSinglePurchaseAppByIdHandler';

	layer.confirm('您确定要删除该申请单吗?', {
		btn : [ '确定', '取消' ],
		title : "提示"
	}, function() {
		$.ajax({
			url : uri,
			type : 'POST',
			data : {
				'purchaseId' : purchaseId
			},
			dataType : 'json',
			success : function(rr) {
				if (rr.state === 200) {
					layer.alert('成功删除' + rr.data + "份采购单", function() {
						location.reload();
					});
				} else {
					layer.msg(rr.message, {
						icon : 2
					});
				}
			}
		});
	});
}

/* ===========================批量删除============================= */

/**
 * 全选/全取消之效果
 * 
 * @returns
 */
function headInfluence() {
	if ($('#head_check').prop('checked') == true) {
		$(':checkbox[class="td_order_number"]').prop('checked', true);
	} else {
		$(':checkbox[class="td_order_number"]').prop('checked', false);
	}
}

/**
 * 批量删除
 * 
 * @returns
 */
function multipleDeleted() {
	var uri = '/stocker-manager/PurchaseController/deleteMultiplesPurchaseAppByIdsHandler';

	var array = [];

	var items = $('input[type="checkbox"]:checked');// 选中标签节点

	items.each(function() {
		array.push(this.value);
	});

	console.log(array);

	if (array.length < 1) {
		layer.alert('还未选中一单');
		return;
	}

	top.layer.confirm('确定删除此些单子?', {
		btn : [ '确定', '取消' ],
		title : '提示'
	}, function() {
		$.ajax({
			url : uri,
			data : {
				'purchaseIds' : array.join(',')
			},
			type : 'post',
			dataType : 'json',
			success : function(rr) {
				if (rr.state === 200) {
					layer.alert('成功删除' + rr.data + "份采购单", function() {
						location.reload();
					});
				} else {
					layer.alert(rr.message);
				}
			}
		});

	});

}
