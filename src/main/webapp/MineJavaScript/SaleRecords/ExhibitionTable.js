$(document).ready(function() {
	pagingDisplayHandler();
})

/* global variable */
var tbody = $('.salers_tbl_list tbody');

/* selectors */
var total_page_nums = $(".total_page_nums");
var current_page_nums = $(".current_page_nums");
var previous_page_bool = $(".previous_page_bool");
var next_page_bool = $(".next_page_bool");
var shows_rows = $('.shows_rows');

var pagingDisplay_uri = '/stocker-manager/SaleController/pagingDisplayHandler';

/**
 * 翻页
 * 
 * @param flag
 * @returns
 */
function pageTurning(flag) {
	console.log(flag);

	var page = null;
	var bool = null;

	switch (flag) {
	case -1:
		sendPagth(0); // 首页
		break;

	case -2:
		/*
		 * 上一页
		 */
		bool = previous_page_bool.text();

		if (bool === 'false') {
			return;
		}

		page = parseInt(current_page_nums.text()) - 1;

		sendPagth(page);
		break;

	case -3:
		/*
		 * 下一页
		 */
		bool = next_page_bool.text();

		if (bool === 'false') {
			return;
		}

		page = parseInt(current_page_nums.text()) + 1;

		sendPagth(page);
		break;

	case -4:
		page = total_page_nums.text();
		sendPagth(page);// 尾页
		break;

	}
}

/**
 * 发送页码
 * 
 * @param pageth
 * @returns
 */
