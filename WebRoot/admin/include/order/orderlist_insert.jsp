<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据添加</title>
</head>
<body>
<s:form action="orderlist_insert.action">
  <table width="80%" align="center" cellspacing="5" cellpadding="5">
	<tr>
		<td colspan="3" align="center">数据添加</td>	
	</tr>
    <tr>
        <td align="right">orderFormID</td>
        <td align="left">
            <s:select name="orderlist.orderform.orderformid" list="orderforms" 
                listKey="orderformid" listValue="orderformid"/>
        </td>
        <td align="left"></td>    </tr>
    <tr>
        <td align="right">commodityID</td>
        <td align="left">
            <s:select name="orderlist.commodity.commodityid" list="commoditys" 
                listKey="commodityid" listValue="commodityid"/>
        </td>
        <td align="left"></td>    </tr>
    <tr>
        <td align="right">amount</td>
        <td align="left">
            <s:textfield name="orderlist.amount"></s:textfield>
        </td>
        <td align="left"><s:fielderror fieldName="orderlist.amount"/></td>
    </tr>

	<tr>	
		<td width="30%"></td>
		<td width="50%"><input type="submit" value="确定"/> <a href="orderlist_list.action">返回</a></td>
		<td width="20%"></td>
	</tr>
  </table>
</s:form>
</body>
</html>
