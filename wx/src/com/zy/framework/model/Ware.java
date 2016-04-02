package com.zy.framework.model;

import java.io.Serializable;

public class Ware implements Serializable {
	private static final long serialVersionUID = -7236277709307051182L;
	
	private String no;
	
	private String result;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
