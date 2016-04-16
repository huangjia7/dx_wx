<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/include.jsp" %>
<html>
<head>
<meta content="yes" name="apple-mobile-web-app-capable">
 <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,user-scalable=no;">  
    <title>成功</title>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/weui.min.css"/>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/example.css"/>
	<script src="<%=basePath%>/jquery/jquery.js"></script>
</head>
  
  <body>
<div class="weui_msg">
    <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i></div>
    <div class="weui_text_area">
        <h2 class="weui_msg_title">操作成功</h2>
    </div>
    <div class="weui_opr_area">
        <p class="weui_btn_area">
            <a href="javascript:;" class="weui_btn weui_btn_primary">确定</a>
        </p>
    </div>
</div>
  </body>
</html>

