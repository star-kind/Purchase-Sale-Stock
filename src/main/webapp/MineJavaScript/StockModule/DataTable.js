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

					exhibitsAmount(list);// .exhibits-amount
				}
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
		tr += '<td class="sorting_1"><input type="checkbox" value="#{id}"></td>';
		tr += '<td>#{storeCommodity}</td>';
		tr += '<td>#{storeQuantity}</td>';
		tr += '<td id="stockTypeArea-#{purchaseId}"></td>';
		tr += '<td><a style="text-decoration: underline;" href="#{purchaseId}">点击查看</a></td>';
		tr += '</tr>';

		tr = tr.replace(/#{id}/g, list[i].id);
		tr = tr.replace(/#{storeCommodity}/g, list[i].storeCommodity);
		tr = tr.replace(/#{storeQuantity}/g, list[i].storeQuantity);
		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);

		// tr = tr.replace(/#{stockTypeArea}/g, list[i].stockTypeArea);
		console.log('typeof(list[i].stockTypeArea):'
				+ typeof (list[i].stockTypeArea));

		$('#example2 tbody').append(tr);

		exhibitsByTypeNum(list[i]);
	}
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