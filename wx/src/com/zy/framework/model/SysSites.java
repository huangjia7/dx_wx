package com.zy.framework.model;

import java.io.Serializable;

public class SysSites implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7583612920939463046L;
	
	private int id;
	
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
