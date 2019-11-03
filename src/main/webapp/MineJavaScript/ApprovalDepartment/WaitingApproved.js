$(document).ready(function() {
	exhibitionHandler();
})

/**
 * 
 * @returns
 */
function exhibitionHandler() {
	var uri = "/stocker-manager/ApprovalController/exhibitionHandler";

	$.ajax({
		url : uri,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				$('.tbl_body_a').empty();

				console.log(rr.data);
				console.log(rr.data[2]);

				generateRowsContent(rr.data[2], 2);

			} else {
				layer.alert(rr.message, function() {
					setTimeout(function() {
						layer.closeAll();
					}, 600);
				});
			}
		}
	})
}

/**
 * 
 * @param map_element
 * @param index
 * @returns
 */
function generateRowsContent(map_element, index) {
	var typeStr = '';
	var dept = '';

	if (index == 2) {
		typeStr = '采购申请单';
		dept = '采购部';

		generatesRowsOfPurchase(map_element, typeStr, dept);
	}

}

/**
 * 
 * @param map_element
 * @param typeStr
 * @param dept
 * @returns
 */
function generatesRowsOfPurchase(map_element, typeStr, dept) {
	var signal = 2;

	for (var i = 0; i < map_element.length; i++) {
		var tr = '<tr id="app_purchase_' + map_element[i].purchaseId + '">';
		
		tr += '<td><input type="checkbox" value="' + map_element[i].purchaseId
				+ '" class="td_order_number"></td>';

		tr += '<td>' + typeStr + '</td>';
		tr += '<td>' + dept + '</td>';
		tr += '<td>';
		tr += '<a href="javascript:getDataFormPurchase('
				+ map_element[i].purchaseId + ');">详情</a>';
		tr += '</td>';
		tr += '<tr>';

		$('.tbl_body_a').append(tr);
	}

}

/**
 * 
 * @param id
 * @returns
 */
function getDataFormPurchase(id) {
	var uri = '/stocker-manager/PurchaseController/findPurchaseByIdHandler';

	$.ajax({
		url : uri,
		data : {
			'purchaseId' : id
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				var formContent = getFormContentAtPurchase(rr.data);
				layuiOfOpen(formContent);

			} else {
				alert(rr.message);

			}
		}
	});

}

/**
 * 
 * @param data
 * @returns
 */
function getFormContentAtPurchase(data) {
	console.log(data);

	/* 是否支付 */
	if (data.isPay === 0) {
		data.isPay = '未支付';
	} else {
		data.isPay = '已支付';
	}

	/* 是否已取货 */
	if (data.hasTakeGoods === 0) {
		data.hasTakeGoods = '未取货'
	} else {
		data.hasTakeGoods = '已取货'
	}

	/* 是否获批 */
	if (data.isAgree == 0) {
		data.isAgree = '未获批'
	} else {
		data.isAgree = '已获批'
	}

	/* 支付方式 */
	switch (data.paymentMethod) {
	case 0:
		data.paymentMethod = '现金'
		break;

	case 1:
		data.paymentMethod = '网银'
		break;

	case 2:
		data.paymentMethod = '信用卡'
		break;

	case 3:
		data.paymentMethod = '其他'
		break;
	}

	/* 分类 */
	switch (data.classify) {
	case 0:
		data.classify = '电器'
		break;

	case 1:
		data.classify = '食品'
		break;

	case 2:
		data.classify = '服装'
		break;

	case 3:
		data.classify = '日用品'
		break;

	case 4:
		data.classify = '饮品'
		break;

	case 5:
		data.classify = '其它'
		break;

	case 6:
		data.classify = '家具'
		break;

	case 7:
		data.classify = '玩具'
		break;

	case 8:
		data.classify = '药品'
		break;

	}

	var formHtml = '<div style="text-align:center;font-size:26px;margin-left:0%;">';
	formHtml += '<form>';

	formHtml += '<p>采购申请单单号';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.purchaseId + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购货物名';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.commodity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已批准';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.isAgree + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>供应商';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.supplier + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购数量';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.quantity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购金额';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.amountMoney + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>支付方式';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.paymentMethod + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已支付';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.isPay + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已取货';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.hasTakeGoods + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购经办人';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.operator + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购时间';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.purchaseTime + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>商品分类';
	formHtml += '<br><input type="text" readonly="readonly"  value=" '
			+ data.classify + ' ">';
	formHtml += '</p>';

	formHtml += '<p>批复意见</p>';
	formHtml += '<textarea rows="3" class="mine_replyOpinion_commit" maxlength="80"></textarea>';

	formHtml += '<br>';

	formHtml += '<div style="text-align: center;">';

	formHtml += '<input type="button" value="同意"  class="btn btn-default btn-primary"';
	formHtml += 'onclick="agreeOrAgainst(' + 2 + ',' + data.purchaseId + ','
			+ 1 + ')"';
	formHtml += 'style="margin:25px;">';

	formHtml += '<input type="button" value="不同意"  class="btn btn-default btn-primary"';
	formHtml += 'onclick="agreeOrAgainst(' + 2 + ',' + data.purchaseId + ','
			+ 0 + ')"';
	formHtml += 'style="margin:25px;">';

	formHtml += '</div>';

	formHtml += '</form>';

	formHtml += '<br>';
	formHtml += '</div>';
	formHtml += '<br>';

	return formHtml;
}

/**
 * 
 * @param formContent
 * @returns
 */
function layuiOfOpen(formContent) {
	layer.open({
		type : 1,
		title : '进行审核',
		area : [ '600px', '480px' ],
		id : [ 'application-form' ],
		resize : true,
		closeBtn : true,
		shade : 0.4,// 遮罩透明度
		content : formContent
	});
}

/**
 * 
 * @param deptNumber
 *            部门号
 * @param id
 *            申请单ID
 * @param decide
 *            操作代号
 * @returns
 */
function agreeOrAgainst(deptNumber, id, decide) {
	console.log('deptNumber:' + deptNumber + ',id:' + id + ',decide:' + decide);

	var uri = '/stocker-manager/ApprovalController/agreeOrAgainstHandler';

	var replyOpinion = $('.mine_replyOpinion_commit').val();

	$.ajax({
		url : uri,
		type : 'POST',
		data : {
			'id' : id,
			'decide' : decide,
			'replyOpinion' : replyOpinion,
			'deptNumber' : deptNumber
		},
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data);

				layer.msg('已成功处理该申请', {
					offset : [ '50%' ],
					time : 4000
				}, function() {
					$('#app_purchase_' + id).remove();
					layer.closeAll();
				});

			} else {
				layer.alert(rr.message);

			}
		}
	});

}
