<%@page import="entity.Product"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Users"%>
<%@ page import="entity.Product"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">

<title>商品管理</title>

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<%
		Users user = (Users) session.getAttribute("user");
	%>
	<!--Top-->
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<!--		<select class="language">
						<option value="English" selected>English</option>
						<option value="France">France</option>
						<option value="Germany">Germany</option>
					</select>
					<select class="currency">
						<option value="USD" selected>USD</option>
						<option value="EUR">EUR</option>
						<option value="DDD">DDD</option>
			-->
					</select>
				</div>
				<div class="col-xs-6">
					<ul class="top-link">
						<%
							if (session.getAttribute("isLogin") == null) {
						%>
						<li><a href="account.jsp"><span
								class="glyphicon glyphicon-user"></span> 登录</a></li>
						<%
							} else {
						%>
						<li><a href="personal_centre.jsp"><span
								class="glyphicon glyphicon-user"></span> <%=session.getAttribute("user_account")%></a>
						</li>
						<li><a href="servlet/LogoutDealServlet"><span
								class="glyphicon glyphicon-off"></span> 注销</a></li>
						<%
							}
						%>
						<li><a href="contact.jsp"><span
								class="glyphicon glyphicon-envelope"></span> 联系我们</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!--Header-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<a href="index.jsp"><div id="logo">
						<img src="images/logo.png" />
					</div> </a>
			</div>

		</div>
	</header>

	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="productmanager.jsp">首页</a></li>
						<li><a href="adminproduct.jsp">商品管理</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="heading">
						<h1>添加&编辑商品</h1>
					</div>
				</div>
				<%
					if (session.getAttribute("update") != null) {
						Product pd = (Product) session.getAttribute("update");
				%>
				<form action="servlet/AdminProductChargeServlet" method="post">
					<div class="col-md-6" style="margin-bottom: 30px;">
						<table>
							<tr>

								<td><h5>名称：</h5></td>
								<td><input type="text" name="product_name" value="<%=pd.getProduct_name()%>">
								</td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>

								<td><h5>价格：</h5></td>
								<td><input type="text" name="product_price" value="<%=pd.getProduct_price()%>"></td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>

							<tr>
								<td><h5>
										颜色:
										<h5 />
								</td>

								<td><input type="text" name="product_color" value="<%=pd.getProduct_color()%>"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										尺寸:
										<h5 />
								</td>

								<td><input type="text" name="product_size" value="<%=pd.getProduct_size()%>"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>商品信息：</h5></td>
								<td><input type="text" name="product_information" value="<%=pd.getProduct_infomation()%>">
								</td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>


							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>

						</table>
					</div>
					<div class="col-md-6" style="margin-bottom: 30px;">
						<table>
							<tr>

								<td><h5>分类：</h5></td>
								<td><input type="text" name="product_type" value="<%=pd.getProduct_type()%>"></td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>

								<td><h5>销量：</h5></td>
								<td><input type="text" name="product_sale_count" value="<%=pd.getProduct_sale_count()%>">
								</td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										图片:
										<h5 />
								</td>

								<td><input type="text" name="product_image" value="<%=pd.getProduct_image()%>"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										介绍:
										<h5 />
								</td>

								<td><input type="text" name="product_introduction" value="<%=pd.getProduct_introdution()%>">
								</td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>适用者层次：</h5></td>
								<td><input type="text" name="product_level" value="<%=pd.getProduct_level()%>"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
						</table>
						<button type="submit" name="change_phone" id="change_phone"
							class="btn btn-2">&nbsp&nbsp&nbsp&nbsp提交&nbsp&nbsp&nbsp&nbsp</button>
						<input type="hidden" name="action" value="add">
					</div>
				</form>
				<%
					session.removeAttribute("update");} else {
				%>
				<form action="servlet/AdminProductChargeServlet" method="post">
					<div class="col-md-6" style="margin-bottom: 30px;">
						<table>
							<tr>

								<td><h5>名称：</h5></td>
								<td><input type="text" name="product_name">
								</td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>

								<td><h5>价格：</h5></td>
								<td><input type="text" name="product_price"></td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>

							<tr>
								<td><h5>
										颜色:
										<h5 />
								</td>

								<td><input type="text" name="product_color"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										尺寸:
										<h5 />
								</td>

								<td><input type="text" name="product_size"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>商品信息：</h5></td>
								<td><input type="text" name="product_information">
								</td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>


							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>

						</table>
					</div>
					<div class="col-md-6" style="margin-bottom: 30px;">
						<table>
							<tr>

								<td><h5>分类：</h5></td>
								<td><input type="text" name="product_type"></td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>

								<td><h5>销量：</h5></td>
								<td><input type="text" name="product_sale_count">
								</td>

							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										图片:
										<h5 />
								</td>

								<td><input type="text" name="product_image"></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>
										介绍:
										<h5 />
								</td>

								<td><input type="text" name="product_introduction">
								</td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
							<tr>
								<td><h5>适用者层次：</h5></td>
								<td><input type="text" name="product_level"=></td>
							</tr>
							<tr>
								<td><h5>&nbsp</h5></td>
							</tr>
						</table>
						<button type="submit" name="change_phone" id="change_phone"
							class="btn btn-2">&nbsp&nbsp&nbsp&nbsp提交&nbsp&nbsp&nbsp&nbsp</button>
						<input type="hidden" name="action" value="add">
					</div>
				</form>
				<%
					}
				%>
				<div class="heading">
					<h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp.</h1>
				</div>
			</div>
		</div>
	</div>
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
							<li><a href="#">关于我们</a></li>
							<li><a href="#">物流信息</a></li>
							<li><a href="#">隐私策略</a></li>
							<li><a href="#">购物须知</a></li>
							<li><a href="#">联系我们</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-3">
						<div class="heading">
							<h4>我的账户</h4>
						</div>
						<ul>
							<li><a href="#">我的账户</a></li>
							<li><a href="#">品牌</a></li>
							<li><a href="#">优惠卷</a></li>
							<li><a href="#">特价</a></li>
							<li><a href="#">网站导航</a></li>
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
							target="_blank" href="#"">&#x8da3;&#x73a9;&#x4e50;&#x5668;&#x7f51;&#x4e0a;&#x5546;&#x57ce;</a>
					</div>
					<div class="col-md-6">
						<div class="pull-right">
							<ul>
								<li><img src="images/visa-curved-32px.png" /></li>
								<li><img src="images/paypal-curved-32px.png" /></li>
								<li><img src="images/discover-curved-32px.png" /></li>
								<li><img src="images/maestro-curved-32px.png" /></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>
