package com.zy.framework.model;

import java.io.Serializable;

public class WxOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2986192784111701974L;

	private String name;
	
	private String tel;
	
	private String siteid;
	
	private String addr;
	
	private String note;
	
	private int state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
