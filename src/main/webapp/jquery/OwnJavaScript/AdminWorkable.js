$(document).ready(function() {
	regionDeptNoAsTrueName();
	competenceNumShowJobName();
	activeStatusExhibit();
	changingDateFormat();
});

/**
 * 地区部门编号转为展示真名
 * 
 * @returns
 */
function regionDeptNoAsTrueName() {
	var rds = [];

	$('.RegionDepartment').each(function() {
		var rd = $(this).text();
		rds.push(rd);
	});

	console.log(rds);

	for (var i = 0; i < rds.length; i++) {
		switch (rds[i]) {
		case '0':
			$('.RegionDepartment').eq(i).text('滨河');
			break;

		case '1':
			$('.RegionDepartment').eq(i).text('上天院');
			break;

		case '2':
			$('.RegionDepartment').eq(i).text('鸣皋');
			break;

		case '3':
			$('.RegionDepartment').eq(i).text('焦王');
			break;

		case '4':
			$('.RegionDepartment').eq(i).text('申坡');
			break;

		case '5':
			$('.RegionDepartment').eq(i).text('遵王');
			break;

		case '6':
			$('.RegionDepartment').eq(i).text('常海山');
			break;

		case '7':
			$('.RegionDepartment').eq(i).text('老君堂');
			break;

		case '8':
			$('.RegionDepartment').eq(i).text('鸦岭');
			break;

		case '9':
			$('.RegionDepartment').eq(i).text('酒后');
			break;

		case '10':
			$('.RegionDepartment').eq(i).text('平等');
			break;

		case '11':
			$('.RegionDepartment').eq(i).text('夏堡');
			break;

		case '12':
			$('.RegionDepartment').eq(i).text('富留店');
			break;

		default:
			$('.RegionDepartment').eq(i).text('总部');
			break;

		}
	}

}

/**
 * 权限编号转示岗位名称
 * 
 * @returns
 */
function competenceNumShowJobName() {
	var compets = [];

	$('.Competences').each(function() {
		var compet = $(this).text();
		compets.push(compet);
	});

	for (var i = 0; i < compets.length; i++) {
		if (compets[i] == 0) {
			$('.Competences').eq(i).text('管理员');
		} else if (compets[i] == 1) {
			$('.Competences').eq(i).text('总经理');
		} else if (compets[i] == 2) {
			$('.Competences').eq(i).text('采购经理');
		} else if (compets[i] == 3) {
			$('.Competences').eq(i).text('销售经理');
		} else if (compets[i] == 4) {
			$('.Competences').eq(i).text('仓库主管');
		} else {
			$('.Competences').eq(i).text('普通雇员');
		}
	}
}

/**
 * 账号展示是否已激活
 * 
 * @returns
 */
function activeStatusExhibit() {
	var activeStatus = new Array();

	$('.active_status').each(function() {
		var activeState = $(this).text();
		activeStatus.push(activeState);
	});

	for (var i = 0; i < activeStatus.length; i++) {
		if (activeStatus[i] == 1) {
			$('.active_status').eq(i).text('已激活');
		} else {
			$('.active_status').eq(i).text('未激活');
			$('.active_status').eq(i).css('background-color', '#a1b101');
		}
	}
}

/**
 * 将格林威治时间格式转为年月日格式
 * 
 * @returns
 */
function changingDateFormat() {
	// 按类选择器获取一长串String
	var arr = $('.timeDate').text();

	// 每28个字符为一单位日期String
	var unit = 28;
	var part = arr.length / unit;

	var j = 0;
	var strArr = [];
	var vari = "";
	for (var i = 1; i <= part; i++) {
		// 分段截取28字符
		var sub = arr.substring(j, unit * i);
		j = unit * i;

		vari = GMTToStr(sub);

		$('.timeDate').eq(i - 1).text(vari);
	}

}

/**
 * 格林威治时间转为普通年月日格式
 * 
 * @param greenwich
 * @returns
 */
function GMTToStr(greenwich) {
	var date = new Date(greenwich);

	var gener = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			+ date.getDate();

	gener += ' ';
	gener += date.getHours() + ':';
	gener += date.getMinutes() + ':';
	gener += date.getSeconds();

	return gener;
}

