$(document).ready(function() {
	readOutSubstacneAlter();
});

/* global variable */
var url = '/stocker-manager/account/read_substacne';

/* selectors */
var total = $('.total_page');
var prev = $('.has_previous');
var next = $('.has_next');
var current = $('.mine_current_page');

/**
 * 
 * @param key
 * @returns
 */
function pageTurning(key) {
	console.log(key);

	var index = null;

	switch (key) {
	case 0:
		readOutSubstacneAlter(0);
		break;

	case 1:
		if (prev.text() === 'false') {
			return;
		}

		index = parseInt(current.text()) - 1;

		readOutSubstacneAlter(index);
		break;

	case 2:
		if (next.text() === 'false') {
			return;
		}

		index = parseInt(current.text()) + 1;

		readOutSubstacneAlter(index);
		break;

	case 3:
		index = parseInt(total.text());
		readOutSubstacneAlter(index);
		break;

	}

}

/**
 * 显示获得的账号活动系统日志内容
 * 
 * @returns
 */
function readOutSubstacneAlter(index) {
	console.log(index);

	$.ajax({
		url : url,
		dataType : 'json',
		type : 'GET',
		data : {
			'index' : index
		},
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data)

				$(".log_substance").empty();
				$(".log_substance").append(rr.data.textContent);

				total.text(rr.data.totalPages);
				prev.text(rr.data.isPrevious);
				next.text(rr.data.isNext);
				current.text(rr.data.currentPage);
			} else {
				$(".log_substance").append(r.message);
			}
		}
	})
}