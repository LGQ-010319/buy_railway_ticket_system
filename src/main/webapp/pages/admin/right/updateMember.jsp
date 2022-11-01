<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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




<title>修改会员</title>
</head>
<body>
<article class="page-container">
	<form action="<%=basePath%>UpdateMemberAdminServlet" method="post" class="form form-horizontal" id="form-member-add">

		<input type="hidden" name="memberId" value="${member.memberId}">
	
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>会员ID：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${member.memberId}" placeholder="" id="" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="${member.userName}" placeholder="" id="userName" name="userName">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" class="input-text" value="${member.password}" placeholder="" id="password" name="password">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>会员状态：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<c:if test="${member.ifUse == 1}">
					<input type="text" disabled="disabled" class="input-text" value="在线" placeholder="" id="" name="">
				</c:if>
				<c:if test="${member.ifUse == 0}">
					<input type="text" disabled="disabled" class="input-text" value="离线" placeholder="" id="" name="">
				</c:if>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>注册时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				
				<input type="text" disabled="disabled" class="input-text" value="${member.registerTime}" placeholder="" id="" name="">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>登录时间：</label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<input type="text" disabled="disabled" class="input-text" value="${member.logintimes}" placeholder="" id="" name="">
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>


</body>
</html>

