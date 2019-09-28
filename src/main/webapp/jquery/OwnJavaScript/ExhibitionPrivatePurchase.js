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
		p.isAgree = '已获批'
	} else {
		p.isAgree = '未获批'
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