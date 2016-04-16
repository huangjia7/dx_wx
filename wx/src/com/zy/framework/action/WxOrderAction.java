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
	private List<SysSites> list=null;

/*	@Override
	public String execute() throws Exception {
		list = (List<SysSites>) this.getBaseService().getObjects("order.getWxSites", null);
		return "success";
	}*/
	
	public String pre(){
		list = (List<SysSites>) this.getBaseService().getObjects("order.getWxSites", null);
		return "success";
	}
	
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
	 * 获取状态
	 * 
	 * @return 数据列表
	 */
	public String getOrderState() {
/*		String result = "无此单号信息!";
		try {
			Ware rWare = (Ware) this.getBaseService().getObject("getStateByNo", ware);
			Map<String, Object> map = new HashMap<String, Object>();

			if (rWare != null && StringUtils.isNotBlank(rWare.getResult())) {
				result = rWare.getResult();
			}

			map.put("state", result);
		} catch (Exception ee) {
			ee.printStackTrace();
		}*/
		return Action.SUCCESS;
	}


	public WxOrder getWxorder() {
		return wxorder;
	}

	public void setWxorder(WxOrder wxorder) {
		this.wxorder = wxorder;
	}

	public List<SysSites> getList() {
		return list;
	}

	public void setList(List<SysSites> list) {
		this.list = list;
	}

}
