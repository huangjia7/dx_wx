package com.zy.framework.action;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zy.framework.model.Ware;
import com.zy.framework.service.BaseService;
/**
 * 参数设置
 * @author zouyi
 *
 */
@Scope("request")
@Controller("CommonAction")
@SuppressWarnings("serial")
public class CommonAction {
	private Ware ware;
	private String te1;
	private String age;

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	/**
	 * 获取状态
	 * 
	 * @return 数据列表
	 */
	public String getOrderState() {
		String result = "无此单号信息!";
		try {
			Ware rWare = (Ware) this.getBaseService().getObject("getStateByNo", ware);
			Map<String, Object> map = new HashMap<String, Object>();

			if (rWare != null && StringUtils.isNotBlank(rWare.getResult())) {
				result = rWare.getResult();
			}

			map.put("state", result);
			this.setResponseJson(map);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return Action.SUCCESS;
	}

	@Resource
	private BaseService baseService = null; // 业务处理对象

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public Map responseJson;

	public Map getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
}
