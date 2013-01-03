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
            </div><!-- end of menu tab -->
            
    <div class="crumb_navigation">
    ����:<span class="current">��ҳ>>�ҵĹ��ﳵ</span>
    
    </div>        
    
    
    <div class="left_content">
    <div class="title_box">��Ϸ����</div>
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
     <div class="center_title_bar">�ҵĹ��ﳵ</div>
     <div class="prod_box_big">
     	<div class="top_prod_box_big"></div>
	 	<div class="center_prod_box_big"> 
      <table>
		<s:if test="#session.car.isEmpty">
			<td colspan="5">���ﳵ����û����Ϸ��</td>
		</s:if>
		<s:else>
		<tr>
			<td width="147">��Ϸ���</td>
			<td width="144">��Ϸ����</td>
			<td width="124">��������</td>
			<td width="119">��Ϸ�۸�</td>
			<td width="119">�Ƴ�����Ϸ</td>
		</tr>
		<s:iterator var="com" value="#session.car">
		<tr>
			<td width="147">${com.commodityId}</td>
			<td width="144">${com.commodityName}</td>
			<td width="124">${com.manufacturer}</td>
			<td width="119">${com.fcPrice}</td>
			<td width="119"><a href="deleteFromCar.action?commodityID=${com.commodityId}">�Ƴ�</a></td>
		</tr>
		</s:iterator>
		</s:else>
	  </table>
	  	<div align="right"><a href="orderform_add.action" class="addtocart">���ɶ���</a></div>
	  </div>
	   <div class="bottom_prod_box_big"></div>
     </div>
     </div>
     
   <!-- end of center content -->
   
   <div class="right_content">
				<form action="users_login.action">
					<div class="title_box">�û���¼</div>
					<div class="border_box">
						<table><tr><td align="right" >�û�����</td><td align="left"><table><s:textfield name="user.username" id="username" size="15"></s:textfield></table></td></tr></table>
						
						<table><tr><td align="right">��&nbsp;&nbsp;&nbsp;&nbsp;�룺</td><td align="left"><table><s:textfield name="user.password" id="password" size="15" ></s:textfield></table></td></tr></table>
							
							<input name="�ύ" type="submit" value="��¼" /><input name="����"
								type="reset" value="����" onclick="reset" />
						
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