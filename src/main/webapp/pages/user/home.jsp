<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>首页</title>
	
</head>
	 	<a class="list-group-item"
					href="${pageContext.request.contextPath}/MyPrepServlet"
					target="mainFrame"> <span class="fa fa-university fa-lg"></span>
					我的订单
				</a>
		</header>
	    <iframe name="my_iframe" id="my_iframe" src="<%=basePath%>GetByStartEndStationServlet" width="100%" height="800px" seamless="seamless"></iframe>
	    <!-- 首页顶部导航栏end  -->
	    
	    

</html>