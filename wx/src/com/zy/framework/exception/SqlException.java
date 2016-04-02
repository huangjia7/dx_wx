package com.zy.framework.exception;

public class SqlException extends Exception {
	private static final long serialVersionUID = -2528721270540362905L;
	public SqlException(String message) {
		super(message);
	}
	public SqlException(Throwable cause) {
		super(cause);
	}
	public SqlException(String message, Throwable cause) {
		super(message, cause);
	}

}