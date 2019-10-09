<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!-- 顶栏 -->
<div class="container" id="top">
	<div class="row">
		<div class="col-md-12">
			<!--加入导航条标题-->
			<div class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<a href="${basePath}/cross/toTransfer" class="navbar-brand">进销存管理系统</a>
				</div>
				
				<form action="##" class="navbar-form navbar-right" rol="search">

					<%-- <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" style="margin-right: 20px; ">
                            登录用户名
                            <span class="glyphicon glyphicon-user"><shiro:principal/></span>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="#">
                                    <span class="glyphicon glyphicon-cog pull-right"></span>
                                    修改个人信息
                                </a>
                            </li>
                            <!-分割线--->
                            <li role="presentation" class="divider"></li>
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="/logout">
                                    <span class="glyphicon glyphicon-off pull-right"></span>
                                    注销登录
                                </a>
                            </li>
                        </ul>
                    </div> --%>

				</form>
				
			</div>
		</div>
	</div>
</div>
