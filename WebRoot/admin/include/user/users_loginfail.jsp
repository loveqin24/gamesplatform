<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��Ϸ��Ӫƽ̨ϵͳ</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
<script type="text/javascript">
	function reset() {
		document.getElementById("username").value = "";
		document.getElementById("password").value = "";
	}
</script>
</head>
<body>

	<div id="main_container">
		<div class="top_bar"></div>
		<div id="header">
			<!-- end of oferte_content-->
		</div>

		<div id="main_content">

			<div id="menu_tab">
				<div class="left_menu_corner"></div>
				<ul class="menu">
					<li><a href="goIndex.action" class="nav1">��ҳ</a></li>
                         <li class="divider"></li>
<!--                          <li><a href="#" class="nav2">���߹���</a></li> -->
<!--                          <li class="divider"></li> -->
                         <li><a href="orderform_showcar.action" class="nav5">�ҵĹ��ﳵ</a></li>
                         <li class="divider"></li>
                         <li><a href="users_show.action" class="nav4">�û���Ϣ</a></li>
                         <li class="divider"></li>
                         <li><a href="users_prelogin.action" class="nav3">�û���¼</a></li>
                         <li class="divider"></li>                         
                         <li><a href="users_register.action" class="nav6">�û�ע�� </a></li>
                         <li class="divider"></li>
                         <li></li>
                         <li class="divider"></li>
				</ul>

				<div class="right_menu_corner"></div>
			</div>
			<!-- end of menu tab -->

			<div class="crumb_navigation">
				����: <span class="current">����</span>

			</div>


			<div class="left_content"></div>
			<!-- end of left content -->


			<div class="center_content">
				 Login in Fail! 
			</div>
			<!-- end of center content -->

			<div class="right_content">
				
			</div>
			<!-- end of right content -->


		</div>
		<!-- end of main content -->



		<div class="footer"></div>


	</div>
	<!-- end of main_container -->
</body>
</html>

 