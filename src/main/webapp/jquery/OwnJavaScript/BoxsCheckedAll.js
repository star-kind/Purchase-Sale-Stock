/**
 * 复选框全选/全取消之效果,#head_check是总开关复选框标签ID
 * 
 * @returns
 */
function headInfluence() {
	if ($('#head_check').prop('checked') == true) {
		$(':checkbox[class="td_order_number"]').prop('checked', true);
	} else {
		$(':checkbox[class="td_order_number"]').prop('checked', false);
	}

}