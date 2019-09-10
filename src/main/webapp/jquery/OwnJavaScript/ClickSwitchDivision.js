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
