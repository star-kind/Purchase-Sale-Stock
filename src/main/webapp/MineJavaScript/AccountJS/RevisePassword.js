/**
 * 
 * @returns
 */
function confirmUpdate() {
	var lockWord01 = $('#lockWord01').val();
	var lockWord02 = $('#lockWord02').val();

	if (lockWord01 != lockWord02) {
		alert('两次新密码相异')
		return;
		
	} else if (lockWord01 == null || lockWord01 == '' || lockWord02 == null
			|| lockWord02 == '') {
		alert('您还有参数尚未输入')
		return;
	}

	var form = document.getElementById('mineForm');
	var fd = new FormData(form);

	var oldPassword = fd.get("oldPassword");
	var newPassword = fd.get("newPassword");

	$.ajax({
		url : '/stocker-manager/account/revisePasswordHandler',
		data : {
			'oldPassword' : oldPassword,
			'newPassword' : newPassword
		},
		type : 'POST',
		dataType : 'json',
		success : function(json) {
			if (json.state == 200) {
				alert('修改密码成功');
				location.href = '/stocker-manager/login.jsp';
			} else {
				alert(json.message);
				// $('#span_hint').text(json.message);
			}
		}
	});

}