$(document).ready(function() {
	exhibitionHandler();
})

/**
 * 
 * @returns
 */
function exhibitionHandler() {
	var uri = "";

	$.ajax({
		url : uri,
		type : 'GET',
		dataType : 'json',
		success : function(rr) {
			if (rr.state === 200) {
				console.log(rr.data);
				console.log(rr.data[2]);
			} else {
				layer.alert(rr.message, function() {
					setTimeout(function() {
						layer.closeAll();
					}, 600);
				});
			}
		}
	})
}