function sendPagth(pageth) {
	console.log(pageth);

	$.ajax({
		url : pagingDisplay_uri,
		data : {
			'pageth' : pageth
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				executeAppendToTbody(rr.data.data);
				executeAppendOther(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @returns
 */
function pagingDisplayHandler() {

	$.ajax({
		url : pagingDisplay_uri,
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				executeAppendToTbody(rr.data.data);
				executeAppendOther(rr.data);

			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param p
 * @returns
 */
function executeAppendOther(p) {
	total_page_nums.text(p.totalPages)
	current_page_nums.text(p.currentPageth);
	previous_page_bool.text(p.hasPreviousPage);
	next_page_bool.text(p.hasNextPage);
	shows_rows.text(p.rows);
}

/**
 * 
 * @param list
 * @returns
 */
function executeAppendToTbody(list) {
	tbody.empty();

	var n = 1;

	for (var i = 0; i < list.length; i++) {
		var html = '<tr id="my_tbl_tr_' + list[i].id + '">';

		html += '<td>';
		html += '<input type="checkbox" class="td_order_number" value="'
				+ list[i].id + '">';
		html += '</td>';

		html += '<td>';
		html += n++;
		html += '</td>';

		html += '<td>';
		html += list[i].commodity;
		html += '</td>';

		html += '<td>';
		html += list[i].customer;
		html += '</td>'

		html += '<td>';
		html += list[i].quantity;
		html += '</td>'

		html += '<td>';
		html += list[i].saleTime;
		html += '</td>'

		html += '<td>';
		html += '<a href="javascript:searchSingleHandler(' + list[i].id
				+ ')">查看</a>';
		html += '</td>'

		html += '<td>';
		html += '<a href="javascript:void(' + list[i].id + ')">删除</a>';
		html += '</td>'

		html += '</tr>';

		tbody.append(html);

		if (list[i].hasSubmittedApproval == 1) {
			$('#my_tbl_tr_' + list[i].id).css('background', '#c2c9a7');
		}
		
	}

	n = 1;
}

/**
 * 
 * @param id
 * @returns
 */
function searchSingleHandler(id) {
	console.log(id);

	var uri = '/stocker-manager/SaleController/searchSingleHandler';

	$.ajax({
		url : uri,
		data : {
			'id' : id
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				eject(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/**
 * 
 * @param sale
 * @returns
 */
function eject(sale) {
	var content = generateContent(sale);

	layer.open({
		type : 1,// 若为页面层
		title : '销售记录登记单',
		closeBtn : true,// 关闭窗体按钮,真,显示
		shade : 0.4,
		id : 'form_detail_saleman',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假,禁止
		moveType : 1,
		area : [ '800px', '500px' ],// 宽,高
		content : content
	});

}

/**
 * 
 * @param sale
 * @returns
 */
function generateContent(sale) {
	appendSalerName(sale.saleOperator);

	var f = '<div class="form_div">';

	f += '<form class="own_form_0">';
	f += '<div class="form_div_00">';

	f += '<b class="own_input">ID</b>';
	f += '<input type="text" class="own_input own_input_01" value="' + sale.id
			+ '" name="id" style="cursor: not-allowed;" readonly="readonly">';

	f += '<br>';

	f += '<b class="own_input">库存原序号</b>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.warehouseGoodsOrder
			+ '" name="warehouseGoodsOrder" style="cursor: not-allowed;" readonly="readonly">';

	f += '<p>';
	f += '商品名:';
	f += '<span>';
	f += sale.commodity;
	f += '</span>';
	f += '</p>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.commodity + '" name="commodity">';

	f += '<p>';
	f += '客户名:';
	f += '<span>';
	f += sale.customer;
	f += '</span>';
	f += '</p>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.customer + '" name="customer">';

	f += '<p>';
	f += '销售金额:';
	f += '<span>';
	f += sale.amountMoney;
	f += '</span>';
	f += '</p>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.amountMoney + '"  name="amountMoney">';

	f += '<p>';
	f += '已付款金额:';

	f += '<span>';
	f += sale.amountPaid;
	f += '</span>';

	f += '</p>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.amountPaid + '"  name="amountPaid">';

	var paymentMethod = getPayMethod(sale.paymentMethod);
	f += '<p>';
	f += '支付方式:';

	f += '<span>';
	f += paymentMethod;
	f += '</span>';

	f += '</p>';
	f += '<select class="own_input own_input_01" name="paymentMethod">';
	f += '<option value="0">现金</option>';
	f += '<option value="1">网银</option>';
	f += '<option value="2">信用卡</option>';
	f += '<option value="3">其它</option>';
	f += '</select>';

	f += '<p>';
	f += '销售数量:';
	f += '<span>';
	f += sale.quantity;
	f += '</span>';
	f += '</p>';
	f += '<input type="text" class="own_input own_input_01" value="'
			+ sale.quantity + '" name="quantity">';

	var r = getRegion(sale.regionDepartment);
	f += '<p>';
	f += '所在地区:';

	f += '<span>';
	f += r;
	f += '</span>';

	f += '</p>';
	f += '<select class="own_input own_input_01" name="regionDepartment">';
	f += '<option value="0">滨河</option>';
	f += '<option value="1">上天院</option>';
	f += '<option value="2">鸣皋</option>';
	f += '<option value="3">焦王</option>';
	f += '<option value="4">申坡</option>';
	f += '<option value="5">遵王</option>';
	f += '<option value="6">常海山</option>';
	f += '<option value="7">老君堂</option>';
	f += '<option value="8">鸦岭</option>';
	f += '<option value="9">酒后</option>';
	f += '<option value="10">平等</option>';
	f += '<option value="11">夏堡</option>';
	f += '<option value="12">富留店</option>';
	f += '</select>';

	f += '<hr class="own_input">';

	var salerName = $('.saler_name').text();
	f += '<p>';
	f += '经办员:';
	f += salerName;
	f += '</p>';

	f += '<p>';
	f += '时间:';
	f += sale.saleTime;
	f += '</p>';

	var str = getIsEnough(sale.isEnoughStock);
	f += '<p>';
	f += '存货是否足够:';
	f += str;
	f += '</p>';

	var sb = getSubmit(sale.hasSubmittedApproval);
	f += '<p>';
	f += '是否已送审:';
	f += sb;
	f += '</p>';

	var s = getIsPay(sale.isPay);
	f += '<p>';
	f += '客户付款情况:';
	f += s;
	f += '</p>';

	f += '<p>';
	f += '剩余需求量:';
	f += sale.surplusDemand;
	f += '</p>';

	f += '<br>';
	f += '<div>';
	f += '<input type="button" class="btn btn-lg btn-warning own_button" value="修改" onclick="prepareRevision()">';
	f += '<input type="button" class="btn btn-lg btn-warning own_button" value="送审" onclick="submitCensorship()">';

	f += '<input type="button" class="btn btn-lg btn-primary own_button" value="提交" onclick="sendRevision()">';

	f += '</div>';

	f += '</div>';
	f += '</form>';

	f += '<br>';
	f += '<br>';

	f += '</div>';

	return f;
}

/**
 * 送审
 * 
 * @returns
 */
function submitCensorship() {
	var sid = $('input.own_input:nth-child(2)').val();

	var url = '/stocker-manager/SaleController/submitCensorshipHandler';

	layer.confirm('确定要送审吗?', {
		btn : [ '确定', '取消' ],
		title : '提示'
	}, function() {
		$.ajax({
			url : url,
			data : {
				'sid' : sid
			},
			dataType : 'json',
			type : 'GET',
			success : function(rr) {
				if (rr.state == 200) {
					layer.msg(rr.data + "份销售记录单送审成功", function() {
						location.reload();
					}, {
						icon : 1
					})
				} else {
					layer.alert(rr.message);
				}
			}
		})
	})
}

/**
 * 准备修改 [prepareRevision description]
 * 
 * @return {[type]} [description]
 */
function prepareRevision() {
	$('.form_div_00 span').css('display', 'none');
	$('.own_input').css('display', 'block');

	$('input.btn:nth-child(1)').css('display', 'none');

	// visibility: visible;
	$('input.btn:nth-child(3)').css('visibility', 'visible');

}

/**
 * 发送修改好的数据 [sendRevision description]
 * 
 * @return {[type]} [description]
 */
function sendRevision() {
	// 销售金额
	var money = $('.input.own_input:nth-child(11)').val();

	// 已付款金额
	var hasPaid = $('.input.own_input:nth-child(13)').val();

	if (hasPaid > money) {
		layer.alert('已付款金额不能大于销售金额');
		return;
	}

	var uri = '/stocker-manager/SaleController/revisionHandler';

	var data = $('.own_form_0').serialize();
	console.log(data);

	var selector = $('.own_input_01');
	var b = verifyIsInputNullPlus(selector);

	if (b == false) {
		return;
	}
	console.log(b);

	$.ajax({
		url : uri,
		data : data,
		dataType : 'json',
		type : 'POST',
		success : function(rr) {
			if (rr.state == 200) {
				layer.msg(rr.data + '份销售记录单已成功修改完毕', function() {
					location.reload();
				})
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/**
 * 
 * @param userid
 * @returns
 */
function appendSalerName(userid) {
	var uri = '/stocker-manager/account/findAccountByUseridHandler';
	var selector = $('.saler_name');

	$.ajax({
		url : uri,
		data : {
			'userid' : userid
		},
		dataType : "json",
		type : 'GET',
		success : function(rr) {
			if (rr.state == 200) {
				selector.empty();
				console.log(rr.data);

				selector.append(rr.data.usrname);
			} else {
				console.log('debug:' + rr.message);
			}
		}
	})
}

/**
 * 
 * @param key
 * @returns
 */
function getSubmit(key) {
	var str = '';

	if (key === 1) {
		str = '已送审';
	} else {
		str = '未送审';
	}

	return str;
}

/**
 * 
 * @param key
 * @returns
 */
function getIsEnough(key) {
	var s = '';

	switch (key) {
	case 0:
		s = "无存货";
		break;

	case 1:
		s = "少量存货";
		break;

	case 2:
		s = "半数左右";
		break;

	case 3:
		s = "勉强供应";
		break;

	case 4:
		s = "完全满足";
		break;
	}

	return s;
}

/**
 * 
 * @param key
 * @returns
 */
function getRegion(key) {
	var d = '';

	switch (key) {
	case 0:
		d = '滨河';
		break;

	case 1:
		d = '上天院';
		break;

	case 2:
		d = '鸣皋';
		break;

	case 3:
		d = '焦王';
		break;

	case 4:
		d = '申坡';
		break;

	case 5:
		d = '遵王';
		break;

	case 6:
		d = '常海山';
		break;

	case 7:
		d = '老君堂';
		break;

	case 8:
		d = '鸦岭';
		break;

	case 9:
		d = '酒后';
		break;

	case 10:
		d = '平等';
		break;

	case 11:
		d = '夏堡';
		break;

	case 12:
		d = '富留店';
		break;
	}

	return d;
}

/**
 * 
 * @param key
 * @returns
 */
function getIsPay(key) {
	var s = '';

	switch (key) {
	case 0:
		s = '未付款';
		break;

	case 1:
		s = '已付定金';
		break;

	case 2:
		s = '多于定金少于全款';
		break;

	case 3:
		s = '已全款付完';
		break;
	}

	return s;
}

/**
 * 
 * @param key
 * @returns
 */
function getPayMethod(key) {
	var m = '';

	switch (key) {
	case 0:
		m = '现金';
		break;

	case 1:
		m = '网银';
		break;

	case 2:
		m = '信用卡';
		break;

	case 3:
		m = '其它';
		break;
	}

	return m;
}
