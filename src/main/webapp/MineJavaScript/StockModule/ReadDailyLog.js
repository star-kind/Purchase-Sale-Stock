$(function() {
	// readDailyLogHandler();
	readDailyLogHandlerPlus();
	exhibitTableList();
})

/**
 * 
 * @returns
 */
function readDailyLogHandlerPlus() {
	var uri = '/stocker-manager/StockController/readDailyLogHandlerPlus';

	var selector = $('.records_stock_dept');

	$.ajax({
		url : uri,
		type : 'post',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				selector.html(rr.data.textContent);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 作废
 * 
 * @returns
 */
function readDailyLogHandler() {
	var uri = '/stocker-manager/StockController/readDailyLogHandler';

	var selector = $('body > div > div.content-wrapper > section.content > div > div.col-md-9 > div > div:nth-child(3) > div.mailbox-read-info');

	$.ajax({
		url : uri,
		type : 'post',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				selector.html(rr.data);
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

					exhibitLenAmount(list);// .len_amount
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
function exhibitLenAmount(list) {
	var lensTag = $('.len_amount');
	lensTag.empty();

	var length = list.length + 1;
	console.log('applications.length:' + length);

	lensTag.text(length);
}