$(function() {
	readDailyLogHandler();
})

/**
 * 
 * @returns
 */
function readDailyLogHandler() {
	var uri = '/stocker-manager/StockController/readDailyLogHandler';

	var selector = $('body > div > div.content-wrapper > section.content > div > div.col-md-9 > div > div:nth-child(3) > div.mailbox-read-info');

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