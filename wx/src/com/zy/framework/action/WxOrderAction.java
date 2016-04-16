package com.zy.framework.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zy.framework.exception.SqlException;
import com.zy.framework.model.SysSites;
import com.zy.framework.model.WxOrder;
/**
 * 微信订单管理
 * @author zouyi
 *
 */
@Scope("request")
@Controller("wxOrderAction")
@SuppressWarnings("serial")
public class WxOrderAction extends BaseAction{
	private WxOrder wxorder;
	private List<SysSites> sitelist=null;
	private List<WxOrder> orderlist=null;
	
	public String pre(){
		sitelist = (List<SysSites>) this.getBaseService().getObjects("order.getWxSites", null);
		return Action.SUCCESS;
	}
	
	/**
	 * 保存网络订单
	 * @return
	 */
	public String save(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			wxorder.setState(0);
			this.getBaseService().insertObject(wxorder);
			
			map.put("state", Action.SUCCESS);
			this.setResponseJson(map);
		} catch (SqlException e) {
			map.put("state", Action.ERROR);
			this.setResponseJson(map);
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 获取网络订单列表
	 * 
	 * @return 数据列表
	 */
	public String list() {
		orderlist = (List<WxOrder>) this.getBaseService().getObjects("order.getOrderList", null);
		return Action.SUCCESS;
	}


	public WxOrder getWxorder() {
		return wxorder;
	}

	public void setWxorder(WxOrder wxorder) {
		this.wxorder = wxorder;
	}

	public List<SysSites> getSitelist() {
		return sitelist;
	}

	public void setSitelist(List<SysSites> sitelist) {
		this.sitelist = sitelist;
	}

	public List<WxOrder> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<WxOrder> orderlist) {
		this.orderlist = orderlist;
	}
}
