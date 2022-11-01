<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/3/14
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>游客后台主界面</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width， initial-scale=1" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath}/bootstrap/font-awesome.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>

<style type="text/css">
body {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
}

.pageContainer {
	bottom: 0;
	left: 0;
	right: 0;
	top: 53px;
	overflow: auto;
	position: absolute;
	width: 100%;
}

.pageSidebar {
	width: 230px;
	height: 100%;
	overflow: auto;
	padding-bottom: 30px;
	background: #F5F5F5;
}

.footer {
	width: 100%;
	height: 30px;
	line-height: 30px;
	margin-top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	position: absolute;
	z-index: 10;
	background-color: #F0F0F0;
}

.pageContent {
	height: 605px;
	min-width: 768px;
	left: 242px;
	top: 0;
	right: 0;
	z-index: 3;
	margin-top: 55px;
	margin-right: 11px;
	padding-bottom: 30px;
	position: absolute;
	background: rgba(176, 196, 222, 0.2);
	border-radius: 6px;
}

.pageContentTitle {
	height: 20px;
	min-width: 768px;
	left: 242px;
	top: 10px;
	right: 10px;
	z-index: 3;
	position: absolute;
}

.mysearch {
	margin: 10px 0;
}

.btn1 {
	height: 33px;
}

.navbar-collapse {
	padding-right: 5px;
	padding-left: 5px;
}

.nav>li>a {
	color: #444;
	margin: 0 5px;
}

.list-group-item {
	text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" title="logoTitle">火车票购买系统</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li role="presentation"><a href="#">当前身份:游客 <span
							class="badge">${userName}</span></a></li>
					<li role="presentation"><a
						href="${pageContext.request.contextPath}/home.jsp"><span
							class="fa fa-power-off"></span> 退出登录</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 中间主体内容部分 -->
	<div class="pageContainer">
		<!-- 左侧导航栏 -->
		<div class="pageSidebar">
			<! --搜索 -->
			<div class="input-group mysearch">
				<input type="text" class="form-control" id="search"> <span
					class="input-group-btn">
					<button type="button" class="btn btn-default btn1">
						<span class="fa fa-search"></span>
					</button>
				</span>
			</div>

			<div class="list-group">
				<a class="list-group-item active" href="#" style="font-size: 15px">
					<span class="fa fa-home fa-lg"></span> 个人中心
				</a> <a class="list-group-item"
					href="${pageContext.request.contextPath}/GetMyMemberServlet"
					target="mainFrame"> <span class="fa fa-user-circle-o fa-lg"></span>
					我的信息
				</a> <a class="list-group-item"
					href="${pageContext.request.contextPath}/pages/user/myCenter/right/updateMemberPassword.jsp"
					target="mainFrame"> <span class="fa fa-university fa-lg"></span>
					修改密码
				</a>
				 <a class="list-group-item"
					href="${pageContext.request.contextPath}/GetPmemberByMemberIdServlet""
					target="mainFrame"> <span class="fa fa-university fa-lg"></span>
					我的资料
				</a>
				<a class="list-group-item"
					href="${pageContext.request.contextPath}/MyPrepServlet"
					target="mainFrame"> <span class="fa fa-university fa-lg"></span>
					我的订单
				</a>
				
			</div>
		</div>
		<!-- 左侧导航和正文内容的分隔线 -->
		<div class="splitter"></div>
		<!-- 正文导航部分 -->
		<div class="pageContentTitle">
			<ol class="breadcrumb">
				<li><a
					href="${pageContext.request.contextPath}/view/stu/stumainview.jsp">首页</a></li>
				<li><a href="#">目栏</a></li>
			</ol>
		</div>
		<!-- 正文内容部分  -->
		<!-- 欢迎界面 -->
		<div class="pageContent">
			<iframe
				src="${pageContext.request.contextPath}/pages/user/welcome.jsp"
				id="mainFrame" name="mainFrame" frameborder="3"
				style="border-radius: 6px; border-color: #F5F5F5" width="100%"
				height="605" frameBorder="0"> </iframe>
		</div>
	</div>


	<!-- 底部页脚部分 -->

</body>
</html>
