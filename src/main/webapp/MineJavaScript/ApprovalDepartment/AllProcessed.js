/**
 * AllProcessed.jsp
 */
$(function() {
	getInnerTextFromTags();
	exhibitionAllHandler();

})

// 全局变量
var arrays1 = [];

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

		// 部门
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
		var textName = compareByKeyID(x[i].auditor);
		tr += '<td>';
		tr += textName;
		tr += '</td>';

		tr += '<td>';
		tr += '<a href="javascript:void(' + x[i].id + ')">';
		tr += '删除';
		tr += '</a>';
		tr += '</td>';

		tr += '<td>';
		tr += '<a href="javascript:approvalAgain(' + x[i].id + ')">';
		tr += '再次审核';
		tr += '</a>';
		tr += '</td>';

		tr += '</tr>';

		$('.table_boby').append(tr);

	}

}

/**
 * 
 * @param tid
 * @returns
 */
function approvalAgain(tid) {
	var uri = '/stocker-manager/ApprovalController/obtainTApprovalByIDHandler';

	$.ajax({
		url : uri,
		data : {
			'tid' : tid
		},
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				// layer.open
				ejects(rr.data);
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
function ejects(data) {
	// 修饰Data生成表单内容
	var form = generateForm(data);

	layer.open({
		type : 1,// 若为页面层
		title : '再次审核申请单',
		closeBtn : true,// 关闭窗体按钮,真,显示
		shade : 0.4,
		id : 'dynamic_form',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假:禁止
		moveType : 1,
		area : [ '800px', '480px' ],// 宽,高
		content : form
	});
}

/**
 * 
 * @param data
 * @returns
 */
function generateForm(data) {
	var form = '<div style="font-size:20px;">';

	form += '<form class="approvals_form" style="margin:35px 0 50px 30px;text-align:center;">';

	// 取值
	form += '<input type="text" value="' + data.id
			+ '" id="approval_id" style="display:none;">';

	form += '<br>';

	var dept = settingDepartmentNumber(data.departmentNumber);
	form += '<p>';
	form += '所属部门';
	form += '<br>';
	form += '<input type="text" value="' + dept + '" readonly="readonly">';
	form += '<input type="text" value="' + dept.departmentNumber
			+ '" style="display:none;">';
	form += '</p>';

	form += '<br>';

	form += '<p>';
	form += '审核处理时间';
	form += '<br>';
	form += '<input type="datatime" value="' + data.approvalsTime
			+ '" readonly="readonly">';
	form += '</p>';

	form += '<br>';

	// 取值
	form += '<p>';
	form += '批复意见';
	form += '<br>';
	form += '<textarea rows="3" class="data_replyOpinion" value="'
			+ data.replyOpinion + '" readonly="readonly" maxlength="80">';
	form += data.replyOpinion;
	form += '</textarea>';
	form += '</p>';

	form += '<br>';

	form += '<p>';
	form += '申请单原序号';
	form += '<br>';
	form += '<input type="text" value="' + data.originalOrder
			+ '" readonly="readonly">';
	form += '</p>';

	form += '<br>';

	var textName = compareByKeyID(data.auditor);
	form += '<p>';
	form += '最近审核者';
	form += '<br>';
	form += '<input type="text" value="' + textName + '" readonly="readonly">';
	form += '</p>';

	form += '<br>';

	// 取值
	var b = settingApproveOperates(data.approveOperates);
	form += '<p>';
	form += '审核决定';
	form += '<br>';
	form += '<input type="text" value="' + b + '" readonly="readonly">';

	form += '<div class="radio_approveOperates" style="display:none;">';
	form += '<label style="margin: 0 25px 0 25px;">	';
	form += '<input type="radio" value="1" name="approveOperates" class="data_approveOperates">';
	form += '同意';
	form += '</label>';

	form += '<label style="margin: 0 25px 0 25px;">';
	form += '<input type="radio" value="0" name="approveOperates" class="data_approveOperates">';
	form += '否定';
	form += '</label>';
	form += '</div>';

	form += '</p>';

	form += '<br>';
	form += '<p>';
	form += '<input type="button" value="点击复核" onclick="againViews()">';
	form += '<input type="button" value="确定" onclick="againRevamps();" style="display: none;margin: 0 auto;">';

	form += '</p>';

	form += '</form>';

	form += '</div>'

	return form;
}

/**
 * [againViews description]
 * 
 * @return {[type]} [description]
 */
function againViews() {
	// 隐藏
	$('.approvals_form > p:nth-child(17) > input:nth-child(1)').css('display',
			'none');

	// 显示
	$('.approvals_form > p:nth-child(17) > input:nth-child(2)').css('display',
			'block');

	// 移除readonly
	$('.data_replyOpinion').removeAttr('readonly');

	// 隐藏
	$('.approvals_form > p:nth-child(13) > input:nth-child(2)').css('display',
			'none');

	// 显示
	$('.radio_approveOperates').css('display', 'block');

}

/**
 * [againRevamps description]
 * 
 * @return {[type]} [description]
 */
function againRevamps() {
	var uri = '/stocker-manager/ApprovalController/revampByIDHandler';

	// 取值
	var tid = $('#approval_id').val();
	var data_replyOpinion = $('.data_replyOpinion').val();
	// 获取单选框被选中的值
	var data_approveOperates = $('input:radio[name="approveOperates"]:checked')
			.val();

	if (data_replyOpinion == '' || null) {
		layer.alert('批复意见未输入');
		return;
	} else if (data_approveOperates == null || '') {
		layer.alert('未选择审核决定');
		return;
	}

	console.log(tid + ',' + data_replyOpinion + ',' + data_approveOperates);

	$.ajax({
		url : uri,
		data : {
			'tid' : tid,
			'approveOperates' : data_approveOperates,
			'replyOpinion' : data_replyOpinion
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				layer.msg(rr.data + '份申请单复核成功', function() {
					location.reload();
				});

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

/**
 * [getInnerTextFromTags description]
 * 
 * @return {[type]} [description]
 */
function getInnerTextFromTags() {
	// 遍历获取i标签中的文本,赋予数组
	$('.result_index').each(function() {
		arrays1.push(this.innerText);
	});
	console.log(arrays1);
}

/**
 * [getKeyID description]
 * 
 * @param {[type]}
 *            argument [description]
 * @return {[type]} [description]
 */
function getKeyID(argument) {
	var selectorID = null;

	for (var i = 0; i < arrays1.length; i++) {
		if (arrays1[i] == argument) {
			selectorID = 'result_element_' + arrays1[i];
			// console.log(selectorID);
			return selectorID;
		}
	}

	return null;
}

/**
 * 
 * @param argument
 * @returns 人名
 */
function compareByKeyID(argument) {
	var selectorID = getKeyID(argument);
	// console.log(selectorID);

	var textName = document.getElementById(selectorID).innerText;
	// console.log(textName);

	return textName;
}
