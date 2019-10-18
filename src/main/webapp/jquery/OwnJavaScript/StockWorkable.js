/**
 * 开幕
 */
$(function() {
	exhibitTableList();
	exhibitCurrentUsrname();
})

/**
 * 
 * @returns
 */
function exhibitCurrentUsrname() {
	var uri = '/stocker-manager/StockController/getStockerNameHandler';

	var userName = $('.current_username');

	$.ajax({
		url : uri,
		type : 'get',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				var maps = rr.data;
				var uname = maps[0];
				console.log('maps:' + maps + ',' + 'uname-' + uname);

				if (uname != null || '') {
					userName.text(uname);
				} else {
					layer.alert("您尚未登录")
				}
			} else {
				layer.alert("抱歉,服务器检修中,给您带来不便非常抱歉")
			}
		}
	})
}

/**
 * 
 * @returns
 */
function exhibitTableList() {
	var url = '/stocker-manager/PurchaseController/getPurchaseListByTakedAndAgreedHandler';

	$.ajax({
		url : url,
		data : {
			"agree" : 1,
			"hasTaked" : 1
		},
		dataType : 'json',
		type : 'get',
		success : function(rr) {
			if (rr.state === 200) {
				if (rr.data != null || '') {
					var list = rr.data;
					console.log(list);

					$('#tag0 tbody').empty();

					executes(list);// 执行赋予表格内容

					exhibitLenAmount();// .len_amount
				}
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/**
 * 
 * @returns
 */
function exhibitLenAmount() {
	var lensTag = $('.len_amount');
	lensTag.empty();

	var length = $('.table_row_purchase').length;
	console.log('queue length:' + length);

	lensTag.text(length);
}

/**
 * 
 * @param list
 * @returns
 */
function executes(list) {
	for (var i = 0; i < list.length; i++) {
		var tr = '<tr id="table_row_#{purchaseId}" class="table_row_purchase">';
		tr += '<td>';
		tr += '<div class="icheckbox_flat-blue" aria-checked="false" aria-disabled="false"	style="position: relative;">';
		tr += '<input type="checkbox" style="position: absolute; opacity: 0;">';
		tr += '<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;">';
		tr += '</ins>';
		tr += '</div>';
		tr += '</td>';

		tr += '<td class="checkboys">';
		tr += '<input type="checkbox" id="check_#{purchaseId}">';
		tr += '</td>';

		tr += '<td class="mailbox-name">';
		tr += '<a href="javascript:surveyByPk(#{purchaseId});">[#{purchaseId}]</a>';
		tr += '</td>';

		tr += '<td class="mailbox-subject" style="text-align: left;padding-left: 170px;">';
		tr += '<b>#{commodity}</b>';
		tr += '</td>';

		tr += '<td class="mailbox-attachment"></td>';
		tr += '<td class="mailbox-date" style="text-align: right;">#{purchaseTime}</td>';
		tr += '</tr>';

		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);
		tr = tr.replace(/#{commodity}/g, list[i].commodity);
		tr = tr.replace(/#{purchaseTime}/g, list[i].purchaseTime);

		$('#tag0 tbody').append(tr);
	}
}

/**
 * 依据申单主键查询
 * 
 * @param purchaseId
 * @returns
 */
function surveyByPk(purchaseId) {
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

				var detail = generateApplicationForm(p);

				popUp(detail);
			} else {
				alert(rr.message);

			}

		}
	});
}

/**
 * 
 * @param p
 * @returns
 */
function generateApplicationForm(p) {
	/* 是否已取货 */
	var hasTakeGoods = '';
	if (p.hasTakeGoods === 0) {
		hasTakeGoods = '未取货';
	} else {
		hasTakeGoods = '已取货';
	}

	/* 是否获批 */
	var isAgree = '';
	if (p.isAgree === 0) {
		isAgree = '未获批';
	} else {
		isAgree = '已获批';
	}

	/* 商品分类 */
	var classify = '';
	switch (p.classify) {
	case 0:
		classify = '电器';
		break;

	case 1:
		classify = '食品';
		break;

	case 2:
		classify = '服装';
		break;

	case 3:
		classify = '日用品';
		break;

	case 4:
		classify = '饮品';
		break;

	case 5:
		classify = '其它';
		break;

	case 6:
		classify = '家具'
		break;

	case 7:
		classify = '玩具'
		break;

	case 8:
		classify = '药品'
		break;

	}

	var formHtml = '<div style="text-align:center;font-size:18px;margin-left:0%;">';
	formHtml += '<form id="purchase_app">';

	formHtml += '<p>采购申请单单号<br>';
	formHtml += '<input type="text" name="purchaseId" readonly="readonly" value="'
			+ p.purchaseId + '">';
	formHtml += '</p>';

	formHtml += '<br><p>采购货物名';
	formHtml += '<br><input type="text" name="commodity" readonly="readonly"  value="'
			+ p.commodity + '">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已批准<br>';
	// 专门显示,不提交
	formHtml += '<input type="text" readonly="readonly" value="' + isAgree
			+ '"><br>';

	formHtml += '</p>';

	formHtml += '<br><p>供应商';
	formHtml += '<br><input type="text" name="supplier" readonly="readonly"  value="'
			+ p.supplier + '">';
	formHtml += '</p>';

	formHtml += '<br><p>采购数量';
	formHtml += '<br><input type="text" name="quantity" readonly="readonly"  value="'
			+ p.quantity + '">';
	formHtml += '</p>';

	formHtml += '<br><p>采购金额';
	formHtml += '<br><input type="text" name="amountMoney" readonly="readonly"  value="'
			+ p.amountMoney + '">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已取货<br>';
	// 专门显示,不提交
	formHtml += '<input type="text" readonly="readonly"  value=" '
			+ hasTakeGoods + '"><br>';

	formHtml += '</p>';

	formHtml += '<br><p>采购经办人';
	formHtml += '<br><input type="text" name="operator" readonly="readonly"  value="'
			+ p.operator + '">';
	formHtml += '</p>';

	// no name="purchaseTime"
	formHtml += '<br><p>采购时间';
	formHtml += '<br><input type="text" readonly="readonly" id="purchaseTime_'
			+ p.purchaseId + '" value="' + p.purchaseTime + '">';
	formHtml += '</p>';

	formHtml += '<br><p>商品分类<br>';
	// 专门显示而不提交
	formHtml += '<input type="text" readonly="readonly"  value="' + classify
			+ '"><br>';

	formHtml += '</p>';

	formHtml += '<div style="margin-top:5px;">';

	formHtml += '<input type="button" onclick="permit(' + p.purchaseId
			+ ');" value="同意" class="btn btn-primary" style="margin:15px;">';

	formHtml += '<input type="button" onclick="reject(' + p.purchaseId
			+ ')" value="不同意" class="btn btn-warning" style="margin:15px;">';
	formHtml += '</div>';

	// style="visibility:hidden;"
	formHtml += '<input type="text" style="visibility:hidden;" name="isAgree" readonly="readonly" value="'
			+ p.isAgree + '">';
	formHtml += '<input type="text" style="visibility:hidden;" name="hasTakeGoods" readonly="readonly"  value="'
			+ p.hasTakeGoods + '">';
	formHtml += '<input type="text" style="visibility:hidden;" name="classify" readonly="readonly"  value="'
			+ p.classify + '">';

	formHtml += '</form>';

	formHtml += '<br>';
	formHtml += '</div>';
	formHtml += '<br>';

	return formHtml;
}

/**
 * 弹出
 * 
 * @param detail
 * @returns
 */
function popUp(detail) {
	layer.open({
		type : 1,// 若为页面层
		title : '采购申请单',
		skin : 'layui-layer-rim', // 加上边框
		/*
		 * layer提供了两种风格的关闭按钮,可通过配置1和2来展示,如果不显示,则closeBtn:0;true显示,false不显示.
		 */
		closeBtn : true,
		shade : 0.4,
		id : 'form_data_showing',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假,禁止
		moveType : 1,
		area : [ '600px', '560px' ],// 宽,高
		content : detail,
	/*
	 * btn : [ '关闭' ], success : function(layero) {
	 * layero.find('.layui-layer-btn').css('text-align', 'center'); }
	 */
	});

}

/* =========================================================================== */

/**
 * 
 * @param purchaseId
 * @returns
 */
function permit(purchaseId) {
	var url = '/stocker-manager/StockController/regEntryHandler';

	var purchase = $('#purchase_app').serialize();
	console.log('purchase data:' + purchase);

	$.ajax({
		url : url,
		data : purchase,
		type : 'post',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				layer.msg('该申请单成功进入仓库', function() {
					$('#table_row_' + purchaseId).remove();
					layer.closeAll();
					exhibitLenAmount();
				});
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/**
 * 
 * @param purchaseId
 * @returns
 */
function reject(purchaseId) {
	var url = '/stocker-manager/StockController/rejectHandler';

	$.ajax({
		url : url,
		type : 'POST',
		data : {
			purchaseId : purchaseId
		},
		dataType : 'json',
		contentType : "application/x-www-form-urlencoded",
		success : function(rr) {
			if (rr.state === 200) {
				location.href = '/stocker-manager/StockController/'
						+ purchaseId + '/gotoStockerPagesRejectReply';
			} else {
				layer.alert('msg:' + rr.message);
			}
		}
	})
}
