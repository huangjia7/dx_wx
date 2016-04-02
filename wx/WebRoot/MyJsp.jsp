<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta content="yes" name="apple-mobile-web-app-capable">
 <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,user-scalable=no;">  
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
  
  <body>
<div data-role="page">
  <div data-role="header" data-theme="b">
    <h1>欢迎访问我的主页</h1>
  </div>
  <div data-role="content">
      <div data-role="fieldcontain">
        <label for="no" class="ui-hidden-accessible">单号：</label>
        <input type="search" name="no" id="no" placeholder="请您输入单号.." width="30px" value="1000">
      </div>
      <input type="button" data-inline="true" value="提交">
  </div>
</div> 
  </body>
</html>

