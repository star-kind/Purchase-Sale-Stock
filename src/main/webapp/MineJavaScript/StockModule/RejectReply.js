/**
 * 开幕
 */
$(document).ready(function() {
	console.log("h211o,35016");
});

$(document)
		.on(
				'click',
				'#submits',
				function() {
					var url = '/stocker-manager/StockController/regToExternalHandler';

					var formData = $('form').serialize();
					var textArea = $('textarea').val();
					console.log(formData + ", " + textArea);

					if ($.trim(textArea) == '') {
						layer.alert('回复理由禁止为空', {
							icon : 1
						});
						return;
					}

					$
							.ajax({
								url : url,
								data : {
									'formData' : formData,
									'textArea' : textArea
								},
								contentType : "application/x-www-form-urlencoded;charset=UTF-8",// 解决编码问题
								type : 'post',
								dataType : 'json',
								success : function(rr) {
									if (rr.state == 200) {
										layer
												.msg(
														'已移入外部临时仓库',
														function() {
															location.href = '/stocker-manager/StockController/checkEnterCompetenceHandler';
														});

									} else {
										layer.alert(rr.message);
									}
								}
							})
				})