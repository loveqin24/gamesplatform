<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单修改</title>
</head>
<body>
<s:form action="orderform_edit.action">
  <table width="80%" align="center" cellspacing="5" cellpadding="5">
	<tr>
		<td colspan="3" align="center">订单修改</td>	
	</tr>
    <tr>
        <td align="right">订单号</td>
        <td align="left">
            <table><s:textfield name="orderform.orderFormNo"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">用户系统编号</td>
        <td align="left">
            <table><s:textfield name="orderform.userId"></s:textfield></table>
        </td>    
    </tr>
    <tr>
        <td align="right">提交时间</td>
        <td align="left">
            <table><s:textfield name="orderform.submitTime"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">运送时间</td>
        <td align="left">
            <table><s:textfield name="orderform.consignmentTime"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">总价</td>
        <td align="left">
            <table><s:textfield name="orderform.totalPrice"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">评论</td>
        <td align="left">
           <table> <s:textfield name="orderform.remark"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">ip地址</td>
        <td align="left">
           <table> <s:textfield name="orderform.ipaddress"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">是否支付</td>
        <td align="left">
            <table><s:textfield name="orderform.isPayoff"></s:textfield></table>
        </td>
    </tr>
    <tr>
        <td align="right">是否运送</td>
        <td align="left">
            <table><s:textfield name="orderform.isConsignment"></s:textfield></table>
        </td>
    </tr>

	<tr>	
		<td width="30%"><s:hidden name="orderform.orderFormId"/></td>
		<td width="50%"><input type="submit" value="确定"/> <a href="orderform_list.action">返回</a></td>
		<td width="20%"></td>
	</tr>
  </table>
</s:form>
</body>
</html>
