<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>游戏运营平台系统</title>
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
                         <li><a href="goIndex.action" class="nav1">首页</a></li>
                         <li class="divider"></li>
<!--                          <li><a href="#" class="nav2">在线购物</a></li> -->
<!--                          <li class="divider"></li> -->
                         <li><a href="orderform_showcar.action" class="nav5">我的购物车</a></li>
                         <li class="divider"></li>
                         <li><a href="users_show.action" class="nav4">用户信息</a></li>
                         <li class="divider"></li>
                         <li><a href="users_prelogin.action" class="nav3">用户登录</a></li>
                         <li class="divider"></li>                         
                         <li><a href="users_register.action" class="nav6">用户注册 </a></li>
                         <li class="divider"></li>
                         <li></li>
                         <li class="divider"></li>
                    </ul>

             <div class="right_menu_corner"></div>
            </div><!-- end of menu tab -->
            
    <div class="crumb_navigation">
    导航:<span class="current">首页>>我的购物车</span>
    
    </div>        
    
    
    <div class="left_content">
    <div class="title_box">游戏分类</div>
        <ul class="left_menu">
       <s:iterator value="commodityClasses" var="commodityClass" status="stu">
        	<s:if test="#stu.odd">
        		<li class="odd">
        			<a href="showByClass.action?commodityClassID=${commodityClass.commodityClassId}">
        				${commodityClass.commodityClassName}
        			</a>
        		</li>
        	</s:if>
        	<s:else>
        		<li class="even">
        			<a href="showByClass.action?commodityClassID=${commodityClass.commodityClassId}">
        				${commodityClass.commodityClassName}
        			</a>
        		</li>
        	</s:else>	
        </s:iterator>
         <li class="odd"></li>
        </ul> 
     <div class="banner_adds">
     
     <a href="#"></a>     </div>    
   </div><!-- end of left content -->
   
     <div class="center_content">
     <div class="center_title_bar">我的购物车</div>
     <div class="prod_box_big">
     	<div class="top_prod_box_big"></div>
	 	<div class="center_prod_box_big"> 
      <table>
		<s:if test="#session.car.isEmpty">
			<td colspan="5">购物车里面没有游戏！</td>
		</s:if>
		<s:else>
		<tr>
			<td width="147">游戏编号</td>
			<td width="144">游戏名称</td>
			<td width="124">生产厂商</td>
			<td width="119">游戏价格</td>
			<td width="119">移除该游戏</td>
		</tr>
		<s:iterator var="com" value="#session.car">
		<tr>
			<td width="147">${com.commodityId}</td>
			<td width="144">${com.commodityName}</td>
			<td width="124">${com.manufacturer}</td>
			<td width="119">${com.fcPrice}</td>
			<td width="119"><a href="deleteFromCar.action?commodityID=${com.commodityId}">移除</a></td>
		</tr>
		</s:iterator>
		</s:else>
	  </table>
	  	<div align="right"><a href="orderform_add.action" class="addtocart">生成订单</a></div>
	  </div>
	   <div class="bottom_prod_box_big"></div>
     </div>
     </div>
     
   <!-- end of center content -->
   
   <div class="right_content">
				<form action="users_login.action">
					<div class="title_box">用户登录</div>
					<div class="border_box">
						<table><tr><td align="right" >用户名：</td><td align="left"><table><s:textfield name="user.username" id="username" size="15"></s:textfield></table></td></tr></table>
						
						<table><tr><td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td align="left"><table><s:textfield name="user.password" id="password" size="15" ></s:textfield></table></td></tr></table>
							
							<input name="提交" type="submit" value="登录" /><input name="重置"
								type="reset" value="重置" onclick="reset" />
						
					</div>
				</form>
			</div>
   
        <div class="border_box"></div>
   </div>
   <!-- end of right content -->   
   
            
   </div><!-- end of main content -->
   
   
   
  <div class="footer"></div>                 


</div>
<!-- end of main_container -->
</body>
</html>