package com.hoidd.core.payload;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Integer STATUS_SUCCESS = 1;
	public static final Integer STATUS_FAIL = 0;
	
	private Integer status;
	private T data;
	private String message;
	
	public ApiResponse() {
		super();
	}
	
	public ApiResponse<T> getSucessResponse(T data, String message) {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(STATUS_SUCCESS);
		response.setData(data);
		response.setMessage(message);
		return response;
	}
	
	public ApiResponse<T> getErrorResponse(String message) {
		ApiResponse<T> response = new ApiResponse<>();
		response.setStatus(STATUS_FAIL);
		response.setData(null);
		response.setMessage(message);
		return response;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "AppResponse [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	
	
}
