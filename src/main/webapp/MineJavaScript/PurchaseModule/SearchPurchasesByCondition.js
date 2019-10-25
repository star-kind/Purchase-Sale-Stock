/**
 * 
 * @returns
 */
$(document).on('change', '#select_id01', function() {
	var text = $('#select_id01').val();
	console.log(text);

	switchBlockByText(text);
})

/**
 * switch be based on #select_id01.value case to generate which content
 * 
 * @param text
 * @returns
 */
function switchBlockByText(text) {

	switch (text) {
	/* 以下为click提交 */
	case '按供应商搜索':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	case '按ID搜索':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	case '按名称搜索':
		// 需先使second_select_area匿迹
		$('#second_select_area').css('display', 'none');

		// 使#second_input_area现形
		$('#second_input_area').css('display', 'block');
		break;

	/* 以下为change提交 */
	case '按是否支付搜索':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateIsPay();
		$('#select_id12').html(content);
		break;

	case '按支付方式':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generatePaymethod();
		$('#select_id12').html(content);
		break;

	case '按是否已取货搜索':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateTakedGoods();
		$('#select_id12').html(content);
		break;

	case '按货品类型搜索':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateCommodityType();
		$('#select_id12').html(content);
		break;

	case '按是否获批搜索':
		// 需先使second_input_area匿迹
		$('#second_input_area').css('display', 'none');

		// 使#second_select_area现形
		$('#second_select_area').css('display', 'block');

		// get the generate OPTION'S CONTENT from function
		// take OPTION'S CONTENT html into #select_id12
		var content = generateIsAgree();
		$('#select_id12').html(content);
		break;
	}

}

/**
 * 
 * @returns
 */
function generateIsPay() {
	var content = '<option value="0">未支付</option>';
	content += '<option value="1">已支付</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generatePaymethod() {
	var content = '<option value="0">现金</option>';
	content += '<option value="1">网银</option>';
	content += '<option value="2">信用卡</option>';
	content += '<option value="3">其它</option>';

	return content;
}

/**
 * 
 * @returns
 */
function generateTakedGoods() {
	var content = '<option value="0">未取货</option>';
	content += '<option value="1">已取货</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generateCommodityType() {
	var content = '<option value="0">电器</option>';
	content += '<option value="1">食品</option>';
	content += '<option value="2">服装</option>';
	content += '<option value="3">日用品</option>';
	content += '<option value="4">饮品</option>';
	content += '<option value="5">其它</option>';
	content += '<option value="6">玩具</option>';
	content += '<option value="7">家具</option>';
	content += '<option value="8">药品</option>';
	return content;
}

/**
 * 
 * @returns
 */
function generateIsAgree() {
	var content = '<option value="0">未批准</option>';
	content += '<option value="1">已同意</option>';
	return content;
}
