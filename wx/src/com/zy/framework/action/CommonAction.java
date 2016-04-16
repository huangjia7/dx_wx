package com.zy.framework.action;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.zy.framework.model.Ware;
/**
 * 参数设置
 * @author zouyi
 *
 */
@Scope("request")
@Controller("CommonAction")
@SuppressWarnings("serial")
public class CommonAction extends BaseAction{
	private Ware ware;

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
}
