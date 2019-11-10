$(document).ready(function() {
	pagingDisplayHandler();
})

/* global variable */
var tbody = $('.salers_tbl_list tbody');

/* selectors */
var total_page_nums = $(".total_page_nums");
var current_page_nums = $(".current_page_nums");
var previous_page_bool = $(".previous_page_bool");
var next_page_bool = $(".next_page_bool");
var shows_rows = $('.shows_rows');

/**
 * 
 * @returns
 */
function pagingDisplayHandler() {
	var uri = '/stocker-manager/SaleController/pagingDisplayHandler';

	$.ajax({
		url : uri,
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				executeAppendToTbody(rr.data.data);
				executeAppendOther(rr.data);
				
			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param p
 * @returns
 */
function executeAppendOther(p) {
	total_page_nums.text(p.totalPages)
	current_page_nums.text(p.currentPageth);
	previous_page_bool.text(p.hasPreviousPage);
	next_page_bool.text(p.hasNextPage);
	shows_rows.text(p.rows);
}

/**
 * 
 * @param list
 * @returns
 */
function executeAppendToTbody(list) {
	tbody.empty();

	var n = 1;

	for (var i = 0; i < list.length; i++) {
		var html = '<tr>';

		html += '<td>';
		html += '<input type="checkbox" class="td_order_number" value="'
				+ list[i].id + '">';
		html += '</td>';

		html += '<td>';
		html += n++;
		html += '</td>';

		html += '<td>';
		html += list[i].commodity;
		html += '</td>';

		html += '<td>';
		html += list[i].customer;
		html += '</td>'

		html += '<td>';
		html += list[i].quantity;
		html += '</td>'

		html += '<td>';
		html += list[i].saleTime;
		html += '</td>'

		html += '<td>';
		html += '<a href="javascript:void(' + list[i].id + ')">查看</a>';
		html += '</td>'

		html += '<td>';
		html += '<a href="javascript:void(' + list[i].id + ')">删除</a>';
		html += '</td>'

		html += '</tr>';

		tbody.append(html);
	}

	n = 1;
}
