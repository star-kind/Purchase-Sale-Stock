/**
 * ExhibitionPrivatePurchase.jsp开幕预览
 */
$(document).ready(function() {
	exhibits();
});

var url = '/stocker-manager/PurchaseController/exhibitionPurchaseByOperatorHandler';

var tbodyJQ = $('#purchase_table_tbody');

/**
 * 申请单数据展览
 * 
 * @returns
 */
function exhibits() {
	$.ajax({
		url : url,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				if (rr.data != null || '') {
					tbodyJQ.empty();

					var list = rr.data;

					victory(list);

					/* 分页函数 */
					tablePaging();

				}
			} else {
				console.log(rr.message);
				tbodyJQ.hide();
			}
		}
	});
}

/**
 * 胜利执行
 * 
 * @param list
 * @returns
 */
function victory(list) {
	var n = 0;

	for (var i = 0; i < list.length; i++) {
		var tr = '<tr id="pid_#{purchaseId}" class="active">'
				+ '<td>'
				+ '<input type="checkbox" onclick="getNextText()">'
				+ ++n
				+ '</td>'
				+ '<td>#{purchaseId}</td>'
				+ '<td>#{commodity}</td>'
				+ '<td>#{supplier}</td>'
				+ '<td>#{purchaseTime}</td>'
				+ '<td><a href="javascript:revampPrepare(#{purchaseId})">修改</a></td>'
				+ '<td><a href="javascript:surveyDetail(#{purchaseId})">详情</a></td>'
				+ '<td><a href="javascript:delete(#{purchaseId})">删除</a></td>'
				+ '</tr>';

		tr = tr.replace(/#{purchaseId}/g, list[i].purchaseId);
		tr = tr.replace(/#{commodity}/g, list[i].commodity);
		tr = tr.replace(/#{supplier}/g, list[i].supplier);
		tr = tr.replace(/#{purchaseTime}/g, list[i].purchaseTime);

		tbodyJQ.append(tr);

		if (list[i].isAgree == 0) {// 如若未获批,字体异色
			$('#pid_' + list[i].purchaseId).css('color', '#eb3871');
		}

	}

	n = 0;
}

/* ============================ 分隔-翻页功能============================ */

/* 全局变量 */
var numCount; // 数据总数量
var columnsCounts; // 数据列数量
var pageCount; // 每页显示的数量
var pageNum; // 总页数
var currPageNum; // 当前页数

/* 页面标签变量 */
var blockTable;
var preSpan;
var firstSpan;
var nextSpan;
var lastSpan;
var pageNumSpan;
var currPageSpan;

function tablePaging() {
	// 页面标签变量
	blockTable = document.getElementById("blocks");// 获取表格ID节点
	preSpan = document.getElementById("spanPre");
	firstSpan = document.getElementById("spanFirst");
	nextSpan = document.getElementById("spanNext");
	lastSpan = document.getElementById("spanLast");
	pageNumSpan = document.getElementById("spanTotalPage");
	currPageSpan = document.getElementById("spanPageNum");

	numCount = document.getElementById("blocks").rows.length - 1; // 取table的行数作为数据总数量(减去标题行1)
	console.log('numCount:' + numCount);

	columnsCounts = blockTable.rows[0].cells.length;
	pageCount = 3;

	pageNum = parseInt(numCount / pageCount);
	if (0 != numCount % pageCount) {
		pageNum += 1;
	}

	firstPage();
};

/* ============================ 分隔-弹出层============================ */
/**
 * 查看采购单详情
 * 
 * @param purchaseId
 * @returns
 */
function surveyDetail(purchaseId) {
	var url = '/stocker-manager/PurchaseController/findPurchaseByIdHandler';

	$.ajax({
		url : url,
		data : {
			'purchaseId' : purchaseId
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				var p = rr.data;

				var detail = generatePurchaseContent(p);

				eject(detail);

			} else {
				alert(rr.message);

			}

		}
	})

}

/**
 * 采购申请单弹出
 * 
 * @param content
 * @returns
 */
function eject(detail) {
	console.log(detail);

	layer.open({
		type : 1,// 若为页面层
		title : '采购申请单',
		closeBtn : true,// 关闭窗体按钮,真,显示
		shade : 0.4,
		id : 'form_detail_purchase',// 为上层div设1个ID,防止重复出现
		resize : true,// 更改大小,假,禁止
		moveType : 1,
		area : [ '800px', '400px' ],// 宽,高
		content : detail
	});

}

/**
 * 生成单份申请单数据内容
 * 
 * @param p
 * @returns
 */
function generatePurchaseContent(p) {
	/* 是否支付 */
	if (p.isPay === 0) {
		p.isPay = '未支付';
	} else {
		p.isPay = '已支付';
	}

	/* 是否入库 */
	if (p.isEnterStore === 0) {
		p.isEnterStore = '未入仓库'
	} else {
		p.isEnterStore = '已入仓库'
	}

	/* 是否获批 */
	if (p.isAgree == 0) {
		p.isAgree = '未获批'
	} else {
		p.isAgree = '已获批'
	}

	/* 支付方式 */
	switch (p.paymentMethod) {
	case 0:
		p.paymentMethod = '现金'
		break;

	case 1:
		p.paymentMethod = '网银'
		break;

	case 2:
		p.paymentMethod = '信用卡'
		break;

	case 3:
		p.paymentMethod = '其他'
		break;
	}

	var formHtml = '<div style="text-align:center;font-size:26px;margin-left:0%;">';
	formHtml += '<form>';

	formHtml += '<p>采购申请单单号';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.purchaseId + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购货物名';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.commodity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已批准';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.isAgree + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>供应商';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.supplier + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购数量';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.quantity + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购金额';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.amountMoney + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>支付方式';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.paymentMethod + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已支付';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.isPay + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>是否已入库';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.isEnterStore + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购经办人';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.operator + ' ">';
	formHtml += '</p>';

	formHtml += '<br><p>采购时间';
	formHtml += '<br><input type="text"  readonly="readonly"  value=" '
			+ p.purchaseTime + ' ">';
	formHtml += '</p>';

	formHtml += '</form>';
	formHtml += '</div>';

	return formHtml;
}

/* ============================ 分隔-修改单份采购申请============================ */

/**
 * 显示准备修改的内容
 * 
 * @param purchaseId
 * @returns
 */
function revampPrepare(purchaseId) {
	console.log(purchaseId);

	// 获取原有资料数据
	getPurchaseProfile(purchaseId);

}

/**
 * 获取原有申请单
 * 
 * @param argument
 * @returns
 */
function getPurchaseProfile(argument) {
	var uri = '/stocker-manager/PurchaseController/findPurchaseByIdHandler';

	$.ajax({
		url : uri,
		data : {
			'purchaseId' : argument
		},
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				console.log(rr.data);
				var profile = rr.data;

				// 将原数据传入动态HTML生成函数
				geneateEditFormContent(profile);

			} else {
				alert(rr.message);

			}
		}
	})

}

/**
 * 生成待改之表单内容
 * 
 * @param profile
 * @returns
 */
function geneateEditFormContent(profile) {
	var formContent = '<div style="text-align: left;">';

	formContent += '<span></span>';
	formContent += '<form id="own_edit_form" style="font-size: 20px;">';

	formContent += '<div style="margin-top: 5%;margin-left: 18%;">';

	formContent += '<p style="visibility: hidden;">';
	formContent += '<input type="text" name="purchaseId"  readonly="readonly" value='
			+ profile.purchaseId + '>';
	formContent += '</p>';

	formContent += '<p>输入新货品名:';
	formContent += '<input type="text" class="purchase_input" name="commodity" value='
			+ profile.commodity + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新货商:';
	formContent += '<input type="text" class="purchase_input" name="supplier" value='
			+ profile.supplier + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新采购数量:';
	formContent += '<span></span>';
	formContent += '<input type="text" class="purchase_input" id="quantity" name="quantity" value='
			+ profile.quantity + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>输入新采买金额:';
	formContent += '<input type="text" class="purchase_input" id="amountMoney" name="amountMoney" value='
			+ profile.amountMoney + '>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>选择新支付方式:';
	formContent += '<select name="paymentMethod" value='
			+ profile.paymentMethod + '>';
	formContent += '<option value="0">现金</option>';
	formContent += '<option value="1">网银</option>';
	formContent += '<option value="2">信用卡</option>';
	formContent += '<option value="3">其它</option>';
	formContent += '</select>';
	formContent += '</p>';

	formContent += '<br>';

	formContent += '<p>选择是否已入库:';
	formContent += '<select name="isEnterStore" value=' + profile.isEnterStore
			+ '>';
	formContent += '<option value="0">未入</option>';
	formContent += '<option value="1">已入</option>';
	formContent += '</select>';
	formContent += '</p>';

	formContent += '</div>';
	formContent += '<br>';

	formContent += '<div style="text-align: center;">';
	formContent += '<input type="button" value="提交" onclick="submitPurchaseData()" style="margin:15px;">';
	formContent += '<input type="reset" value="重置" style="margin:15px;">';
	formContent += '</div>';

	formContent += '<br>';

	formContent += '</form>';
	formContent += '</div>';

	console.log(formContent);

	// 代入html内容,并弹出窗体
	ejects2(formContent);

}

/**
 * 弹出待编辑之表单
 * 
 * @param formContent
 * @returns
 */
function ejects2(formContent) {
	layer.open({
		type : 1,
		title : '修改采买申购单',
		area : [ '600px', '480px' ],
		id : [ 'form_area' ],
		resize : true,
		closeBtn : true,
		shade : 0.4,// 遮罩透明度
		content : formContent
	})
}

/**
 * 提交新数据
 * 
 * @returns
 */
function submitPurchaseData() {
	var selector = $('.purchase_input');

	// 校验输入非空
	var verify = verifyIsInputNullPlus(selector);
	console.log('verify-' + verify);
	if (verify === false) {
		return;
	}

	var quantity = $('#quantity').val();
	var amountMoney = $('#amountMoney').val();

	// 检查货品数量是否为正整数
	var expression = new RegExp(/^\+?[1-9][0-9]*$/);
	if (expression.test(quantity) == false) {
		$('#quantity').css('background-color', '#EF9999');
		$('#quantity').prev('span').text('货品数量必须为正整数');
		return;
	}

	// 验证金额与货物数量是否为非零正数
	var r = judges(quantity, amountMoney, null, null, null, null);
	if (r == false) {
		$('#own_edit_form').prev('span').css('color', '#e11d45');
		$('#own_edit_form').prev('span').text('输入的数字不合规');
		return;
	}

	var data = $('#own_edit_form').serialize();

	console.log(data);

	var uri = '/stocker-manager/PurchaseController/editOnePurchaseByIdHandler';

	$.ajax({
		url : uri,
		data : data,
		type : 'POST',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {

				layer.alert('修改成功', function() {
					location.reload();

				})
			} else {
				layer.alert(rr.message);
			}
		}
	})
}