/**
 * 删除账户
 * 
 * @param usrid
 * @returns
 */
function earseByUid(usrid) {
	if (!confirm('确定删除此账户吗?')) {
		return;
	}
	$.ajax({
		type : 'POST',
		url : 'earse',
		data : {
			'usrid' : usrid
		},
		dataType : "json",
		success : function(r) {
			if (r.state == 200) {
				alert('删除成功');
				location.reload();
			} else {
				alert(r.message);
			}
		}
	});
}

/** ***********第三div所辖API[beginning]********** */
/* 返回第二行下拉框文本内容 */

/**
 * 地区部门之HTML
 * 
 * @return {}
 */
function optionRDContent() {
	var content = '<select class="seles_second" style="height: 40px;width: 166px" onchange="seleSec()">'
			+ '<option>滨河</option>'
			+ '<option>上天院</option>'
			+ '<option>鸣皋</option>'
			+ '<option>焦王</option>'
			+ '<option>申坡</option>'
			+ '<option>遵王</option>'
			+ '<option>常海山</option>'
			+ '<option>老君堂</option>'
			+ '<option>鸦岭</option>'
			+ '<option>酒后</option>'
			+ '<option>平等</option>'
			+ '<option>夏堡</option>'
			+ '<option>富留店</option></select>';

	return content;
}

/**
 * 职权岗位之HTML
 * 
 * @return {}
 */
function optionCompetenceContent() {
	var content = '<select class="seles_second" style="height: 40px;width: 166px" onchange="seleSec()"><option>管理员</option>'
			+ '<option>总经理</option>'
			+ '<option>采购经理</option>'
			+ '<option>销售经理</option>'
			+ '<option>仓库主管</option>'
			+ '<option>普通雇员</option></select>';

	return content;
}

/**
 * 是否注销/激活之HTML
 * 
 * @return {}
 */
function optionActiveStatusContent() {
	var content = '<select class="seles_second" style="height: 40px;width: 166px" onchange="seleSec()"><option>已激活</option>'
			+ '<option>已注销</option></select>';

	return content;
}

/**
 * 按名搜索之HTML
 * 
 * @return {}
 */
function divInputContent() {
	var content = '<br><input type="text" name="Usrname" id="searching" placeholder="请输入用户名"><br>'
			+ '<br><input type="button" value="搜索" onclick="getValu()">';

	return content;
}

/**
 * 第二行下拉框,change事件,获取第二行下拉框选项文本,通过阿贾克斯发与控制器
 */
function seleSec() {
	var str = '';
	$('#select_second_area select option:selected').each(function() {
		// 获取下拉框选项之值
		str = $(this).text();// data
	});
	console.log(str);

	$
			.ajax({
				url : 'search_by_threeType_scene',
				data : {
					'str' : str
				},
				dataType : 'json',
				type : 'POST',
				success : function(r) {
					if (r.state == 200) {
						$('#tbody_content').empty();
						var list = r.data;

						for (var i = 0; i < list.length; i++) {
							/** 表格中一行 */
							var tblbody = '<tr id="aid_#{usrid}"> '
									+ '<td>#{usrid}</td> '
									+ '<td>#{usrname}</td> '
									+ '<td id="RegionDepartment_#{usrid}">#{regionDepartment}</td> '
									+ '<td id="Competences_#{usrid}">#{competence}</td> '
									+ '<td id="active_status_#{usrid}">#{activeStatus}</td> '
									+ '<td>#{phone}</td> '
									+ '<td class="timeDate">#{regTime}</td> '
									+ '<td class="timeDate">#{modifiedTime}</td>'
									+ '<td><a href="javascript:earseByUid(#{usrid})">褫革</a></td>'
									+ '<td><a href="emerge?aid=#{usrid}">修葺</a></td>'
									+ '<td><a href="javascript:singleResetLock(#{usrid})">重置</a></td>'
									+ '<td><a href="javascript:singleCancel(#{usrid})">注销</a></td>'
									+ '<td><a href="#" onclick="singleActive(#{usrid})">激活</a></td>'
									+ '</tr>';

							tblbody = tblbody.replace(/#{usrid}/g,
									list[i].usrid);
							tblbody = tblbody.replace(/#{usrname}/g,
									list[i].usrname);
							tblbody = tblbody.replace(/#{regionDepartment}/g,
									list[i].regionDepartment);
							tblbody = tblbody.replace(/#{competence}/g,
									list[i].competence);
							tblbody = tblbody.replace(/#{activeStatus}/g,
									list[i].activeStatus);
							tblbody = tblbody.replace(/#{phone}/g,
									list[i].phone);
							tblbody = tblbody.replace(/#{regTime}/g,
									list[i].regTime);
							tblbody = tblbody.replace(/#{modifiedTime}/g,
									list[i].modifiedTime);

							$("#tbody_content").append(tblbody);

							/* 代入 */
							exhibitsTdByCompetence(list[i]);
							exhibitsByActiveStatus(list[i]);
							exhibitsByDeptNo(list[i]);
						}
					}
				}
			});
};

