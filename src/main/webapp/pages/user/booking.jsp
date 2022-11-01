<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<title>确认订票信息</title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>BookingServlet" method="post" class="form form-horizontal" id="form-member-add">
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span></label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<h1>  订   票    信    息  </h1>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span></label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
			<h3 style="color: red;">请确认信息是否正确！</h3>
			</div>
		</div>

		<input type="hidden" name="trainId" value="${train.trainId}">
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${pmember.realName}" placeholder="" id="realName" name="realName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${pmember.sex}" placeholder="" id="sex" name="sex">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>年龄：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${pmember.age}" placeholder="" id="age" name="age">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>身份证号码：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${pmember.idCard}" placeholder="" id="idCard" name="idCard">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车次：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.trainNumber}" placeholder="" id="trainNumber" name="trainNumber">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>起始站：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.startStation}" placeholder="" id="startStation" name="startStation">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>终点站：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.endStation}" placeholder="" id="endStation" name="endStation">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>开车时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.startTime}" placeholder="" id="startTime" name="startTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>到站时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.endTime}" placeholder="" id="endTime" name="endTime">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>车票价格：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${train.price}" placeholder="" id="price" name="price">
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;确认&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>


</body>
</html>



