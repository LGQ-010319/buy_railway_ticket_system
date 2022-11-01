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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>根据起点站、终点站、出发时间查询展示车次信息</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/bootstrap/font-awesome.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/bootstrap/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
	
</head>
<body>
	<br/><br/>
	<form action="<%=basePath%>HelpBuyServlet" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		起始站:&nbsp;&nbsp;
		<select name="startStation">
			<c:forEach items="${startStationList}" var="train">
				<option value="${train.startStation}">${train.startStation}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		终点站:&nbsp;&nbsp;
		<select name="endStation">
			<c:forEach items="${endStationList}" var="train">
				<option value="${train.endStation}">${train.endStation}</option>
			</c:forEach>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		开车时间:&nbsp;&nbsp;
		<input type="date" id="startTime" id="startTime" name="startTime" min=""/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="sumbit-button" type="submit" value="查询">
	</form>
	
	<br/>
	<div class="page-container">
	<div class="mt-20">
		 <table class="table table-striped table-hover">
			<thead>
				<tr class="text-c">
					<th width="40">序号</th>
					<th width="80">车次</th>
					<th width="80">起始站</th>
					<th width="80">终点站</th>
					<th width="120">开车时间</th>
					<th width="120">到站时间</th>
					<th width="60">票价/元</th>
					<th width="60">剩余座位数</th>
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${trainList}" var="allTrain" varStatus="status">
			<tr  class="text-c">
				<td>${status.index+1}</td>
				<td>${allTrain.trainNumber}</td>
				<td>${allTrain.startStation}</td>
				<td>${allTrain.endStation}</td>
				<td>${allTrain.startTime}</td>
				<td>${allTrain.endTime}</td>
				<td>${allTrain.price}</td>
				<td>${allTrain.seatNumber}</td>
				<td><a href="${pageContext.request.contextPath}/pages/admin/right/helpBuyForm.jsp">帮购</a></td>
			</tr>
			</c:forEach>
			
			</tbody>
		</table>
		
		<tr>
				<td><a>上一页</a></td>/
				<td><a>下一页</a></td>/
				<td>共</td>
		</tr>
	</div>
	</div>
	
</body>
</html>