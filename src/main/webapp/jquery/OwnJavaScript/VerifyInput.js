/**
 * 验证input是否已全部填完
 */
function veifyIsInputNull() {
	$('input').each(function() {
				// trim():除空格
				switch ($(this).val().trim()) {
					case "" :
						alert('未填完');
						return false;
						break;

					case null :
						alert('未填完');
						return false;
						break;

					default :
						return true;
						break;
				}

			});

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
	function judgeIs(arg0,arg1,arg2,arg3,arg4,arg5) {
		var arr=new Array(arg0,arg1,arg2,arg3,arg4,arg5);
		var arr000=[];

		for (var i = 0; i < arr.length; i++) {
			if ( arr[i] !=null ) {
				arr000.push(arr[i]);
			} 
		}

		var exp=new RegExp(/^(0|[1-9][0-9]*)(\.\d+)?$/);

		for (var i = 0; i < arr000.length; i++) {
			if (exp.test(arr000[i])==false||arr000[i]==0) {
				return false;
			}
		}

		return true;
	}
