<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>帐号管理模块</title>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>

<!-- 本页面封装之JavaScript函数 -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/AdminWorkable.js"></script>

<!-- JavaScript 点击链接切换division  -->
<script type="text/javascript"
	src="${basePath}/jquery/OwnJavaScript/ClickSwitchDivision.js"></script>

<!-- 表单样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/FormCommon.css">
<!-- 表格样式 -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/TableCommom.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/PatternStyle/Accesses.css">

<!-- bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/CssFrame/bootstrap-theme.css">

</head>
<body>
	<div class="accesses">
		<ul>
			<li><a href="showAllAccount" class="a_links" onclick="opens(1)">Roster</a></li>

			<li><a href="javascript:opens(2)" class="a_links">按类型查看</a></li>

			<li><a href="${basePath}/cross/toSubstacne" class="a_links">Substance</a></li>

			<li><a href="${basePath}/cross/toTransfer" class="a_links">返回Transfer</a></li>
		</ul>
	</div>

	<!-- 账号列表 -->
	<div class="detail_zone div_module"
		style="display: block; text-align: center;" id="room1">

		<table border="1" class="member-table">
			<br>
			<br>
			<caption>The Register List</caption>
			<thead>
				<tr>
					<th class="table-head">全选<input type="checkbox"
						id="select_check" class="head-box"></th>
					<th class="table-head">ID</th>
					<th class="table-head">名字</th>
					<th class="table-head">地区部门</th>
					<th class="table-head">职权</th>
					<th class="table-head">账号状态</th>
					<th class="table-head">电话</th>
					<th class="table-head">注册之日</th>
					<th class="table-head">新改之期</th>
					<th class="table-head">单独操作1</th>
					<th class="table-head">单独操作2</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="i">
					<tr>
						<td><input type="checkbox" name="ids" class="chk-boxs"
							value="${i.usrid}"></td>
						<td>${i.usrid}</td>
						<td>${i.usrname}</td>
						<td class="RegionDepartment">${i.regionDepartment}</td>
						<td class="Competences">${i.competence}</td>
						<td class="active_status">${i.activeStatus}</td>
						<td>${i.phone}</td>
						<td class="timeDate">${i.regTime}</td>
						<td class="timeDate">${i.modifiedTime}</td>
						<td><a href="javascript:earseByUid(${i.usrid})">褫革</a></td>
						<td><a href="${basePath}/account/emerge?aid=${i.usrid}">修葺</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center;">
			<button class="commit_admin00" id="commit_admin11">注销</button>
		</div>
		<div style="text-align: center;">
			<button class="commit_admin00" id="commit_admin22">激活</button>
		</div>
		<div style="text-align: center;">
			<button class="commit_admin00" id="commit_admin33">重置密码</button>
		</div>
	</div>

	<!-- 按条件搜索 -->
	<div class="detail_zone div_module container"
		style="display: none; text-align: center;" id="room2">

		<div class="col-md-10">
			<br>
			<!--  -->
			<select id="select_id00"
				style="height: 40px; margin-right: 82%; margin-top: 10%;">
				<option>按地区部门展示</option>
				<option>按职务权限展示</option>
				<option>按已激活/已注销展示</option>
				<option>按用户名搜索展示</option>
			</select>
			<!--  -->
			<br> <br>
		</div>

		<div class="col-md-12">
			<!-- 亚层:第二层select -->
			<div id="select_second_area" style="width: 130px;"></div>

			<br>
			<!-- 亚层:用于显示input -->
			<div id="div_input_area"></div>

		</div>

		<br>

		<div>
			<table border="1" class="member-table table-bordered">
				<caption>Account List</caption>
				<thead>
					<tr>
						<th class="table-head">ID</th>
						<th class="table-head">名字</th>
						<th class="table-head">地区部门</th>
						<th class="table-head">职权</th>
						<th class="table-head">账号状态</th>
						<th class="table-head">电话</th>
						<th class="table-head">注册之日</th>
						<th class="table-head">新改之期</th>
						<th class="table-head">操作-除</th>
						<th class="table-head">操作-辑</th>
						<th class="table-head">密码复位</th>
						<th class="table-head">注销</th>
						<th class="table-head">激活</th>
					</tr>
				</thead>

				<tbody id="tbody_content">
				</tbody>
			</table>
		</div>
	</div>