/* ============================================================== */
/**
 * 据权限码显示职务
 * 
 * @param acc
 * @returns
 */
function exhibitsTdByCompetence(acc) {

	switch (acc.competence) {

	case 0:
		$('#Competences_' + acc.usrid).text('管理员');
		break;

	case 1:
		$('#Competences_' + acc.usrid).text('总经理');
		break;

	case 2:
		$('#Competences_' + acc.usrid).text('采购经理');
		break;

	case 3:
		$('#Competences_' + acc.usrid).text('销售经理');
		break;

	case 4:
		$('#Competences_' + acc.usrid).text('仓库主管');
		break;

	case 5:
		$('#Competences_' + acc.usrid).text('普通雇员');
		break;

	}
}

/**
 * 根据状态码显示文字状态
 * 
 * @param acc
 * @returns
 */
function exhibitsByActiveStatus(acc) {

	switch (acc.activeStatus) {

	case 0:
		$('#active_status_' + acc.usrid).text('注销');
		$('#aid_' + acc.usrid).css('background-color', '#db8484');
		break;

	case 1:
		$('#active_status_' + acc.usrid).text('激活');
		break

	}
}

/**
 * 根据部门编号显示文字
 * 
 * @param acc
 * @returns
 */
function exhibitsByDeptNo(acc) {
	switch (acc.regionDepartment) {

	case 0:
		$('#RegionDepartment_' + acc.usrid).text('滨河');
		break;

	case 1:
		$('#RegionDepartment_' + acc.usrid).text('上天院');
		break;

	case 2:
		$('#RegionDepartment_' + acc.usrid).text('鸣皋');
		break;

	case 3:
		$('#RegionDepartment_' + acc.usrid).text('焦王');
		break;

	case 4:
		$('#RegionDepartment_' + acc.usrid).text('申坡');
		break;

	case 5:
		$('#RegionDepartment_' + acc.usrid).text('遵王');
		break;

	case 6:
		$('#RegionDepartment_' + acc.usrid).text('常海山');
		break;

	case 7:
		$('#RegionDepartment_' + acc.usrid).text('老君堂');
		break;

	case 8:
		$('#RegionDepartment_' + acc.usrid).text('鸦岭');
		break;

	case 9:
		$('#RegionDepartment_' + acc.usrid).text('酒后');
		break;

	case 10:
		$('#RegionDepartment_' + acc.usrid).text('平等');
		break;

	case 11:
		$('#RegionDepartment_' + acc.usrid).text('夏堡');
		break;

	case 12:
		$('#RegionDepartment_' + acc.usrid).text('富留店');
		break;

	default:
		$('#RegionDepartment_' + acc.usrid).text('总部');
		break;

	}

}

/* ========================================================================= */
/**
 * 点击事件,获取文本框中的值,通过阿贾克斯发与控制器
 */
