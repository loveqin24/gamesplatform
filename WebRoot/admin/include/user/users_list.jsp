<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据查询</title>
<link href="../../images/syscome.files/Admin.css" rel="stylesheet">
<style type="text/css">.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</style>
<script type="text/javascript">
	function $(e) {
		if(new RegExp("^#").test(e)){
		    return document.getElementById(e.substring(1));
		}else{
			return document.getElementsByName(e);
		}
	}
	window.onload = function() {
		$("#checkall").onclick = function() {
			var ids = $("ids");
			for ( var i = 0; i < ids.length; i++) {
				ids[i].checked = $("#checkall").checked;
			}
		};

		$("#deleteall").onclick = function() {
			var count = 0;
			var ids = $("ids");
			for ( var i = 0; i < ids.length; i++) {
				count += (ids[i].checked?1:0);
			}
			if(count <= 0){
				alert("请选择需要删除的数据。");
				return false;
			}
			if(window.confirm("确认要删除选择的数据吗？") == false){
				var ids = $("ids");
				for ( var i = 0; i < ids.length; i++) {
					ids[i].checked = false;
				}
				$("#checkall").checked = false;
				return false;
			}
			document.forms[0].submit();
			return false;
		};
	}
</script>
</head>
<body>

<s:form action="users_deleteAll.action">

  <table width="80%" align="center"  >
	<tbody>
			<tr  bgcolor="#6ab6b6" align="left">
				<th colspan="13" height="24">【用户列表】</th>
			</tr>
			<tr  bgcolor="#6ab6b6">
			<th><input type="checkbox" name="checkall"></input></th>
			<th>用户名</th>
	        <th>密码</th>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>地址</th>
	        <th>电话</th>
	        <th>标签</th>
	        <th>电邮</th>
	        <th>注册时间</th>
	        <th>注册ip地址</th>
	        
			<th></th>
			<th></th>
		</tr>
		<s:iterator value="users" status="st">
		<tr align="center"  bgcolor="#E7FFFF" >
			<td><input type="checkbox" name="ids" value='<s:property value="userId"/>'></input></td>
			<td><s:property value="username"/></td>
            <td><s:property value="password"/></td>
            <td><s:property value="name"/></td>
            <td><s:if test="sex==1">男</s:if><s:else>女</s:else></td>
            <td><s:property value="address"/></td>
            <td><s:property value="phone"/></td>
            <td><s:property value="post"/></td>
            <td><s:property value="email"/></td>
            <td><s:date name="regtime" format="yyyy-MM-dd"/></td>
            <td><s:property value="regipaddress"/></td>
            
			<td><a href='users_delete.action?user.userId=<s:property value="userId"/>'>删除</a></td>
			<td><a href='users_preedit.action?user.userId=<s:property value="userId"/>'>修改</a></td>
		</tr>

	</s:iterator>
	</tbody>
	

    
  </table>

  <table width="80%" align="center" bgcolor="#6ab6b6">
  
	<tr>
	    <td width="30%"><a href="users_preinsert.action">添加</a>
	              &nbsp;<a href="users_deleteAll.action" id="deleteall">批量删除</a>
	    </td>
		<td width="70%">
		<a href='users_list.action?page=${(page-1<=1)?1:(page-1)}'>上一页</a> 
		<s:if test="%{page!=1}">
			<a href="users_list.action?page=1">1</a>
		</s:if><s:else>1</s:else>		
		<c:forEach begin="${(page-6>1)?((page+5<totals)?(page-6):(totals-10)):2}" end="${(page+5>totals)?(totals-1):(page+5+((page-5<0)?(5-page):0))}" var="i">
			<c:if test="${ i!= page}"><a href="users_list.action?page=${i}">${i}</a></c:if>			
			<c:if test="${ i== page}">${i}</c:if>		
		</c:forEach>
		<s:if test="%{page!=totals}">
		<a href='users_list.action?page=${totals}'>${totals}</a>
		</s:if><s:else>${totals}</s:else>
		<a href='users_list.action?page=${(page+1>=totals)?totals:(page+1)}'>下一页</a> 
		</td>
	</tr>
	
  </table>
</s:form>
</body>
</html>
