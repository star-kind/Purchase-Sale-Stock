/**
 * 弹出窗口,延时跳转
 * 
 * @param sentence
 *            弹窗文本
 * @param time
 *            时间
 * @param url
 *            跳转路径
 * @param fn
 *            回调函数,可空
 * @returns
 */
function prompt(sentence, time, url, fn) {
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

		// window.location.href = "cross/toTransfer";
		window.location.href = url;

		if (fn) {
			fn(); // 回调函数
		}

	}, time);
}
