<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/include.jsp" %>
<html>
  <head>
 <meta content="yes" name="apple-mobile-web-app-capable"/>
 <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,user-scalable=no;">
    <title>微信下单</title>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/weui.min.css"/>
	<link rel="stylesheet" href="<%=basePath%>/weui/style/example.css"/>
	<script src="jquery/jquery.js"></script>
  </head>
  <body>     
    <div class="hd">
        <h1 class="page_title">微信下单</h1>
    </div>  
        <!-- <div class="weui_cells_title">可以添加说明文字</div> -->
        <form id="myform" name="myform" method="post">
        <div class="weui_cells weui_cells_form">
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">姓名</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入姓名.." onfocus="removeWarn('no')"/>
                </div>
                <div id="no_div_warn" class="weui_cell_ft" style="display:none;">
                    <i class="weui_icon_warn"></i>
                </div>                
            </div>    
            
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">电话</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入电话.." onfocus="removeWarn('no')"/>
                </div>
                <div id="no_div_warn" class="weui_cell_ft" style="display:none;">
                    <i class="weui_icon_warn"></i>
                </div>                
            </div>     
            
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">站点</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入站点.." onfocus="removeWarn('no')"/>
                </div>
                <div id="no_div_warn" class="weui_cell_ft" style="display:none;">
                    <i class="weui_icon_warn"></i>
                </div>                
            </div>     
            
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">地址</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input class="weui_input" type="text" id="no" name="ware.no" placeholder="请您输入地址.." onfocus="removeWarn('no')"/>
                </div>
                <div id="no_div_warn" class="weui_cell_ft" style="display:none;">
                    <i class="weui_icon_warn"></i>
                </div>                
            </div>       
            
            <div id="no_div" class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">备注</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <textarea class="weui_textarea" placeholder="请您输入备注.." rows="3"></textarea>
                </div>
            </div>                 
            </div>                                         
            
            
        </div>
        
        <!-- <div class="weui_cells_tips">可以添加说明文字</div> -->
        <div id="result" class="weui_btn_area" style="display:none;">
        </div>
        </form>
        <a class="weui_btn weui_btn_primary" href="#" id="query">提交</a>   
  </body>
    
<script type="text/javascript">
 </script>    
</html>