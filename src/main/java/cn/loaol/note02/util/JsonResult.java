package cn.loaol.note02.util;

import java.io.Serializable;

public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int state;
	private String message;
	private Object data;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonResult(int state, String message, Object data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}
	public JsonResult() {
	}
	
}
