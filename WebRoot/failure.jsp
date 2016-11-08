<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<!-- Page title -->
<title>评论失败</title>
<!-- End of Page title -->
<!-- Libraries -->
<link type="text/css" href="css/comment.css" rel="stylesheet" />
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/easyTooltip.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<!-- End of Libraries -->
</head>
<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="images/cooment.png" alt="" />
			</a>
		</div>
		<div id="box">
			<%=request.getAttribute("fail")%>失败，请重试！<br>
			<%
				if (request.getAttribute("fail").equals("添加评论"))
			%>
			<a href="comment.jsp">返回</a>
			<%
				if (request.getAttribute("fail").equals("申请服务"))
			%>
			<a href="salelater.jsp">返回</a>
		</div>
	</div>
</body>
</html>