package com.zy.framework.action;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.framework.model.Ware;
import com.zy.framework.service.BaseService;
/**
 * @author zouyi
 *
 */
@Scope("request")
@Controller("BaseAction")
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	public Map responseJson;

	public Map getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(Map responseJson) {
		this.responseJson = responseJson;
	}
	
	@Resource
	private BaseService baseService = null; // 业务处理对象

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
}
