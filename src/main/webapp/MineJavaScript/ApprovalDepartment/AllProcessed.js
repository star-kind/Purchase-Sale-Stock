/**
 * AllProcessed.jsp
 */
$(function() {
	exhibitionAllHandler();
	obtainIDAndNamesHandler();
})

/**
 * 
 * @returns
 */
function exhibitionAllHandler() {
	var uri = "/stocker-manager/ApprovalController/exhibitionAllHandler";

	$.ajax({
		url : uri,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				$('.table_boby').empty();

				inToTbody(rr.data);

			} else {
				layer.alert(rr.message);
			}
		}
	});
}

/**
 * 
 * @param x
 * @returns
 */
function inToTbody(x) {
	for (var i = 0; i < x.length; i++) {
		var tr = '<tr id="rows_' + x[i].id + '">';

		tr += '<td><input type="checkbox" value="' + x[i].id
				+ '" class="td_order_number">';
		tr += '</td>';

		var dept = settingDepartmentNumber(x[i].departmentNumber);
		tr += '<td>';
		tr += dept;
		tr += '</td>';

		tr += '<td>';
		tr += x[i].approvalsTime;
		tr += '</td>';

		tr += '<td>';
		tr += x[i].replyOpinion;
		tr += '</td>';

		tr += '<td>';
		tr += x[i].originalOrder;
		tr += '</td>';

		// 审核决定
		var b = settingApproveOperates(x[i].approveOperates);

		tr += '<td>';
		tr += b;
		tr += '</td>';

		// 审核者
		tr += '<td>';
		tr += x[i].auditor;
		tr += '</td>';

		tr += '<td>';
		tr += '<a href="javascript:void(' + x[i].id + ')">';
		tr += '删除';
		tr += '</a>';
		tr += '</td>';

		tr += '<td>';
		tr += '<a href="javascript:void(' + x[i].id + ')">';
		tr += '再次审核';
		tr += '</a>';
		tr += '</td>';

		tr += '</tr>';

		$('.table_boby').append(tr);

	}

}

/**
 * 
 * @returns
 */
function obtainIDAndNamesHandler() {
	var uri = '/stocker-manager/account/obtainIDAndNamesHandler';

	var uid_uname = $('.uid_uname > p:nth-child(1)');

	$.ajax({
		url : uri,
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);

				// TODO
				uid_uname.append(rr.data);

			} else {
				layer.alert(rr.message);
			}
		}
	});

}

/**
 * 
 * @param approveOperates
 * @returns
 */
function settingApproveOperates(approveOperates) {
	var b = '否决';

	if (approveOperates == true) {
		b = '同意';
		return b;
	}

	return b;
}

/**
 * 
 * @param departmentNumber
 * @returns
 */
function settingDepartmentNumber(departmentNumber) {
	var dept = null;

	switch (departmentNumber) {
	case 2:
		dept = '采购部'
		break;

	case 3:
		dept = '销售部';
		break;

	case 4:
		dept = '仓储部';
		break;

	}

	return dept;
}
