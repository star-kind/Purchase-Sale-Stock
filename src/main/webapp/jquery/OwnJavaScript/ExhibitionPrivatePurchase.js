/**
 * ExhibitionPrivatePurchase.jsp开幕预览
 */
$(document).ready(function() {
	exhibits();
});

var url = '/stocker-manager/PurchaseController/exhibitionPurchaseByOperatorHandler';

var tbodyJQ = $('#purchase_table_tbody');

/**
 * 申请单数据展览
 * 
 * @returns
 */
function exhibits() {
	$.ajax({
		url : url,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				if (rr.data != null || '') {
					tbodyJQ.empty();

					var list = rr.data;

					victory(list);
				}
			} else {
				console.log(rr.message);
				tbodyJQ.hide();
			}
		}
	});
}

/**
 * 胜利执行
 * 
 * @param list
 * @returns
 */
function victory(list) {
	var n = 0;

	for (var i = 0; i < list.length; i++) {
		var tr = '<tr id="pid_#{purchaseId}" class="active">'
				+ '<td>'
				+ '<input type="checkbox" onclick="getNextText()">'
				+ ++n
				+ '</td>'
				+ '<td>#{purchaseId}</td>'
				+ '<td>#{commodity}</td>'
				+ '<td>#{supplier}</td>'
				+ '<td>#{purchaseTime}</td>'
				+ '<td><a href="javascript:revampPrepare(#{purchaseId})">修改</a></td>'
				+ '<td><a href="javascript:surveyDetail(#{purchaseId})">详情</a></td>'
				+ '<td><a href="javascript:delete(#{purchaseId})">删除</a></td>'
				+ '</tr>';

		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);
		tr = tr.replace(/#{commodity}/g, list[i].commodity);
		tr = tr.replace(/#{supplier}/g, list[i].supplier);
		tr = tr.replace(/#{purchaseTime}/g, list[i].purchaseTime);

		// 如果未获批,改行就变色
		switch (list[i].isAgree) {
		case 0:// 未获批
			$('#pid_' + list[i].purchaseId).css('background-color', '#eaa7b3');
			break;

		default:
			$('#pid_' + list[i].purchaseId).css('background-color', '#c3eaba');
			break;
		}

		tbodyJQ.append(tr);
	}

	n = 0;
}
