<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/include.jsp" %>
<html>
  <head>
    <title>微信订单列表</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="stylesheet" href="<%=basePath%>jquery/jquerymobile/css/themes/default/jquery.mobile-1.4.5.min.css"/>
	<script src="<%=basePath%>jquery/jquerymobile/js/jquery.min.js"></script>
	<script src="<%=basePath%>jquery/jquerymobile/js/jquery.mobile-1.4.5.min.js"></script>
	<style>
	th {
	    border-bottom: 1px solid #d6d6d6;
	}
	
	tr:nth-child(even) {
	    background: #e9e9e9;
	}
	</style>	
	
	
  </head>
  <body>     
<div data-role="page" id="pageone">
  <div data-role="header">
    <h1>微信订单列表</h1>
  </div>
  
  <div data-role="main" class="ui-content">
    <table data-role="table" data-mode="columntoggle" class="ui-responsive ui-shadow" id="myTable">
      <thead>
        <tr>
          <th data-priority="1">姓名</th>
          <th data-priority="2">电话</th>
          <th data-priority="3">站点</th>
          <th data-priority="4">下单时间</th>
          <th data-priority="5">地址</th>
          <th data-priority="6">备注</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach var='Orders' items='${orderlist}'>
	        <tr>
	          <td><c:out value="${Orders.name}"/></td>
	          <td><c:out value="${Orders.tel}"/></td>
	          <td><c:out value="${Orders.sitename}"/></td>
	          <td><c:out value="${Orders.createdate}"/></td>
	          <td><c:out value="${Orders.addr}"/></td>
	          <td><c:out value="${Orders.note}"/></td>
	        </tr>  
		</c:forEach>     
      </tbody>
    </table>
  </div>
</div> 

  </body> 
</html>