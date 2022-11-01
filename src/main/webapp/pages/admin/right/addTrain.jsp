<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<title>添加车次</title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>AddTrainServlet" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车次：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="" placeholder="" id="trainNumber" name="trainNumber">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>起始站：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="" placeholder="" id="startStation" name="startStation">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>终点站：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="" placeholder="" id="endStation" name="endStation">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开车时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="datetime-local" class="input-text" value="" placeholder="" id="startTime" name="startTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>到站时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="datetime-local" class="input-text" value="" placeholder="" id="endTime" name="endTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车票价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="" placeholder="" id="price" name="price">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>座位数量：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="" placeholder="" id="seatNumber" name="seatNumber">
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>


<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
