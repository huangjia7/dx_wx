<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta content="yes" name="apple-mobile-web-app-capable">
 <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,user-scalable=no;">
    <title>委托单查询</title>
	<link rel="stylesheet" href="weui/style/weui.min.css"/>
	<link rel="stylesheet" href="weui/style/example.css"/>
	<script src="jquery/jquery.js"></script>
  </head>
  
  <body>
    <div class="hd">
        <h1 class="page_title">委托单查询</h1>
    </div>  
        <!-- <div class="weui_cells_title">可以添加说明文字</div> -->
        <div class="weui_cells weui_cells_form">
            <form id="myform" name="myform" method="post">
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">单号</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入单号.."/>
                </div>
            </div>
            </form>         
        </div>
        <!-- <div class="weui_cells_tips">可以添加说明文字</div> -->
        <div id="result" class="weui_btn_area" style="display:none;">
        </div>
        <a class="weui_btn weui_btn_primary" href="#" id="query">查询</a>
        
    <div id="loadingToast" class="weui_loading_toast" style="display:none;">
        <div class="weui_mask_transparent"></div>
        <div class="weui_toast">
            <div class="weui_loading">
                <div class="weui_loading_leaf weui_loading_leaf_0"></div>
                <div class="weui_loading_leaf weui_loading_leaf_1"></div>
                <div class="weui_loading_leaf weui_loading_leaf_2"></div>
                <div class="weui_loading_leaf weui_loading_leaf_3"></div>
                <div class="weui_loading_leaf weui_loading_leaf_4"></div>
                <div class="weui_loading_leaf weui_loading_leaf_5"></div>
                <div class="weui_loading_leaf weui_loading_leaf_6"></div>
                <div class="weui_loading_leaf weui_loading_leaf_7"></div>
                <div class="weui_loading_leaf weui_loading_leaf_8"></div>
                <div class="weui_loading_leaf weui_loading_leaf_9"></div>
                <div class="weui_loading_leaf weui_loading_leaf_10"></div>
                <div class="weui_loading_leaf weui_loading_leaf_11"></div>
            </div>
            <p class="weui_toast_content">数据加载中</p>
        </div>
    </div> 
    
    <div class="weui_dialog_alert" id="dialog2" style="display: none;">
        <div class="weui_mask"></div>
        <div class="weui_dialog">
            <div class="weui_dialog_hd"><strong class="weui_dialog_title">单号不能为空</strong></div>
            <div class="weui_dialog_ft">
                <a href="javascript:;" class="weui_btn_dialog primary">确定</a>
            </div>
        </div>
    </div>           
  </body>
    
<script type="text/javascript">
$("#query").click(function(){  
  var $no = $('#no').val();
  if($no ==''|| $no.length==0){
        var $dialog = $('#dialog2');
        $dialog.show();
        $dialog.find('.weui_btn_dialog').one('click', function () {
            $dialog.hide();
        });       
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