function getValu() {
	var uname = document.getElementById('searching').value;// data
	console.log(uname);

	if (uname == null || uname === '') {
		alert('您还未填写账户名字');
		return;
	}

	$
			.ajax({
				url : 'search_by_confuse_name',
				data : {
					'uname' : uname
				},
				dataType : 'json',
				type : 'POST',
				success : function(r) {
					if (r.state == 200) {
						$('#tbody_content').empty();
						var list = r.data;

						for (var i = 0; i < list.length; i++) {
							/** 表格中一行 */
							var tblbody = '<tr id="aid_#{usrid}"> '
									+ '<td>#{usrid}</td> '
									+ '<td>#{usrname}</td> '
									+ '<td id="RegionDepartment_#{usrid}">#{regionDepartment}</td> '
									+ '<td id="Competences_#{usrid}">#{competence}</td> '
									+ '<td id="active_status_#{usrid}">#{activeStatus}</td> '
									+ '<td>#{phone}</td> '
									+ '<td class="timeDate">#{regTime}</td> '
									+ '<td class="timeDate">#{modifiedTime}</td>'
									+ '<td><a href="javascript:earseByUid(#{usrid})">褫革</a></td>'
									+ '<td><a href="emerge?aid=#{usrid}">修葺</a></td>'
									+ '<td><a href="javascript:singleResetLock(#{usrid})">重置</a></td>'
									+ '<td><a href="javascript:singleCancel(#{usrid})">注销</a></td>'
									+ '<td><a href="#" onclick="singleActive(#{usrid})">激活</a></td>'
									+ '</tr>';

							tblbody = tblbody.replace(/#{usrid}/g,
									list[i].usrid);
							tblbody = tblbody.replace(/#{usrname}/g,
									list[i].usrname);
							tblbody = tblbody.replace(/#{regionDepartment}/g,
									list[i].regionDepartment);
							tblbody = tblbody.replace(/#{competence}/g,
									list[i].competence);
							tblbody = tblbody.replace(/#{activeStatus}/g,
									list[i].activeStatus);
							tblbody = tblbody.replace(/#{phone}/g,
									list[i].phone);
							tblbody = tblbody.replace(/#{regTime}/g,
									list[i].regTime);
							tblbody = tblbody.replace(/#{modifiedTime}/g,
									list[i].modifiedTime);

							$("#tbody_content").append(tblbody);

							/* 代入 */
							exhibitsTdByCompetence(list[i]);
							exhibitsByActiveStatus(list[i]);
							exhibitsByDeptNo(list[i]);

						}
					}
				}
			});
}

/** --------第三div所辖API[ending]------------ */

/**
 * 单个账户重置密码
 * 
 * @param {}
 *            usrid
 */
function singleResetLock(usrid) {
	var path = 'single/' + usrid + '/reset_pwd';
	$.ajax({
		url : path,
		dataType : 'json',
		type : 'GET',
		success : function(r) {
			if (r.state == 200) {
				alert('该账号密码复位成功')
			} else {
				alert('系统故障,请排查维修')
			}

		}
	})
}

/**
 * 注销单个账户
 * 
 * @param {}
 *            usrid
 */
function singleCancel(usrid) {
	var path = 'single/' + usrid + '/cancel';
	if (!(confirm('确定要注销此账号?'))) {
		return;
	}
	$.ajax({
		url : path,
		dataType : 'json',
		type : 'GET',
		success : function(r) {
			if (r.state == 200) {
				alert('已将' + r.data + '个账号注销')
			} else {
				alert('系统故障,请排查维修')
			}

		}
	})
}

/**
 * 激活单个账户
 * 
 * @param {}
 *            usrid
 */
function singleActive(usrid) {
	var path = 'single/' + usrid + '/active';

	$.ajax({
		url : path,
		dataType : 'json',
		type : 'GET',
		success : function(r) {
			if (r.state == 200) {
				alert('已激活' + r.data + '个账号');
			} else {
				alert('系统故障,请排查维修')
			}

		}
	})
}

/**
 * 显示获得的账号活动系统日志内容
 */
function readOutSubstacne() {
	$.ajax({
		url : '/stocker-manager/account/read_substacne',
		dataType : 'json',
		type : 'GET',
		success : function(r) {
			if (r.state == 200) {
				$("#log_substance").empty();
				$("#log_substance").html(r.data);

			} else {
				$("#log_substance").append('<h1>what is your problem?</h1>')
			}
		}
	})
}