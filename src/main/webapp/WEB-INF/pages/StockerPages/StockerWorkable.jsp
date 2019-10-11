<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>仓库管理</title>

<link rel="stylesheet"
	href="${basePath}/AdminLTE/dist/css/AdminLTE.min.css">

<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/bower_components/Ionicons/css/ionicons.min.css">

<!-- AdminLTE Skins -->
<link rel="stylesheet"
	href="${basePath}/AdminLTE/dist/css/skins/skin-blue.min.css">
<body class="skin-blue sidebar-mini"
	style="height: auto; min-height: 100%;">
	<div class="wrapper" style="height: auto; min-height: 100%;">

		<header class="main-header">
			<!-- Logo -->
			<a href="../../index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>返回</b>导航页</span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<!-- <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a> -->

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->

						<!-- Notifications: style can be found in dropdown.less -->

						<!-- Tasks: style can be found in dropdown.less -->

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"
							style="padding-right: 66px;"> <img
								src="${basePath}/AdminLTE/dist/img/user2-160x160.jpg"
								class="user-image" alt="User Image"> <span
								class="hidden-xs current_username">xxx</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="${basePath}/AdminLTE/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image">

									<p>
										Alexander Pierce - Web Developer <small>Member since
											Nov. 2012</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Sales</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li>
							<!-- <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a> -->
						</li>
					</ul>
				</div>
			</nav>
		</header>

		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar" style="height: auto;">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="${basePath}/AdminLTE/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p class="current_username">xxx</p>
						<a href="#">
						<!-- <i class="fa fa-circle text-success"></i> -->
						 Online</a>
					</div>
				</div>
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<!-- <i class="fa fa-search"></i> -->
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu tree" data-widget="tree">
					<li class="header">MAIN NAVIGATION</li>
					<!-- <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../../AdminLTE/index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
            <li><a href="../../AdminLTE/index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>Layout Options</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../../AdminLTE/layout/top-nav.html"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
            <li><a href="../../AdminLTE/layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed</a></li>
            <li><a href="../../AdminLTE/layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed</a></li>
            <li><a href="../../AdminLTE/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Collapsed Sidebar</a></li>
          </ul>
        </li>
        <li>
          <a href="../widgets.html">
            <i class="fa fa-th"></i> <span>Widgets</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">new</small>
            </span>
          </a>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Charts</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../../AdminLTE/charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
            <li><a href="../../AdminLTE/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="../../AdminLTE/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="../../AdminLTE/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>UI Elements</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../UI/general.html"><i class="fa fa-circle-o"></i> General</a></li>
            <li><a href="../UI/icons.html"><i class="fa fa-circle-o"></i> Icons</a></li>
            <li><a href="../UI/buttons.html"><i class="fa fa-circle-o"></i> Buttons</a></li>
            <li><a href="../UI/sliders.html"><i class="fa fa-circle-o"></i> Sliders</a></li>
            <li><a href="../UI/timeline.html"><i class="fa fa-circle-o"></i> Timeline</a></li>
            <li><a href="../UI/modals.html"><i class="fa fa-circle-o"></i> Modals</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Forms</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../forms/general.html"><i class="fa fa-circle-o"></i> General Elements</a></li>
            <li><a href="../forms/advanced.html"><i class="fa fa-circle-o"></i> Advanced Elements</a></li>
            <li><a href="../forms/editors.html"><i class="fa fa-circle-o"></i> Editors</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>Tables</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../tables/simple.html"><i class="fa fa-circle-o"></i> Simple tables</a></li>
            <li><a href="../tables/data.html"><i class="fa fa-circle-o"></i> Data tables</a></li>
          </ul>
        </li>
        <li>
          <a href="../calendar.html">
            <i class="fa fa-calendar"></i> <span>Calendar</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
              <small class="label pull-right bg-blue">17</small>
            </span>
          </a>
        </li> -->
					<li class="treeview active menu-open"><a href="#"> 
					<!-- <i class="fa fa-envelope"></i> -->
					 <span>入库申请队列</span> 
					 <!-- <span class="pull-right-container"> 
						<i class="fa">+</i>
					 </span> -->
					</a>
						<ul class="treeview-menu">
							<li class="active"><a href="mailbox.html">Inbox <span
									class="pull-right-container"> <span
										class="label label-primary pull-right">??</span>
								</span>
							</a></li>
							<!-- <li><a href="compose.html">Compose</a></li>
            <li><a href="read-mail.html">Read</a></li> -->
						</ul></li>
					<!-- <li class="treeview">
          <a href="#">
            <i class="fa fa-folder"></i> <span>Examples</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../examples/invoice.html"><i class="fa fa-circle-o"></i> Invoice</a></li>
            <li><a href="../examples/profile.html"><i class="fa fa-circle-o"></i> Profile</a></li>
            <li><a href="../examples/login.html"><i class="fa fa-circle-o"></i> Login</a></li>
            <li><a href="../examples/register.html"><i class="fa fa-circle-o"></i> Register</a></li>
            <li><a href="../examples/lockscreen.html"><i class="fa fa-circle-o"></i> Lockscreen</a></li>
            <li><a href="../examples/404.html"><i class="fa fa-circle-o"></i> 404 Error</a></li>
            <li><a href="../examples/500.html"><i class="fa fa-circle-o"></i> 500 Error</a></li>
            <li><a href="../examples/blank.html"><i class="fa fa-circle-o"></i> Blank Page</a></li>
            <li><a href="../examples/pace.html"><i class="fa fa-circle-o"></i> Pace Page</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-share"></i> <span>Multilevel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
            <li class="treeview">
              <a href="#"><i class="fa fa-circle-o"></i> Level One
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                <li class="treeview">
                  <a href="#"><i class="fa fa-circle-o"></i> Level Two
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
          </ul>
        </li>
        <li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <li class="header">LABELS</li>
        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li> -->
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 955.8px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					队列 <small>?? 份未处理申请单</small>
				</h1>
				<ol class="breadcrumb" style="font-size: small;">
					<li><a href="#">
					<!-- <i class="fa fa-dashboard"></i> -->
					 首页</a></li>
					<li class="active">队列</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<!-- <div class="col-md-3">
          <a href="compose.html" class="btn btn-primary btn-block margin-bottom">Compose</a>
        
          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Folders</h3>
        
              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="box-body no-padding" style="">
              <ul class="nav nav-pills nav-stacked">
                <li class="active"><a href="#"><i class="fa fa-inbox"></i> Inbox
                  <span class="label label-primary pull-right">12</span></a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> Sent</a></li>
                <li><a href="#"><i class="fa fa-file-text-o"></i> Drafts</a></li>
                <li><a href="#"><i class="fa fa-filter"></i> Junk <span class="label label-warning pull-right">65</span></a>
                </li>
                <li><a href="#"><i class="fa fa-trash-o"></i> Trash</a></li>
              </ul>
            </div>
            /.box-body
          </div>
          /. box
          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Labels</h3>
        
              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="box-body no-padding" style="">
              <ul class="nav nav-pills nav-stacked">
                <li><a href="#"><i class="fa fa-circle-o text-red"></i> Important</a></li>
                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> Promotions</a></li>
                <li><a href="#"><i class="fa fa-circle-o text-light-blue"></i> Social</a></li>
              </ul>
            </div>
            /.box-body
          </div>
          /.box
        </div> -->
					<!-- /.col -->
					<div class="col-md-9" style="width: 100%;">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">Inbox</h3>

								<div class="box-tools pull-right">
									<div class="has-feedback">
										<input type="text" class="form-control input-sm"
											placeholder="Search for"> 
											<!-- <span class="glyphicon glyphicon-search form-control-feedback"></span> -->
									</div>
								</div>
								<!-- /.box-tools -->
							</div>
							<!-- /.box-header -->
							<div class="box-body no-padding">
								<div class="mailbox-controls">
									<!-- Check all button -->
									<!-- <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                </button> -->
									<div class="btn-group">
										<!-- <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button> -->
									</div>
									<!-- /.btn-group -->
									<!-- <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button> -->
									<div class="pull-right">
										1-50/200
										<div class="btn-group">
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa"><</i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa">></i>
											</button>
										</div>
										<!-- /.btn-group -->
									</div>
									<!-- /.pull-right -->

									<div style="margin-left: 33px;">
										<input type="checkbox" name="" id="total_check">
										<!--  -->
										<span class="p_cols" style="margin-left: 40px;">申请单ID</span>
										<!--  -->
										<span class="p_cols" style="margin-left: 215px;">货物名称</span>
										<!--  -->
										<span class="p_cols" style="margin-left: 500px;">采购时间</span>
									</div>
								</div>

								<div class="table-responsive mailbox-messages">
									<table class="table table-hover table-striped">
										<tbody>
											<tr>
												<td><div class="icheckbox_flat-blue"
														aria-checked="false" aria-disabled="false"
														style="position: relative;">
														<input type="checkbox"
															style="position: absolute; opacity: 0;">
														<ins class="iCheck-helper"
															style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
													</div></td>
												<td class="checkboys">
													<!--  --> <input type="checkbox" name="" id="check_0000">
												</td>
												<td class="mailbox-name"><a href="javascript:void(0);">[采购申请单ID]</a></td>
												<td class="mailbox-subject" style="text-align: center;">
													<b>[货物名]</b> - 尼罗河尼龙
												</td>
												<td class="mailbox-attachment"></td>
												<td class="mailbox-date" style="text-align: right;"><script
														type="text/javascript">
													var t = new Date();
													document.write(t);
												</script></td>
											</tr>

										</tbody>
									</table>
									<!-- /.table -->
								</div>
								<!-- /.mail-box-messages -->
							</div>
							<!-- /.box-body -->
							<div class="box-footer no-padding">
								<div class="mailbox-controls">
									<!-- Check all button -->
									<!-- <button type="button" class="btn btn-default btn-sm checkbox-toggle"><i class="fa fa-square-o"></i>
                </button> -->
									<div class="btn-group">
										<!-- <button type="button" class="btn btn-default btn-sm"><i class="fa fa-trash-o"></i></button>
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-reply"></i></button>
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-share"></i></button> -->
									</div>
									<!-- /.btn-group -->
									<!-- <button type="button" class="btn btn-default btn-sm"><i class="fa fa-refresh"></i></button> -->
									<div class="pull-right">
										1-50/200
										<div class="btn-group">
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa"><</i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa">></i>
											</button>
										</div>
										<!-- /.btn-group -->
									</div>
									<!-- /.pull-right -->
								</div>
							</div>
						</div>
						<!-- /. box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.4.18
			</div>
			<strong>Copyright © 2014-2019 <a href="javascript:void(0);">AdminLTE</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="active"><a
					href="#control-sidebar-theme-demo-options-tab" data-toggle="tab"><i
						class="fa fa-wrench"></i></a></li>
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-user bg-yellow"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>

									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>

									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0)"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>

								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>

									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0)">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>

								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<div id="control-sidebar-theme-demo-options-tab"
					class="tab-pane active">
					<div>
						<h4 class="control-sidebar-heading">Layout Options</h4>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-layout="fixed" class="pull-right">
								Fixed layout</label>
							<p>Activate the fixed layout. You can't use fixed and boxed
								layouts together</p>
						</div>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-layout="layout-boxed" class="pull-right">
								Boxed Layout</label>
							<p>Activate the boxed layout</p>
						</div>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-layout="sidebar-collapse"
								class="pull-right"> Toggle Sidebar</label>
							<p>Toggle the left sidebar's state (open or collapse)</p>
						</div>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-enable="expandOnHover" class="pull-right">
								Sidebar Expand on Hover</label>
							<p>Let the sidebar mini expand on hover</p>
						</div>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-controlsidebar="control-sidebar-open"
								class="pull-right"> Toggle Right Sidebar Slide</label>
							<p>Toggle between slide over content and push content effects</p>
						</div>
						<div class="form-group">
							<label class="control-sidebar-subheading"><input
								type="checkbox" data-sidebarskin="toggle" class="pull-right">
								Toggle Right Sidebar Skin</label>
							<p>Toggle between dark and light skins for the right sidebar</p>
						</div>
						<h4 class="control-sidebar-heading">Skins</h4>
						<ul class="list-unstyled clearfix">
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-blue"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px; background: #367fa9"></span><span
											class="bg-light-blue"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222d32"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Blue</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-black"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div
										style="box-shadow: 0 0 2px rgba(0, 0, 0, 0.1)"
										class="clearfix">
										<span
											style="display: block; width: 20%; float: left; height: 7px; background: #fefefe"></span><span
											style="display: block; width: 80%; float: left; height: 7px; background: #fefefe"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Black</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-purple"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-purple-active"></span><span class="bg-purple"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222d32"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Purple</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-green"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-green-active"></span><span class="bg-green"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222d32"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Green</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-red"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-red-active"></span><span class="bg-red"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222d32"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Red</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-yellow"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-yellow-active"></span><span class="bg-yellow"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #222d32"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin">Yellow</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-blue-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px; background: #367fa9"></span><span
											class="bg-light-blue"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Blue
									Light</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-black-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div
										style="box-shadow: 0 0 2px rgba(0, 0, 0, 0.1)"
										class="clearfix">
										<span
											style="display: block; width: 20%; float: left; height: 7px; background: #fefefe"></span><span
											style="display: block; width: 80%; float: left; height: 7px; background: #fefefe"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Black
									Light</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-purple-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-purple-active"></span><span class="bg-purple"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Purple
									Light</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-green-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-green-active"></span><span class="bg-green"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Green
									Light</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-red-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-red-active"></span><span class="bg-red"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Red
									Light</p></li>
							<li style="float: left; width: 33.33333%; padding: 5px;"><a
								href="javascript:void(0)" data-skin="skin-yellow-light"
								style="display: block; box-shadow: 0 0 3px rgba(0, 0, 0, 0.4)"
								class="clearfix full-opacity-hover"><div>
										<span
											style="display: block; width: 20%; float: left; height: 7px;"
											class="bg-yellow-active"></span><span class="bg-yellow"
											style="display: block; width: 80%; float: left; height: 7px;"></span>
									</div>
									<div>
										<span
											style="display: block; width: 20%; float: left; height: 20px; background: #f9fafc"></span><span
											style="display: block; width: 80%; float: left; height: 20px; background: #f4f5f7"></span>
									</div></a>
								<p class="text-center no-margin" style="font-size: 12px">Yellow
									Light</p></li>
						</ul>
					</div>
				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked="">
							</label>

							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked="">
							</label>

							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right"
								checked="">
							</label>

							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked="">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript:void(0)" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script
		src="${basePath}/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${basePath}/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Slimscroll -->
	<script
		src="${basePath}/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="${basePath}/AdminLTE/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${basePath}/AdminLTE/dist/js/adminlte.min.js"></script>
	<!-- iCheck -->
	<script src="${basePath}/AdminLTE/plugins/iCheck/icheck.min.js"></script>
	<!-- Page Script -->
	<script>
		$(function() {
			//Enable iCheck plugin for checkboxes
			//iCheck for checkbox and radio inputs
			// $('.mailbox-messages input[type="checkbox"]').iCheck({
			//   checkboxClass: 'icheckbox_flat-blue',
			//   radioClass: 'iradio_flat-blue'
			// });

			// //Enable check and uncheck all functionality
			$(".checkbox-toggle").click(
					function() {
						var clicks = $(this).data('clicks');
						if (clicks) {
							//Uncheck all checkboxes
							$(".mailbox-messages input[type='checkbox']")
									.iCheck("uncheck");
							$(".fa", this).removeClass("fa-check-square-o")
									.addClass('fa-square-o');
						} else {
							//Check all checkboxes
							$(".mailbox-messages input[type='checkbox']")
									.iCheck("check");
							$(".fa", this).removeClass("fa-square-o").addClass(
									'fa-check-square-o');
						}
						$(this).data("clicks", !clicks);
					});

			//Handle starring for glyphicon and font awesome
			$(".mailbox-star").click(function(e) {
				e.preventDefault();
				//detect type
				var $this = $(this).find("a > i");
				var glyph = $this.hasClass("glyphicon");
				var fa = $this.hasClass("fa");

				//Switch states
				if (glyph) {
					$this.toggleClass("glyphicon-star");
					$this.toggleClass("glyphicon-star-empty");
				}

				if (fa) {
					$this.toggleClass("fa-star");
					$this.toggleClass("fa-star-o");
				}
			});
		});
	</script>
	<!-- AdminLTE for demo purposes -->
	<script src="${basePath}/AdminLTE/dist/js/demo.js"></script>

</body>


<!-- jQuery 3 -->
<script
	src="${basePath}/AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script
	src="${basePath}/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/AdminLTE/dist/js/adminlte.min.js"></script>
</html>