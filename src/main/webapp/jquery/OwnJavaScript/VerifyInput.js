/**
 * 验证输入非空之加强
 * 
 * @param selector
 * @returns
 */
function verifyIsInputNullPlus(selector) {
	var arrays = [];

	var j = 0;

	$(selector).each(function(j) {
		console.log(this.value);

		arrays.push(this.value);
	});

	console.log(arrays);

	// 把数组代入函数
	return judgeAtRecurrent(arrays);
}

/**
 * 递归中判断非空
 * 
 * @param args
 * @returns
 */
function judgeAtRecurrent(args) {

	for (var i = 0; i < args.length; i++) {
		if (args[i] == null || args[i] === '' || $.trim(args[i]) == '') {
			alert('第' + (i + 1) + '个空未填入');
			return false;
		}
	}

	return true;
}

/**
 * 正则验证少于等于6个参数是否为非零正实数,若不传入直接设空即可
 * 
 * @param {}
 *            arg0
 * @param {}
 *            arg1
 * @param {}
 *            arg2
 * @param {}
 *            arg3
 * @param {}
 *            arg4
 * @param {}
 *            arg5
 * @return {Boolean}
 */
function judges(arg0, arg1, arg2, arg3, arg4, arg5) {
	var arr = new Array(arg0, arg1, arg2, arg3, arg4, arg5);
	var arraies = [];

	for (var i = 0; i < arr.length; i++) {
		if (arr[i] != null) {
			arraies.push(arr[i]);
		}
	}

	var exp = new RegExp(/^(0|[1-9][0-9]*)(\.\d+)?$/);

	for (var i = 0; i < arraies.length; i++) {
		if (exp.test(arraies[i]) == false || arraies[i] == 0) {
			return false;
		}
	}

	return true;
}
