/**
 * http://localhost:8080/stocker-manager/OutStockController/exhibitionQueueHandler?pageth=1
 */
$(document).ready(function() {
	exhibitionQueueHandler(null);
});

/* global variable */
var span_current = $('.span_current');
var span_all_page = $('.span_all_page');
var has_next = $('.has_next');
var has_prev = $('.has_prev');

function pageTurning(flag) {
	var index = null;
	var bool = null;

	switch (flag) {
	case 0:
		exhibitionQueueHandler(0);
		break;

	case 1:
		bool = has_prev.text();

		if (bool === 'false') {
			return;
		}

		index = parseInt(span_current.text()) - 2;// 上一页
		exhibitionQueueHandler(index);
		break;

	case 2:
		bool = has_next.text();

		if (bool === 'false') {
			return;
		}

		index = parseInt(span_current.text());// 下一页
		exhibitionQueueHandler(index);
		break;

	case 3:
		index = parseInt(span_all_page.text()) - 1;
		exhibitionQueueHandler(index);
		break;
	}
}

/**
 * 
 * @param index
 * @returns
 */
function exhibitionQueueHandler(index) {
	console.log(index);

	var uri = '/stocker-manager/OutStockController/exhibitionQueueHandler';

	$.ajax({
		url : uri,
		data : {
			'pageth' : index
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				// 赋值给tbody
				appendIntoTBody(rr.data.data);

				// 赋值提示给其它标签
				span_current.text(rr.data.currentPageth + 1);
				span_all_page.text(rr.data.totalPages + 1);
				has_next.text(rr.data.hasNextPage);
				has_prev.text(rr.data.hasPreviousPage);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param bo
 * @returns
 */
function appendIntoTBody(bo) {
	var tbody = $('.tbl_belong_i tbody');

	tbody.empty();

	var n = 1;

	for (var i = 0; i < bo.length; i++) {
		var tr = '<tr id="tr_ts_' + bo[i].id + '">';

		tr += '<td>';
		tr += '<input type="checkbox" class="td_order_number" value="'
				+ bo[i].id + '">';
		tr += '</td>';

		tr += '<td>';
		tr += n++;
		tr += '</td>';

		tr += '<td>';
		tr += bo[i].storeCommodity;
		tr += '</td>';

		tr += '<td>';
		tr += bo[i].storeQuantity;
		tr += '</td>';

		tr += '<td>';
		tr += '<a href="javascript:seekDetail(' + bo[i].id + ')">';
		tr += '查看';
		tr += '</a>';
		tr += '</td>';

		tr += '</tr>';

		tbody.append(tr);
	}

	n = 1;
}

/**
 * 
 * @param id
 * @returns
 */
function seekDetail(id) {
	var url = '/stocker-manager/StockController/getStoreByIdHandler';

	$.ajax({
		url : url,
		data : {
			'sid' : id
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				// 数据弹窗
				launchData(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	})

}

/**
 * 
 * @param d
 * @returns
 */
function launchData(d) {
	// 用数据生成表单
	var form = createFormByData(d);

	layer.open({
		type : 1,// 若为页面层
		title : '出库货物详情',
		closeBtn : true,// 关闭窗体按钮,真,显示
		shade : 0.4,
		id : 'dynamic_form',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假:禁止
		moveType : 1,
		area : [ '800px', '490px' ],// 宽,高
		content : form
	});
}

/**
 * 
 * @param d
 * @returns
 */
function createFormByData(d) {

}

/**
 * 
 * @param key
 * @returns
 */
function gainTypeArea(key) {
	var typeArea = '';

	switch (key) {
	case 0:
		typeArea = '电器区';
		break;

	case 1:
		typeArea = '食品区';
		break;

	case 2:
		typeArea = '服装区';
		break;

	case 3:
		typeArea = '日用品区';
		break;

	case 4:
		typeArea = '饮品区';
		break;

	case 5:
		typeArea = '混装区';
		break;

	case 6:
		typeArea = '家具区';
		break;

	case 7:
		typeArea = '玩具区';
		break;

	case 8:
		typeArea = '药品区';
		break;

	case 9:
		typeArea = '仓外临时区';
		break;
	}

	return typeArea;
}
