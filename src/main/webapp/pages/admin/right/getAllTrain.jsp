<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/bootstrap/font-awesome.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>

<title>车次管理</title>
</head>
<body>
<nav class="breadcrumb"><i ></i> 首页
 <span class="c-gray en">&gt;</span> 车次管理 
 <span class="c-gray en">&gt;</span> 车次列表 
 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	
		<span class="l"> <a class="btn btn-primary radius" data-title="添加车次" data-href="<%=basePath%>pages/admin/right/addTrain.jsp" href="<%=basePath%>pages/admin/right/addTrain.jsp"><i class="Hui-iconfont">&#xe600;</i> 添加车次</a></span> 
		<span class="r">此页显示：<strong>${trainList.size()}</strong> 条</span> </div>
	<div class="mt-20">
		 <table class="table table-striped table-hover">
			<thead>
				<tr class="text-c">
					<th width="80">序号</th>
					<th width="80">车次</th>
					<th width="80">起始站</th>
					<th width="80">终点站</th>
					<th width="120">开车时间</th>
					<th width="120">到达时间</th>
					<th width="60">票价</th>
					<th width="60">剩余座位数</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${trainList}" var="allTrain" varStatus="status">
				<tr class="text-c">
					<td>${status.index+1}</td>
					<td>${allTrain.trainNumber}</td>
					<td>${allTrain.startStation}</td>
					<td>${allTrain.endStation}</td>
					<td>${allTrain.startTime}</td>
					<td>${allTrain.endTime}</td>
					<td>${allTrain.price}</td>
					<td>${allTrain.seatNumber}</td>
					<td class="f-14 td-manage">
						 <a class="btn btn-default" href="<%=basePath%>UpdateTrainServlet?trainId=${allTrain.trainId}" title="修改"">修改</a>
                        <a class="btn btn-danger"  href="<%=basePath%>DeleteTrainServlet?trainId=${allTrain.trainId}" title="删除">删除</a>
						</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center">
			 <div class="inline pull-right page">
						<a class="btn btn-secondary-outline  size-MINI radius" href='GetAllTrainServlet?action=list&currentPage=1' >首页</a>

						<a class="btn btn-secondary-outline  size-MINI radius"href='GetAllTrainServlet?action=list&currentPage=${pageTool.lastPage}'>上一页</a>

						<a class="btn btn-secondary-outline  size-MINI radius"href='GetAllTrainServlet?action=list&currentPage=${pageTool.nextPage}'>下一页</a>

						<a class="btn btn-secondary-outline  size-MINI radius" href='GetAllTrainServlet?action=list&currentPage=${pageTool.pageCount}'>尾页</a>

						&nbsp;&nbsp;&nbsp;共<span class='current'> ${pageTool.totalCount } </span>条记录
						<span class='current'> ${pageTool.currentPage }/${pageTool.pageCount } </span>页
					</div>
                </div>

	</div>
</div>
<!--_footer 作为公共模版分离出去-->
</body>
</html>
