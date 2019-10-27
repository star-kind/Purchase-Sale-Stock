/**
 * 开幕雷击
 */
$(function() {
	exhibitDataList();
})

/**
 * 
 * @returns
 */
function exhibitDataList() {
	var url = '/stocker-manager/StockController/getAllStoreHandler';

	$.ajax({
		url : url,
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				if (rr.data != null || '') {
					var list = rr.data;

					$('#example2 tbody').empty();

					generateTableRows(list);// 产生并赋予表格内容

					// exhibitsAmount(list);// .exhibits-amount
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
$('#select_type_area').change(function() {
	var areaOrder = $('#select_type_area').val();
	console.log('分类查询显示开始.areaOrder=' + areaOrder);

	foundByTypeAreaHandler(areaOrder);
});

/**
 * 
 * @param areaOrder
 * @returns
 */
function foundByTypeAreaHandler(areaOrder) {
	var url = "/stocker-manager/StockController/foundByTypeAreaHandler";

	$.ajax({
		url : url,
		data : {
			'areaOrder' : areaOrder
		},
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200 && rr.data != null) {
				var list = rr.data;

				$('#example2 tbody').empty();

				generateTableRows(list);// 产生并赋予表格内容

			} else {
				layer.alert(rr.message);
			}
		}
	})

}

/**
 * 
 * @param list
 * @returns
 */
function generateTableRows(list) {
	for (var i = 0; i < list.length; i++) {

		var tr = '<tr role="row">';
		
		tr += '<td class="sorting_1">';
		tr += '<input type="checkbox" value="#{id}" class="td_order_number">';
		tr += '</td>';
		
		tr += '<td>#{storeCommodity}</td>';
		tr += '<td>#{storeQuantity}</td>';
		tr += '<td id="stockTypeArea-#{purchaseId}"></td>';
		tr += '<td><a style="text-decoration: underline;" href="javascript:detailByItem(#{purchaseId});">点击查看</a></td>';
		tr += '</tr>';

		tr = tr.replace(/#{id}/g, list[i].id);
		tr = tr.replace(/#{storeCommodity}/g, list[i].storeCommodity);
		tr = tr.replace(/#{storeQuantity}/g, list[i].storeQuantity);
		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);

		console.log('typeof(list[i].stockTypeArea):'
				+ typeof (list[i].stockTypeArea));

		$('#example2 tbody').append(tr);

		exhibitsByTypeNum(list[i]);
	}
}

/**
 * 
 * @param purchaseId
 * @returns
 */
function detailByItem(purchaseId) {
	var uri = '/stocker-manager/StockController/findTStockByPurchaseIdHandler';

	$.ajax({
		url : uri,
		data : {
			'purchaseId' : purchaseId
		},
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				layerOpenEject(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});

}

/**
 * 
 * @param ts
 * @returns
 */
function layerOpenEject(ts) {
	var form = manufactureContent(ts);

	layer.open({
		type : 1,
		title : '仓储货物资料简介',
		area : [ '600px', '510px' ],
		id : [ 'store_div' ],
		resize : true,
		closeBtn : true,
		shade : 0.4,// 遮罩透明度
		moveType : 1,
		content : form
	});

}

/**
 * 
 * @param ts
 * @returns
 */
function manufactureContent(ts) {
	/*	 */
	var typeArea = null;
	switch (ts.stockTypeArea) {
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

	/*	 */
	var agree = null;
	if (ts.agreeEnterStock == 0) {
		agree = '尚未同意';
	} else if (ts.agreeEnterStock == 1) {
		agree = '已经同意';
	}

	/*	 */
	var f = '<div style="text-align:center;font-size:18px;margin-left:0%;">';

	f += '<form>';
	f += '<input type="text" value="' + ts.id
			+ '" readonly="readonly" style="visibility:hidden;" name="id">';

	f += '<input type="text" value="'
			+ ts.purchaseId
			+ '" readonly="readonly" style="visibility:hidden;" name="purchaseId">';

	f += '<p>名称</p>';
	f += '<input type="text" value="' + ts.storeCommodity
			+ '" readonly="readonly" name="storeCommodity" class="update_set">';

	f += '<br>';

	f += '<p>数量</p>';
	f += '<input type="text" value="' + ts.storeQuantity
			+ '" readonly="readonly" name="storeQuantity" class="update_set">';

	f += '<br>';

	f += '<p>单价</p>';
	f += '<input type="text" value="' + ts.unitPrice
			+ '" readonly="readonly" name="unitPrice" class="update_set">';

	f += '<br>';

	f += '<p>分区</p>';
	f += '<input type="text" value="' + typeArea + '" readonly="readonly">';

	f += '<select value="'
			+ ts.stockTypeArea
			+ '" name="stockTypeArea" style="display:none;margin-left: 17rem;width: 14em;" id="ts_stockTypeArea" class="update_set" readonly="readonly">';
	f += '<option value="0">电器区</option>';
	f += '<option value="1">食品区</option>';
	f += '<option value="2">服装区</option>';
	f += '<option value="3">日用品区</option>';
	f += '<option value="4">饮品区</option>';
	f += '<option value="5">混装区</option>';
	f += '<option value="6">家具区</option>';
	f += '<option value="7">玩具区</option>';
	f += '<option value="8">药品区</option>';
	f += '<option value="9">外围临时区</option>';
	f += '</select>';

	f += '<br>';

	f += '<p>本批次登记人</p>';
	f += '<input type="text" value="' + ts.stockOperator
			+ '" readonly="readonly">';

	f += '<br>';

	f += '<p>入库时间</p>';
	f += '<input type="datetime" value="' + ts.enterStockTime
			+ '" readonly="readonly" name="enterStockTime">';
	f += '<br>';

	f += '<p>备注</p>';
	f += '<textarea rows="3" value="'
			+ ts.remark
			+ '" readonly="readonly" class="update_set" name="remark" maxlength="70">'
			+ ts.remark + '</textarea>';

	f += '<br>';

	f += '<p style="margin-top:20px;color:#ac0eba;">是否已同意入库:';
	f += agree + '</p>';

	f += '<input type="text" value="'
			+ ts.agreeEnterStock
			+ '" readonly="readonly" style="visibility:hidden;" name="agreeEnterStock">';

	f += '<br>';

	f += '<input type="button" id="click_modify" class"btn btn-lg btn-primary" value="点击修改" onclick="modifyProfile();">';
	f += '<div id="inpu"></div>';

	f += '<input type="button" class"btn btn-lg btn-default btn_modify" value="确认修改" style="display:none;margin:15px;">';
	f += '<input type="button" class"btn btn-lg btn-default btn_modify" value="取消修改" style="display:none;margin:15px;">';

	f += '<br>';
	f += '</form>';
	f += '<br>';
	f += '<br>';
	f += '</div>';

	return f;
}

/**
 * [modifyProfile description]
 * 
 * @return {[type]} [description]
 */
function modifyProfile() {
	// 隐藏#click_modify
	$('#click_modify').css('display', 'none');

	// 设置(.update_set).readonly为可读写
	$('.update_set').removeAttr('readonly');

	// 有颜色的为可更改之选项
	$('.update_set').css('background', '#d3ead3');

	// #store_div > div:nth-child(1) > form:nth-child(1) > input:nth-child(13)
	$('#store_div > div:nth-child(1) > form:nth-child(1) > input:nth-child(13)')
			.css('display', 'none');

	// #ts_stockTypeArea=block
	$('#ts_stockTypeArea').css('display', 'block');

	var f = '<input type="button" onclick="submitData()" class"btn btn-lg btn-default" value="确认修改" style="margin:15px;">';
	f += '<input type="reset" class"btn btn-lg btn-default" value="复位" style="margin:15px;">';

	$('#inpu').append(f);
}

/**
 * [submitData description]
 * 
 * @return {[type]} [description]
 */
function submitData() {
	var data = $('#store_div > div:nth-child(1) > form:nth-child(1)')
			.serialize();
	console.log(data);

	var uri = '/stocker-manager/StockController/modifiedStoreGoodHandler';

	$.ajax({
		url : uri,
		data : {
			'tStock' : data
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				layer.msg('成功修改' + rr.data + '件储存货物资料', function() {
					layer.closeAll();
					location.reload();
				});
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param element
 * @returns
 */
function exhibitsByTypeNum(element) {
	var tdArea = $('#stockTypeArea-' + element.purchaseId);

	switch (element.stockTypeArea) {
	case 0:
		tdArea.text('电器区');
		break;

	case 1:
		tdArea.text('食品区');
		break;

	case 2:
		tdArea.text('服装区');
		break;

	case 3:
		tdArea.text('日用品区');
		break;

	case 4:
		tdArea.text('饮品区');
		break;

	case 5:
		tdArea.text('混装区');
		break;

	case 6:
		tdArea.text('家具区');
		break;

	case 7:
		tdArea.text('玩具区');
		break;

	case 8:
		tdArea.text('药品区');
		break;

	case 9:
		tdArea.text('仓外临时区');
		break;
	}

}