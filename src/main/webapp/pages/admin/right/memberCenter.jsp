<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath}/bootstrap/font-awesome.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
<title>会员列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 会员中心 <span class="c-gray en">&gt;</span> 会员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a class="btn btn-primary radius" data-title="添加车次" data-href="<%=basePath%>pages/admin/right/addMember.jsp" href="<%=basePath%>pages/admin/right/addMember.jsp"><i class="Hui-iconfont">&#xe600;</i> 添加会员</a></span> 
		<span class="r">共有数据：<strong>${memberList.size()}</strong> 条</span> </div>
	<div class="mt-20">
		 <table class="table table-striped table-hover">
			<thead>
				<tr class="text-c">
					<th width="40">序号</th>
					<th width="60">会员ID</th>
					<th width="120">用户名</th>
					<th width="120">密码</th>
					<th width="80">个人信息</th>
					<th width="40">会员状态</th>
					<th width="120">注册时间</th>
					<th width="120">登录时间</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList}" var="member" varStatus="status">
				<tr class="text-c">
					<td>${status.index+1}</td>
					<td>${member.memberId}</td>
					<td>${member.userName}</td>
					<td>${member.password}</td>
					<td>
						<a href="<%=basePath%>GetPmemberByMemberIdServlet?temp=admin&memberId=${member.memberId}">
							<%-- <img alt="" src="<%=basePath%>images/look.jpg"> --%>
							点击查看
						</a>
					</td>
					
					<c:if test="${member.ifUse == 1}">
						<td style="color:green">在线</td>
					</c:if>
					<c:if test="${member.ifUse == 0}">
						<td>离线</td>
					</c:if>
					<td>
						<fmt:formatDate value="${member.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<fmt:formatDate value="${member.logintimes}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td class="f-14 td-manage">
					 	<a class="btn btn-default" href="<%=basePath%>UpdateMemberAdminServlet?memberId=${member.memberId}" title="修改"">修改</a>
                        <a class="btn btn-danger"  href="<%=basePath%>DeleteMemberAdminServlet?memberId=${member.memberId}" title="删除">删除</a>
					
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>


