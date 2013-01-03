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
    导航: <span class="current">首页>>${commodityClass.commodityClassName}</span>
    
    </div>        
    
    
    <div class="left_content">
    <div class="title_box">游戏分类</div>
        <ul class="left_menu">
        <s:iterator value="commodityClasses" var="comClass" status="stu">
        	<s:if test="#stu.odd">
        		<li class="odd">
        			<a href="showByClass.action?commodityClassID=${comClass.commodityClassId}">
        				${comClass.commodityClassName}
        			</a>
        		</li>
        	</s:if>
        	<s:else>
        		<li class="even">
        			<a href="showByClass.action?commodityClassID=${comClass.commodityClassId}">
        				${comClass.commodityClassName}
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
   	<div class="center_title_bar">${commodityClass.commodityClassName}</div>
    	<s:iterator value="commodities" var="commodity">
    		<div class="prod_box">
	        	<div class="top_prod_box"></div>
	            <div class="center_prod_box">            
	                 <div class="product_title"><a href="showCommodity.action?commodityID=${commodity.commodityId}">${commodity.commodityName}</a></div>
	                 <div class="product_img"><a href="showCommodity.action?commodityID=${commodity.commodityId}"><img src="showImg.action?commodityID=${commodity.commodityId}" alt="" title="" border="0" /></a></div>
	                 <div class="prod_price"><span class="reduce">${commodity.commodityPrice}</span> <span class="price">${commodity.fcPrice}</span></div>                        
	            </div>
	            <div class="bottom_prod_box"></div>             
	            <div class="prod_details_tab">
	            <a href="addToCar.action?commodityID=${commodity.commodityId}" title="header=[添加到购物车] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" title="" border="0" class="left_bt" /></a>          
	            <a href="showCommodity.action?commodityID=${commodity.commodityId}" class="prod_details">详细</a></div>                     
	        </div>
    	</s:iterator>
   </div><!-- end of center content -->
   
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
