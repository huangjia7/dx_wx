<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/include.jsp" %>
<html>
  <head>
<meta content="yes" name="apple-mobile-web-app-capable">
 <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,user-scalable=no;">
    <title>委托单查询</title>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/weui.min.css"/>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/example.css"/>
	<script src="jquery/jquery.js"></script>
  </head>
  <body>
    <div class="hd">
        <h1 class="page_title">委托单查询</h1>
    </div>  
        <!-- <div class="weui_cells_title">可以添加说明文字</div> -->
        <form id="myform" name="myform" method="post">
        <div class="weui_cells weui_cells_form">
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">单号</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入单号.." onfocus="removeWarn('no')"/>
                </div>
                <div id="no_div_warn" class="weui_cell_ft" style="display:none;">
                    <i class="weui_icon_warn"></i>
                </div>                
            </div>          
        </div>
        
        <!-- <div class="weui_cells_tips">可以添加说明文字</div> -->
        <div id="result" class="weui_btn_area" style="display:none;">
        </div>
        </form>
        <a class="weui_btn weui_btn_primary" href="#" id="query">查询</a>               
  </body>
    
<script type="text/javascript">
$("#query").click(function(){  
  var $no = $('#no').val();
  if($no ==''|| $no.length==0){
        //$("#no").val("单号不能为空");
        $("#no_div").addClass("weui_cell_warn");
        $("#no_div_warn").show();
        return;
  }
  
  var $loadingToast = $('#loadingToast');
  $loadingToast.show();  
  
   var form = $("#myform");
   $.post("<%=request.getContextPath()%>/common/getOrderState.do",form.serialize(), function (dataobj) {
             $loadingToast.hide();
             //alert(dataobj.state); 
             $('#result').show();
             $('#result').html('<b style ="font-size:200%;color:red">'+dataobj.state+'</b>');
     }, "json");  
});
 </script>    
</html>