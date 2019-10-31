$(function() {
	readOutputSubstanceLogHandler();
})

/**
 * 
 * @returns
 */
function readOutputSubstanceLogHandler() {
	var uri = '/stocker-manager/ApprovalController/readOutputSubstanceLogHandler';

	var selector = $('body > main > div');

	$.ajax({
		url : uri,
		type : 'post',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				selector.html(rr.data);
			} else {
				layer.alert(rr.message);
			}
		}
	})
}