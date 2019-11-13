$(document).ready(function() {
	viewLogging();
})

/* Global Variable */
var uri = '/stocker-manager/SaleController/viewLogHandler';

/* 数据中转标签选择器 */
var total = $('.total_pages');
var has_previous = $('.has_previous');
var has_next = $('.has_next');
var currnet = $('.current_page');

/**
 * 翻页
 * 
 * @param key
 * @returns
 */
function pageTurn(key) {
	console.log(key);

	var index = null;

	switch (key) {
	case 0:
		// 首页
		viewLogHandler(0);
		break;

	case -1:
		/* 上一页 */
		if (has_previous.text() === 'false') {
			return;
		}

		index = parseInt(currnet.text()) - 1;

		viewLogHandler(index);
		break;

	case -2:
		/* 下页 */
		if (has_next.text() === 'false') {
			return;
		}

		index = parseInt(currnet.text()) + 1;

		viewLogHandler(index);
		break;

	case -3:
		/* 尾页 */
		index = parseInt(total.text());
		
		viewLogHandler(index);
		break;
	}
}

/**
 * 
 * @returns
 */
function viewLogHandler(index) {
	console.log(index);

	$.ajax({
		url : uri,
		dataType : 'json',
		type : 'GET',
		data : {
			'pageIndex' : index
		},
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				$('.log_substance').empty();
				$('.log_substance').append(rr.data.textContent);

				total.text(rr.data.totalPages);
				has_previous.text(rr.data.isPrevious);
				has_next.text(rr.data.isNext);
				currnet.text(rr.data.currentPage);

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
function viewLogging() {
	$.ajax({
		url : uri,
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				$('.log_substance').empty();
				$('.log_substance').append(rr.data.textContent);

				total.text(rr.data.totalPages);
				has_previous.text(rr.data.isPrevious);
				has_next.text(rr.data.isNext);
				currnet.text(rr.data.currentPage);

			} else {
				layer.alert(rr.message);
			}
		}
	})
}