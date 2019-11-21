$(function() {
	// readOutputSubstanceLogHandler();
	readOutputSubstanceLogHandler01(null);
})

/* global variable */
var current = $('.current_own');
var total = $('.total_own');
var has_previous = $('.has_previous');
var has_next = $('.has_next');

/* ----------------------------------------------- */

/**
 * 
 * @param key
 * @returns
 */
function pageTurns(key) {
	var index = parseInt(current.text());

	var bool = '';

	switch (key) {
	case 0:
		readOutputSubstanceLogHandler01(0);
		break;

	case 1:// 上页
		bool = has_previous.text();

		if (bool === 'false') {
			return;
		}

		index = index - 2;
		readOutputSubstanceLogHandler01(index);
		break;

	case 2:
		bool = has_next.text();

		if (bool === 'false') {
			return;
		}

		readOutputSubstanceLogHandler01(index);
		break;

	case 3:
		index = parseInt(total.text()) - 1;
		readOutputSubstanceLogHandler01(index);
		break;
	}

}

/**
 * 
 * @param index
 * @returns
 */
function readOutputSubstanceLogHandler01(index) {
	console.log(index);

	var uri = '/stocker-manager/ApprovalController/readOutputSubstanceLogHandler01';

	var selector = $('.logs_records');

	$.ajax({
		url : uri,
		type : 'GET',
		data : {
			'pageth' : index
		},
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				selector.empty();
				selector.html(rr.data.textContent);

				current.text(rr.data.currentPage + 1);
				total.text(rr.data.totalPages);
				has_previous.text(rr.data.isPrevious);
				has_next.text(rr.data.isNext);
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
function readOutputSubstanceLogHandler() {
	var uri = '/stocker-manager/ApprovalController/readOutputSubstanceLogHandler';

	var selector = $('body > main > div');

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