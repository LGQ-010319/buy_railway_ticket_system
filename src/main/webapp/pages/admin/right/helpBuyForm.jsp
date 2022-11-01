<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/HelpBuyFormServlet" method="post" class="form form-horizontal" id="form-member-add">
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span></label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
				<h1>帮购信息</h1>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span></label>
			<div class="formControls col-xs-8 col-sm-9" style="width:300px;">
			<h3 style="color: red;">提示：此功能仅可帮会员添加订单，并未完成交易，帮购后请提醒会员在订单出完成付款</h3>
			</div>
		</div>
		
		<input type="text" name="TrainId">请输入火车Id<br>
		<input type="text" name="memberId">请输入会员Id
		<input type="submit">
	</form>
</body>
</html>