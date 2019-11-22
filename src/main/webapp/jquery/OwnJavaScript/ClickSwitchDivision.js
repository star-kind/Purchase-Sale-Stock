/**
 * 点击链接切换division
 * 
 * @param {}
 *            obj
 */
function opens(obj) {
	var divModule = document.getElementsByClassName("div_module");

	console.log('divModule.length:' + divModule.length);

	for (var i = 1; i <= divModule.length; i++) {
		if (obj == i) {

			document.getElementById('room' + i).style.display = "block";

		} else {

			document.getElementById('room' + i).style.display = "none";

		}
	}
}

/**
 * [switchStatus description]
 * 
 * @param {[type]}
 *            obj [description]
 * @return {[type]} [description]
 */
function switchStatus(obj) {
	var tag_select = $('.tag_select');

	for (let i = 0; i < tag_select.length; i++) {
		if (obj == i) {
			$('#tag' + i).show();

		} else {
			$('#tag' + i).hide();

		}
	}
}