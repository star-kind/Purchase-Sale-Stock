/**
 * 
 */
function commit00() {
	var selector = $("#form_usr :input[type='text']");

	// 校验输入非空, 返回开关量
	var verify = verifyIsInputNullPlus(selector);
	if (verify == false) {
		return;
	}

	var profile = $('#form_usr').serialize();

	$.ajax({
		type : 'POST',
		url : 'account/reg',
		data : profile,
		dataType : 'json',
		success : function(rr) {
			if (rr.state == 200) {
				// alert('注册成功');
				// location.href = 'login.jsp';
				prompt('注册成功', 2000);
			} else {
				document.getElementById('info-tip').innerText = rr.message;
			}
		}
	});
}

/**
 * 弹出窗口
 * 
 * @param sentence
 * @param time
 * @param fn
 * @returns
 */
function prompt(sentence, time, fn) {
	var $div = $('<div></div>');

	$div.css({
		'position' : 'fixed',
		'top' : 0,
		'left' : 0,
		'width' : '100%',
		'height' : '100%',
		'z-index' : '200',
		'background-color' : 'rgba(0,0,0,0.4)',
	});

	var $contentDiv = $('<div>' + sentence + '</div>');

	$contentDiv.css({
		'position' : 'absolute',
		'top' : '50%',
		'left' : '56%',
		'font-size' : '25px',
		'padding' : '50px 100px',
		'border-radius' : '5px',
		'background-color' : '#fff',
		'color' : '#000',
	});

	$div.append($contentDiv);
	$('body').append($div);

	// 获取创建的大小
	var newW = (parseInt($contentDiv.css('width')) + 200) / 2;
	var newH = (parseInt($contentDiv.css('height')) + 100) / 2;

	$contentDiv.css({
		'margin-top' : -newH + 'px',
		'margin-left' : -newW + 'px',
	});

	setTimeout(function() {
		$div.remove();

		location.href = 'login.jsp';

		if (fn) {
			fn(); // 回调函数
		}

	}, time);
}