<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			

request.setCharacterEncoding("utf-8");
%>
<%@ page import="entity.Users"%>
<%@ page import="dao.ProductDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>添加评论</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css">


<!-- Custom Fonts -->
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="fonts/font-slider.css" type="text/css">

<!-- jQuery and Modernizr-->
<script src="js/jquery-2.1.1.js"></script>

<!-- Core JavaScript Files -->
<script src="js/bootstrap.min.js"></script>

<!-- 评价等级实现点击星星第几颗，星星就会亮几颗的功能还没实现 -->

</head>
<body>
		<nav id="top">
		<div class="container">
			<div class="row">
			
				<div class="col-xs-6">
					<div class="col-xs-6">
						<ul class="top-link">
							<li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> 趣玩乐器网上商城</a></li>
						</ul>
					</div>
				</div>
				
				<div class="col-xs-6">
					<ul class="top-link">
						<%
							if(session.getAttribute("isLogin")==null){
					 %>
						<li><a href="account.jsp"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
						<%
							}else{
						 %>
						<li><a href="personal_centre.jsp"><span class="glyphicon glyphicon-user"></span> <%=session.getAttribute("user_account") %></a></li>
						<li><a href="servlet/LogoutDealServlet"><span class="glyphicon glyphicon-off"></span> 注销</a></li>
						<%
							}
						 %>
						<li><a href="contact.jsp"><span class="glyphicon glyphicon-envelope"></span> 联系我们</a></li>
					</ul>
				</div>
				
			</div>
	</nav>
	<!--Header-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<div id="logo">
					<img src="images/logo.png" />
				</div>
			</div>
			<div class="col-md-4">
				<form class="form-search">
					<input type="text" class="input-medium search-query">
					<button type="submit" class="btn">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
			</div>
			<div class="col-md-4">
				<div id="cart">
					<a class="btn btn-1" href="cart.html"><span
						class="glyphicon glyphicon-shopping-cart"></span>购物车 </a>
				</div>
			</div>
		</div>
	</header>

	<!-- <li class="active"><a href="#1" data-toggle="tab">我要评价</a></li>
<label class="col-sm-2">商品评价等级：</label>
				    		<div class="col-sm-6" id="name">
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)" ></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    		</div>
	<label class="col-sm-2"></label>
							<div class="col-sm-6 text-left">
				    			<button>发表评价</button>	
				    		</div> -->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#1" data-toggle="tab">我要评价</a>
						</li>
					</ul>
					<%
						ProductDao dao = new ProductDao();
						Users user = (Users)request.getSession().getAttribute("user");
						session.setAttribute("user_name",user.getUserName());
						System.out.println("request.getParameter" + request.getParameter("product_name"));
						session.setAttribute("product_name",request.getParameter("product_name"));
					//session.setAttribute("user_name","钟志坚");
					//session.setAttribute("product_name","TAKAMINE D5D 单板民谣吉他");
					%>
					<div class="tab-content">
						<div class="tab-pane active" id="1">
							<form class="form-horizontal" action="servlet/CommentServlet" method="post">
								<div class="form-group">
									<label class="col-sm-2 ">商品评价等级：</label>
									<div class="col-sm-6" id="name">
										<input name="comment_degree" id="gender" type="radio" value="1">
										1分<input name="comment_degree" id="gender" type="radio" value="2">
										2分 <input name="comment_degree" id="gender" type="radio" value="3">
										3分 <input name="comment_degree" id="gender" type="radio" value="4">
										4分 <input name="comment_degree" id="gender" type="radio" value= "5">
										5分
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 ">心得:</label>
									<div class="col-sm-20">
										<textarea name="comment_content"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 "></label>
									<div class="col-sm-2">

										 <button onclick="javascript:alert('评论成功')"type="submit" class="btn" value="发表评价">发表评价</button>

									</div>
								</div>
							</form>
						</div>



					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- <div  class="container">
		<div class="tabbable">
			<ul class="nav nav-tabs">   
			  	<li class="active"><a href="#1" data-toggle="tab">我要评价</a></li> 
			</ul>  
			<div class="tab-content">    
				<div class="tab-pane active" id="1">      
					<form class="form-horizontal" action="#">
						<div class="form-group">
							<label class="col-sm-2">商品评价等级：</label>
				    		<div class="col-sm-6" id="name">
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)" ></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    			<span class="glyphicon glyphicon-star" name="level" onclick="level(this)"></span>
				    		</div>
				    	</div>
				    	<div class="form-group">
							<label class="col-sm-2">心得：</label>
							<div class="col-sm-6 ">
				    		
				    			<textarea class="form-control "></textarea>
				    		
				    		</div>
				    	</div>
				    	
				    	<div class="form-group">
							<label class="col-sm-2"></label>
							<div class="col-sm-6 text-left">
				    			<button>发表评价</button>	
				    		</div>
				    	</div>
		   			 </form>    
				</div>    
			</div>
		</div>
	</div> -->
	<footer>
		<div class="container">
			<div class="wrap-footer">
				<div class="row">
					<div class="col-md-3 col-footer footer-1">
						<img src="images/logofooter.png" />
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry.Lorem Ipsum is simply dummy text of the
							printing and typesetting industry.</p>
					</div>
					<div class="col-md-3 col-footer footer-2">
						<div class="heading">
							<h4>用户服务</h4>
						</div>
						<ul>
							<li><a href="#">关于我们</a>
							</li>
							<li><a href="#">物流信息</a>
							</li>
							<li><a href="#">隐私策略</a>
							</li>
							<li><a href="#">购物须知</a>
							</li>
							<li><a href="#">联系我们</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-3">
						<div class="heading">
							<h4>我的账户</h4>
						</div>
						<ul>
							<li><a href="#">我的账户</a>
							</li>
							<li><a href="#">品牌</a>
							</li>
							<li><a href="#">优惠卷</a>
							</li>
							<li><a href="#">特价</a>
							</li>
							<li><a href="#">网站导航</a>
							</li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-4">
						<div class="heading">
							<h4>联系我们</h4>
						</div>
						<ul>
							<li><span class="glyphicon glyphicon-home"></span>仲恺农业工程学院</li>
							<li><span class="glyphicon glyphicon-earphone"></span>+86
								8866888111</li>
							<li><span class="glyphicon glyphicon-envelope"></span>infor@yoursite.com</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						Copyright &copy; 2015.Company name All rights reserved.<a
							target="_blank" href="#">&#x8da3;&#x73a9;&#x4e50;&#x5668;&#x7f51;&#x4e0a;&#x5546;&#x57ce;</a>
					</div>
					<div class="col-md-6">
						<div class="pull-right">
							<ul>
								<li><img src="images/visa-curved-32px.png" />
								</li>
								<li><img src="images/paypal-curved-32px.png" />
								</li>
								<li><img src="images/discover-curved-32px.png" />
								</li>
								<li><img src="images/maestro-curved-32px.png" />
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
