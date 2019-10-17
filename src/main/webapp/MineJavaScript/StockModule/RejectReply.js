/**
 * 开幕
 */
$(document).ready(function() {
	console.log("h211o,35016");
});

$(document).on('click', '#submits', function() {
	var formData = $('form').serialize();
	var textArea = $('textarea').val();
	console.log(formData + ", " + textArea);

	if ($.trim(textArea) == '') {
		layer.alert('回复理由禁止为空', {
			icon : 1
		});
		return;
	}

})