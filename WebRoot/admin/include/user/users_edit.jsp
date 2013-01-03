<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息修改</title>
</head>
<body>
<s:form action="users_edit.action">
  <table width="80%" align="center" cellspacing="5" cellpadding="5">
	<tr>
		<td colspan="3" align="center">用户信息修改</td>	
	</tr>
    <tr>
        <td align="right">用户名</td>
        <td align="left">
            <table><s:textfield name="user.username"></s:textfield></table>
        </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    <tr>
        <td align="right">密码</td>
        <td align="left">
            <table><s:textfield name="user.password"></s:textfield></table>
        </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    <tr>
        <td align="right">姓名</td>
        <td align="left">
            <table><s:textfield name="user.name"></s:textfield></table>
       </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    <tr>
        <td align="right">性别</td>
        <td align="left">
            <table><s:textfield name="user.sex"></s:textfield></table>
        </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    <tr>
        <td align="right">地址</td>
        <td align="left">
            <table><s:textfield name="user.address"></s:textfield></table>
       </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    <tr>
        <td align="right">电话</td>
        <td align="left">
            <table><s:textfield name="user.phone"></s:textfield></table>
        </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
       <tr>
        <td align="right">电邮</td>
        <td align="left">
            <table><s:textfield name="user.email"></s:textfield></table>
        </td><td style="font: italic;color: red" align="left">*</td>
    </tr>
    
	<tr>	
		<td width="30%"><s:hidden name="user.userId"/></td>
		<td width="50%"><input type="submit" value="确定"/> <a href="users_list.action">返回</a></td>
		<td width="20%"></td>
	</tr>
  </table>
</s:form>
</body>
</html>