</body>

<script type="text/javascript">
	// 全局变量
	var checkboxArr = new Array();
	//var isAll = false;

	// 全选/全不选
	$("#select_check").click(function() {
		// alert($selectCheck.prop("checked"));
		if ($("#select_check").prop("checked") == true) {
			// 上面的复选框已被选中
			$(":checkbox[name='ids']").prop("checked", true);

			// 获取name=ids的已勾选之复选框的值,压入数组checkArr
			/* $("input[name='ids']:checked").each(function() {
				checkboxArr.push(this.value);
			}); */

			// 取值结束后重新初始化
			//checkboxArr = [];
		} else {

			// 上面的复选框没被选中
			$(":checkbox[name='ids']").prop("checked", false);
		}
	});

	/* 注销 */
	$('#commit_admin11').click(function() {
		// 多选/已选的
		var items = $("input[name='ids']:checked");

		items.each(function() {
			checkboxArr.push(this.value);
		});

		if (checkboxArr.length < 1) {
			alert('还没选中任何一个账号');
			return;
		}

		console.log(checkboxArr);

		$.ajax({
			type : 'POST',
			url : 'multiple_cancel',
			data : {
				'usrids' : checkboxArr.join(',')
			},
			dataType : 'json',
			success : function(rr) {
				if (rr.state == 200) {
					alert(rr.data + "个账号已注销");
					location.reload();
				} else {
					alert('系统故障');
				}
			}
		});

		// 取值结束后重新初始化
		checkboxArr = [];
	});

	/* 激活账号 */
	$('#commit_admin22').click(function() {
		// 多选/已选的
		var items = $("input[name='ids']:checked");

		items.each(function() {
			checkboxArr.push(this.value);
		});

		if (checkboxArr.length < 1) {
			alert('还没选中任何一个账号');
			return;
		}

		console.log(checkboxArr);

		$.ajax({
			type : 'POST',
			url : 'multiple_active',
			data : {
				'usrids' : checkboxArr.join(',')
			},
			dataType : 'json',
			success : function(rr) {
				if (rr.state == 200) {
					alert(rr.data + "个账号已激活");
					location.reload();
				} else {
					alert('系统故障');
				}
			}
		});

		// 取值结束后重新初始化
		checkboxArr = [];
	});

	/* 重置密码 */
	$('#commit_admin33').click(function() {
		// 多选/已选的
		var items = $("input[name='ids']:checked");

		items.each(function() {
			checkboxArr.push(this.value);
		});

		if (checkboxArr.length < 1) {
			alert('还没选中任何一个账号');
			return;
		}

		console.log(checkboxArr);

		$.ajax({
			type : 'POST',
			url : 'multiple_reset_pwd',
			data : {
				'usrids' : checkboxArr.join(',')
			},
			dataType : 'json',
			success : function(rr) {
				if (rr.state == 200) {
					alert(rr.data + "个账号已重置密码");
					location.reload();
				} else {
					alert('系统故障');
				}
			}
		});

		// 取值结束后重新初始化
		checkboxArr = [];
	});

	/* -------------------------------------------------- */
	/* 根据第一行下拉框决定第二行下拉框内容,change事件 */
	$('#select_id00').change(function() {
		var option = '';
		var selectSecond = document.getElementById('select_second_area');//根据id获取第二层select区域
		var divInputArea = document.getElementById('div_input_area');//根据id获取input区域

		$('#select_id00 option:selected').each(function() {
			// 获取下拉框选项之值
			option = $('#select_id00 option:selected').text();
		});
		console.log(option);

		if (option == '按地区部门展示') {
			$('#tbody_content').empty();
			$('#div_input_area').empty();
			selectSecond.innerHTML = optionRDContent();

		} else if (option == '按职务权限展示') {
			$('#tbody_content').empty();
			$('#div_input_area').empty();
			selectSecond.innerHTML = optionCompetenceContent();

		} else if (option == '按已激活/已注销展示') {
			$('#tbody_content').empty();
			$('#div_input_area').empty();
			selectSecond.innerHTML = optionActiveStatusContent();

		} else if (option == '按用户名搜索展示') {
			$('#tbody_content').empty();
			$('#select_second_area').empty();
			divInputArea.innerHTML = divInputContent();
		}
	});
</script>
</html>