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

	for (var index = 0; index < rds.length; index++) {
		if (rds[index] >= 0 && rds[index] <= 15) {
			$('.RegionDepartment').eq(index).text('常川分部');
		} else if (rds[index] >= 16 && rds[index] <= 21) {
			$('.RegionDepartment').eq(index).text('滨河分部');
		} else if (rds[index] >= 22 && rds[index] <= 29) {
			$('.RegionDepartment').eq(index).text('上天院分部');
		} else if (rds[index] >= 30 && rds[index] <= 39) {
			$('.RegionDepartment').eq(index).text('鸣皋分部');
		} else if (rds[index] >= 40 && rds[index] <= 49) {
			$('.RegionDepartment').eq(index).text('焦王分部');
		} else if (rds[index] >= 50 && rds[index] <= 59) {
			$('.RegionDepartment').eq(index).text('申坡分部');
		} else if (rds[index] >= 60 && rds[index] <= 69) {
			$('.RegionDepartment').eq(index).text('遵王分部');
		} else if (rds[index] >= 70 && rds[index] <= 79) {
			$('.RegionDepartment').eq(index).text('常海山分部');
		} else if (rds[index] >= 80 && rds[index] <= 89) {
			$('.RegionDepartment').eq(index).text('海神分部');
		} else if (rds[index] >= 90 && rds[index] <= 99) {
			$('.RegionDepartment').eq(index).text('老君堂分部');
		} else if (rds[index] >= 100 && rds[index] <= 129) {
			$('.RegionDepartment').eq(index).text('鸦岭分部');
		} else if (rds[index] >= 130 && rds[index] <= 149) {
			$('.RegionDepartment').eq(index).text('酒后分部');
		} else if (rds[index] >= 150 && rds[index] <= 169) {
			$('.RegionDepartment').eq(index).text('平等分部');
		} else if (rds[index] >= 170 && rds[index] <= 199) {
			$('.RegionDepartment').eq(index).text('卷奥分部');
		} else {
			$('.RegionDepartment').eq(index).text('富留店分部');
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
	// 按classname获取一长串String
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
 * 格林威治时间转为普通格式
 * 
 * @param greenwich
 * @returns
 */
function GMTToStr(greenwich) {
	var date = new Date(greenwich);

	var gener = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
			+ date.getDate();

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
	var content = '<select class="seles_second" style="height: 55px;width: 130px" onchange="seleSec()"><option>常川</option>'
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
			+ '<option>卷奥</option>'
			+ '<option>富留店</option></select>';

	return content;
}

/**
 * 职权岗位之HTML
 * 
 * @return {}
 */
function optionCompetenceContent() {
	var content = '<select class="seles_second" style="height: 55px;width: 130px" onchange="seleSec()"><option>管理员</option>'
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
	var content = '<select class="seles_second" style="height: 55px;width: 130px" onchange="seleSec()"><option>已激活</option>'
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
				str = $('#select_second_area select option:selected').text();// data
			});
	console.log(str);

	$.ajax({
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
					var tblbody = '<tr> <td>#{usrid}</td> '
							+ '<td>#{usrname}</td> '
							+ '<td class="RegionDepartment">#{regionDepartment}</td> '
							+ '<td class="Competences">#{competence}</td> '
							+ '<td class="active_status">#{activeStatus}</td> '
							+ '<td>#{phone}</td> '
							+ '<td class="timeDate">#{regTime}</td> '
							+ '<td class="timeDate">#{modifiedTime}</td>'
							+ '<td><a href="javascript:earseByUid(#{usrid})">褫革</a></td>'
							+ '<td><a href="emerge?aid=#{usrid}">修葺</a></td>'
							+ '<td><a href="javascript:singleResetLock(#{usrid})">重置</a></td>'
							+ '<td><a href="javascript:singleCancel(#{usrid})">注销</a></td>'
							+ '<td><a href="#" onclick="singleActive(#{usrid})">激活</a></td>'
							+ '</tr>';

					tblbody = tblbody.replace(/#{usrid}/g, list[i].usrid);
					tblbody = tblbody.replace(/#{usrname}/g, list[i].usrname);
					tblbody = tblbody.replace(/#{regionDepartment}/g,
							list[i].regionDepartment);
					tblbody = tblbody.replace(/#{competence}/g,
							list[i].competence);
					tblbody = tblbody.replace(/#{activeStatus}/g,
							list[i].activeStatus);
					tblbody = tblbody.replace(/#{phone}/g, list[i].phone);
					tblbody = tblbody.replace(/#{regTime}/g, list[i].regTime);
					tblbody = tblbody.replace(/#{modifiedTime}/g,
							list[i].modifiedTime);

					$("#tbody_content").append(tblbody);

				}
			}
		}
	});
};

/**
 * 点击事件,获取文本框中的值,通过阿贾克斯发与控制器
 */
function getValu() {
	var uname = document.getElementById('searching').value;// data
	console.log(uname);

	if (uname == null || uname == '') {
		alert('您还未填写账户名字');
		return;
	}

	$.ajax({
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
					var tblbody = '<tr> <td>#{usrid}</td> '
							+ '<td>#{usrname}</td> '
							+ '<td class="RegionDepartment">#{regionDepartment}</td> '
							+ '<td class="Competences">#{competence}</td> '
							+ '<td class="active_status">#{activeStatus}</td> '
							+ '<td>#{phone}</td> '
							+ '<td class="timeDate">#{regTime}</td> '
							+ '<td class="timeDate">#{modifiedTime}</td>'
							+ '<td><a href="javascript:earseByUid(#{usrid})">褫革</a></td>'
							+ '<td><a href="emerge?aid=#{usrid}">修葺</a></td>'
							+ '<td><a href="javascript:singleResetLock(#{usrid})">重置</a></td>'
							+ '<td><a href="javascript:singleCancel(#{usrid})">注销</a></td>'
							+ '<td><a href="#" onclick="singleActive(#{usrid})">激活</a></td>'
							+ '</tr>';

					tblbody = tblbody.replace(/#{usrid}/g, list[i].usrid);
					tblbody = tblbody.replace(/#{usrname}/g, list[i].usrname);
					tblbody = tblbody.replace(/#{regionDepartment}/g,
							list[i].regionDepartment);
					tblbody = tblbody.replace(/#{competence}/g,
							list[i].competence);
					tblbody = tblbody.replace(/#{activeStatus}/g,
							list[i].activeStatus);
					tblbody = tblbody.replace(/#{phone}/g, list[i].phone);
					tblbody = tblbody.replace(/#{regTime}/g, list[i].regTime);
					tblbody = tblbody.replace(/#{modifiedTime}/g,
							list[i].modifiedTime);

					$("#tbody_content").append(tblbody);

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
						$("#log_substance")
								.append('<h1>what is your problem?</h1>')
					}
				}
			})
}