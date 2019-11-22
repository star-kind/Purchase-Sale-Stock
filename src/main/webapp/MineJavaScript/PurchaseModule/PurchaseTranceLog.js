$(function() {
	readSubstanceLogPagingHandler(null)
});

/* global */
var pr = $('.pr');
var ne = $('.ne');
var tot = $('.total_page');
var cur = $('.mine_current_page');

/* +++++++++++++++++++++++++++++++ */

/**
 * 
 * @param key
 * @returns
 */
function pageTurning(key) {
	var j = parseInt(cur.text());
	var bool = '';

	switch (key) {
	case 0:
		readSubstanceLogPagingHandler(0)
		break;

	case 1:
		bool = pr.text();

		if (bool === 'false') {
			return;
		}

		readSubstanceLogPagingHandler(j - 2)
		break;

	case 2:
		bool = ne.text();

		if (bool === 'false') {
			return;
		}

		readSubstanceLogPagingHandler(j)
		break;

	case 3:
		j = parseInt(tot.text()) - 1;
		readSubstanceLogPagingHandler(j)
		break;
	}

}

/**
 * 
 * @param index
 * @returns
 */
function readSubstanceLogPagingHandler(index) {
	console.log(index);

	var uri = '/stocker-manager/PurchaseController/readSubstanceLogPagingHandler';

	$.ajax({
		data : {
			'index' : index
		},
		url : uri,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				$('.records_logs').empty();

				pr.text(rr.data.isPrevious);
				ne.text(rr.data.isNext);
				tot.text(rr.data.totalPages);
				cur.text(rr.data.currentPage + 1);

				$('.records_logs').html(rr.data.textContent);
			} else {
				alert(rr.message);
			}
		}
	});
}