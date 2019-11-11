$(document).ready(function() {

});

/*------------------------------------------------------------------*/
/**
 * 根据仓储物品ID获取其数量,进而判断数量是否足够
 * 
 * @returns
 */
function getQuantityByStockID() {
	var uri = '/stocker-manager/StockController/getStoreAuantityByIDHandler';

	var sid = $('.commodity_select').val();
	console.log('Sid:' + sid);

	$.ajax({
		url : uri,
		data : {
			'sid' : sid
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log('存量:' + rr.data);

				judges(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 判断存货是否足够之情况
 * 
 * @param quantity
 * @returns
 */
function judges(quantity) {
	var judges = '';
	var isEnoughStock = null;

	// 拟定销出量
	var number = $('.quantity').val();

	if (number != null || '') {
		var percent = quantity / number;
		console.log('percent:' + percent);

		if (percent == 0) {
			judges = '没有存货';
			isEnoughStock = 0;

		} else if (percent > 0 && percent < 0.45) {
			judges = '少量存货';
			isEnoughStock = 1;

		} else if (percent >= 0.45 && percent <= 0.55) {
			judges = '有半数左右的存货';
			isEnoughStock = 2;

		} else if (percent >= 0.90 && percent <= 0.99) {
			judges = '勉强有足够存货';
			isEnoughStock = 3;

		} else if (percent >= 1) {
			judges = '可以满足供应';
			isEnoughStock = 4;

		}

		intoIsEnoughStock(judges, isEnoughStock);
	}

}

/**
 * 
 * @param judges
 * @param isEnoughStock
 * @returns
 */
function intoIsEnoughStock(judges, isEnoughStock) {
	var selector = $('.isEnoughStock').prev('input');

	$('.isEnoughStock').val(isEnoughStock);
	selector.val(judges);
}

/**
 * 从仓库中按分类查询
 * 
 * @returns
 */
function findByClassify() {
	var uri = '/stocker-manager/SaleController/foundByStockTypeAreaHandler';

	var classify = $('.classify_store').val();
	console.log(classify);

	$.ajax({
		url : uri,
		data : {
			'type' : classify
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				// 生成option,插入select标签
				intoSelect(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});

}

/**
 * 
 * @param list
 * @returns
 */
function intoSelect(list) {
	var opt = '';

	$('.commodity_select').empty();

	for (var i = 0; i < list.length; i++) {
		opt = '<option value="' + list[i].id + '">';
		opt += list[i].storeCommodity;
		opt += '</option>';

		$('.commodity_select').append(opt);
	}

}

/**
 * 给"付款情况"赋值
 * 
 * @returns
 */
function setIsPay() {
	var money = $('.amountMoney').val();
	var paid = $('.amountPaid').val();

	if (compare() == true) {
		return;

	}

	var percent = paid / money;
	console.log(percent);

	// 0未,1已付定金,2多于定金少于全款,3已全款付完
	var hint = '';
	var isPay = null;

	if (percent == 0) {
		hint = '未付款';
		isPay = 0;

	} else if (percent > 0 && percent < 0.5) {
		hint = '已付定金';
		isPay = 1;

	} else if (percent > 0.5 && percent < 1) {
		hint = '多于定金少于全款';
		isPay = 2;

	} else if (percent == 1) {
		hint = '已全款付完';
		isPay = 3;

	}

	console.log(hint + ',' + isPay);

	$('.isPay').val(isPay);
	$('.is_pay').val(hint);

}

/**
 * 预防
 * 
 * @return {[type]} [description]
 */
function prevent() {
	var customer = $('.customer').val();

	switch (customer.trim()) {
	case null:
		alert('客户名未填入');
		return;
		break;

	case '':
		alert('客户名未填入');
		return;
		break;

	default:
		console.log('ok');
		break;

	}

	if (regular() == false) {
		return;

	} else if (compare() == true) {
		return;

	} else if (customer == null || '') {
		layer.alert('客户名尚未填入')
		return;
	}

	sendData();
}

/**
 * 发送数据
 * 
 * @return {[type]} [description]
 */
function sendData() {
	var uri = ' /stocker-manager/SaleController/addHandler';

	var data = $('.saler_form').serialize();
	console.log(data);

	$.ajax({
		url : uri,
		data : data,
		dataType : 'json',
		type : 'POST',
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data);

				layer.msg('成功填写' + rr.data + '份销售记录', function() {
					location.reload();
				});
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 正则规范
 * 
 * @return {[type]} [description]
 */
function regular() {
	var bool = null;

	// 小数点后允许最多带2位小数
	var exp1 = new RegExp(/^(([1-9]{1}\d*)|(0{1}))(\.\d{0,2})?$/);

	// 正整数
	var exp2 = new RegExp(/^[0-9]*[1-9][0-9]*$/);

	var money = $('.amountMoney').val();
	var paid = $('.amountPaid').val();
	var quantity = $('.quantity').val();

	if (money <= 0 || quantity <= 0 && paid < 0) {
		alert('输入的数字不能小于等于零(已付款额除外)');

		bool = false;

	} else if (exp1.test(money) == false || exp1.test(paid) == false) {
		$('.amountPaid').css('background', 'rgb(227, 178, 178)');
		$('.amountMoney').css('background', 'rgb(227, 178, 178)');

		alert('在总金额或已付款额之处输入的数字不合规');
		bool = false;

	} else if (exp2.test(quantity) == false) {
		$('.quantity').css('background', 'rgb(227, 178, 178)');

		alert('数量必须是正整数');
		bool = false;
	}

	return bool;
}

/**
 * 比较大小
 * 
 * @return {[type]} [description]
 */
function compare() {
	var boo = null;

	var money = $('.amountMoney').val();
	var paid = $('.amountPaid').val();

	if (money != null && money != '' && paid != '' && paid != null) {

		boo = paid * 100 > money * 100;
		console.log('boo:' + boo);

		if (boo) {
			$('.amountPaid').css('background', 'rgb(227, 178, 178)');
			$('.amountPaid').prev('p').text('已付款金额不能大于总金额');

			alert('已付款金额不能大于总金额');
		}
	}

	return boo;
}