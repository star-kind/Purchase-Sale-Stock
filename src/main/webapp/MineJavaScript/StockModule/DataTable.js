/**
 * 开幕雷击
 */
$(function() {
	exhibitDataList();
})

function exhibitDataList() {
	var url = '/stocker-manager/';

	$.ajax({
		url : url,
		dataType : 'json',
		type : 'GET',
		success : function(rr) {
			if (rr.state === 200) {
				if (rr.data != null || '') {
					var list = rr.data;

					$('#example2 tbody').empty();

					executes(list);// 执行赋予表格内容

					exhibitsAmount(list);// .exhibits-amount
				}
			} else {
				layer.alert(rr.message);
			}
		}
	})

}