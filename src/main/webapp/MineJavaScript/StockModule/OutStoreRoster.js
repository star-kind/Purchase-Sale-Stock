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

/* global variable of text */
var current_record = $('.current_record');
var total_record = $('.total_record');
var next_record = $('.next_record');
var prev_record = $('.prev_record');

/*----------------------------------*/

/**
 * 
 * @param key
 * @returns
 */
function pageWent(key) {
	var index = parseInt(current_record.text());
	var bool = '';

	switch (key) {
	case 0:
		readTextOnLimitHandler(0);
		break;

	case 1:
		bool = prev_record.text();

		if (bool === 'false') {
			return;
		}

		readTextOnLimitHandler(index - 2);
		break;

	case 2:
		bool = next_record.text();

		if (bool === 'false') {
			return;
		}

		readTextOnLimitHandler(index);
		break;

	case 3:
		index = parseInt(total_record.text()) - 1;
		readTextOnLimitHandler(index);
		break;
	}
}

/**
 * 
 * @param index
 * @returns
 */
function readTextOnLimitHandler(index) {
	console.log(index);

	var url = '/stocker-manager/OutStockController/readTextOnLimitHandler';

	$.ajax({
		url : url,
		data : {
			'pageth' : index
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data);

				$('.records_out').empty();

				current_record.text(rr.data.currentPage + 1);
				total_record.text(rr.data.totalPages);
				next_record.text(rr.data.isNext);
				prev_record.text(rr.data.isPrevious);

				$('.records_out').html(rr.data.textContent);
			} else {
				layer.alert(rr.message);
			}
		}
	})
}

/**
 * 从仓库中删除
 * 
 * @returns
 */
function deleteGoods() {
	var url = '/stocker-manager/OutStockController/deleteOutHandler';

	var array = [];

	var checks = $('input[class="td_order_number"]:checked');

	checks.each(function() {
		array.push(this.value);
	});

	if (array.length < 1) {
		layer.alert('您还未勾选中一项');
		return;
	}

	$.ajax({
		url : url,
		data : {
			'array' : array.join(',')
		},
		dataType : 'json',
		type : 'POST',
		success : function(rr) {
			if (rr.state == 200) {
				layer.msg('您已经成功删除' + rr.data + '笔存储物', function() {
					location.reload();
				})
			} else {
				layer.alert(rr.message);
			}
		}
	})

	// 重新初始化
	array = [];
}

/**
 * 
 * @param flag
 * @returns
 */
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

	var uri = '/stocker-manager/OutStockController/exhibitionQueueHandler01';

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
				span_all_page.text(rr.data.totalPages);
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
		tr += bo[i].applicant;
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
	var url = '/stocker-manager/OutStockController/gainDataBySidHandler';

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

				var list = rr.data;
				// 数据弹窗
				launchData(list[0]);
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
		id : 'details_form_outside',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假:禁止
		moveType : 1,
		area : [ '800px', '522px' ],// 宽,高
		content : form
	});
}

/**
 * 
 * @param d
 * @returns
 */
function createFormByData(d) {
	var substance = '';

	substance += '<div class="own_base_div">';

	substance += '<form class="gets_form" accept-charset="utf-8">';

	substance += '<div class="input_info_div">';
	substance += '<input type="number" name="uid" value="' + d.uid + '">';

	substance += '<input type="number" name="purchaseId" value="'
			+ d.purchaseId + '">';

	substance += '<input type="number" name="salePrimaryKey" value="'
			+ d.salePrimaryKey + '">';

	substance += '<input type="number" name="storeQuantity" value="'
			+ d.storeQuantity + '">';

	substance += '<input type="number" name="stockTypeArea" value="'
			+ d.stockTypeArea + '">  ';

	substance += '<input type="text" name="storeCommodity" value="'
			+ d.storeCommodity + '">  ';

	substance += '<input type="number" name="id" value="' + d.id
			+ '">            ';
	substance += '</div>';

	substance += '<div>';
	substance += '<div class="details_p_div">';

	substance += '<p>';
	substance += '出库货物名:';
	substance += '<b>';
	substance += d.storeCommodity;
	substance += '</b> ';
	substance += '</p>';

	substance += '<p>';
	substance += '货物数量:';
	substance += '<b>';
	substance += d.storeQuantity;
	substance += '</b> ';
	substance += '</p>';

	substance += '<p>';
	substance += '单价:';
	substance += '<b>';
	substance += d.unitPrice;
	substance += '</b> ';
	substance += '</p>';

	var area = gainTypeArea(d.stockTypeArea);
	substance += '<p>';
	substance += '原储存域:';
	substance += '<b>';
	substance += area;
	substance += '</b> ';
	substance += '</p>';

	substance += '<p>';
	substance += '原入库经手者:';
	substance += '<b>';
	substance += d.stockOperator;
	substance += '</b> ';
	substance += '</p>';

	substance += '<p>';
	substance += '入库时间:';
	substance += '<b>';
	substance += d.enterStockTime;
	substance += '</b> ';
	substance += '</p>';

	substance += '<p>';
	substance += '原入库备注:';
	substance += '<br>';
	substance += '<b>';
	substance += '<textarea rows="4" readonly="readonly">';
	substance += d.remark;
	substance += '</textarea>     ';
	substance += '</b> ';
	substance += '</p>';
	substance += '</div>';

	substance += '<div class="input_radio_p_div">';
	substance += '<p>是否同意入库:</p>';
	substance += '<span>';
	substance += '同意:';
	substance += '<input type="radio" class="radio_00" name="stockerIsAgree" value="true">';
	substance += '</span>';

	substance += '<span class="second_span_radio">';
	substance += '不同意:';
	substance += '<input type="radio" class="radio_11" name="stockerIsAgree" value="false">';
	substance += '</span>';
	substance += '</div>';
	substance += '</div>';

	substance += '<div class="remark_div">';
	substance += '<span>备注(如不同意出库,则此项必填)</span>';
	substance += '<br>';
	substance += '<textarea rows="4" name="remarks" maxlength="80"></textarea>';
	substance += '</div>';

	substance += '<div class="button_area_div">';
	substance += '<input type="button" value="提交" class="btn btn-lg btn-primary own_of_button" onclick="submitted('
			+ d.id + ')">';
	substance += '</div>';

	substance += '</form>';
	substance += '</div>';

	return substance;
}

/**
 * 
 * @param id
 * @returns
 */
function submitted(id) {
	var uri = '/stocker-manager/OutStockController/addOutHandler';

	var agree = $('input[name="stockerIsAgree"]:checked').val();
	console.log(agree);
	console.log(typeof (agree));

	var remark = $('.remark_div > textarea:nth-child(3)').val();
	console.log(remark);

	if (agree === 'false') {
		if (remark === '' || null) {
			layer.alert('备注未填');
			return;
		}
	}

	if (agree == undefined) {
		layer.alert('出库选项未选');
		return;
	}

	var bean = $('.gets_form').serialize();
	console.log(bean);

	$.ajax({
		url : uri,
		data : bean,
		dataType : 'json',
		type : 'POST',
		success : function(rr) {
			if (rr.state == 200) {
				layer.msg(rr.data + '份出库申请单处理成功', function() {
					// location.reload();
					parent.layer.closeAll();
					var selector = '#tr_ts_' + id;
					$(selector).remove();
				});
			} else {
				layer.alert(rr.message);
			}
		}
	})
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
