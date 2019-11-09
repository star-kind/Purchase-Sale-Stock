$(function() {
	// readDailyLogHandler();
	readDailyLogHandlerPlus();
	exhibitTableList();
})

/* global variable */
var uri_path = '/stocker-manager/StockController/readDailyLogHandlerPlus';

/**
 * 
 * @returns
 */
function readDailyLogHandlerPlus() {
	$.ajax({
		url : uri_path,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				putInto(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param y
 * @returns
 */
function pageNumber(y) {
	console.log('y:' + y);

	switch (y) {
	case 0:
		var param = pageDown();
		pageTurn(param);
		break;

	case 1:
		var param = pageUp();
		pageTurn(param);
		break;

	case 2:
		pageTurn(0);
		break;

	case 3:
		var total = $('.total_page_index').text();
		pageTurn(total);
		break;
	}

}

/**
 * 上一页
 * 
 * @returns
 */
function pageUp() {
	console.log('pageUp():');

	var n = null;

	var current = transform($('.current_page_index').text());
	var previous = transform($('.previous_page_index').text());
	var next = transform($('.next_page_index').text());
	var total = transform($('.total_page_index').text());

	if (current > 0 && previous == true) {
		n = current - 1;
		console.log(n);
	}

	return n;
}

/**
 * 下一页
 * 
 * @returns
 */
function pageDown() {
	console.log('pageDown():');

	var n = null;

	var current = transform($('.current_page_index').text());
	var previous = transform($('.previous_page_index').text());
	var next = transform($('.next_page_index').text());
	var total = transform($('.total_page_index').text());

	if (current < total && next == true) {
		n = current + 1;
		console.log(n);
	}

	return n;
}

/**
 * 转型:string转boolean或number
 * 
 * @param key
 * @returns
 */
function transform(key) {
	console.log(this);

	switch (key) {
	case 'false':
		key = false;
		break;

	case 'true':
		key = true;
		break;

	default:
		key = parseInt(key);
		break;
	}

	console.log(key);
	console.log(typeof (key));

	return key;
}

/**
 * 翻页
 * 
 * @param param
 * @returns
 */
function pageTurn(param) {
	console.log('param==' + param);

	if (param == null || '') {
		return;
	}

	$.ajax({
		url : uri_path,
		data : {
			'pageNum' : param
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				putInto(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param data
 * @returns
 */
function putInto(data) {
	console.log(data);

	$('.records_stock_dept').empty();
	$('.records_stock_dept').append(data.textContent);

	$('.current_page_index').text(data.currentPage);
	$('.total_page_index').text(data.totalPages);
	$('.previous_page_index').text(data.isPrevious);
	$('.next_page_index').text(data.isNext);
}

/*-----------------------------------------------------------------------------------*/

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