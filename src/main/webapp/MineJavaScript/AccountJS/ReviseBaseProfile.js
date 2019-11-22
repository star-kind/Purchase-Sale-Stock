$(document).ready(function() {
	emergeProfile();
});

/**
 * 展示待改资料
 * 
 * @returns
 */
function emergeProfile() {
	var uname = $("#input00");
	var phone = $("#input01");
	var spanHint = $("#span_hint");

	$.ajax({
		url : '/stocker-manager/account/exhibitionBaseProfileHandler',
		type : 'GET',
		dataType : 'json',
		success : function(json) {
			if (json.state == 200) {
				uname.prop('placeholder', json.data.usrname);
				phone.prop('placeholder', json.data.phone);
			} else {
				spanHint.text('系统繁忙,请刷新页面再重试');
			}
		}
	});

}

/**
 * 提交
 * 
 * @returns
 */
function confirmChange() {
	var form = document.getElementById('mineForm');
	var fd = new FormData(form);

	var usrname = fd.get("usrname");
	var phone = fd.get("phone");

	if (usrname == null || usrname == '' || phone == null || phone == '') {
		alert('数据未填完');
		return;
	}

	$.ajax({
		url : '/stocker-manager/account/reviseBaseProfileHandler',
		data : {
			"usrname" : usrname,
			"phone" : phone
		},
		type : 'POST',
		dataType : 'json',
		success : function(json) {
			if (json.state == 200) {
				// alert('修改资料成功');
				// location.href = '/stocker-manager/cross/toTransfer';

				prompt('修改资料成功', 2000, '/stocker-manager/cross/toTransfer');
			} else {
				// $('#span_hint').text(json.message);
				alert(json.message);
			}
		}
	});
}