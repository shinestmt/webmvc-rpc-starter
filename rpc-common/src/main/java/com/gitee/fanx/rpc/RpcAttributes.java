package com.gitee.fanx.rpc;

/**
 * @author fanhang
 */
public class RpcAttributes {
	private String timestamp;
	private String path;
	private Integer status;
	private String error;
	private String message;
	private String requestId;
	private RpcErrorBody rpc;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public RpcErrorBody getRpc() {
		return rpc;
	}

	public void setRpc(RpcErrorBody rpc) {
		this.rpc = rpc;
	}
}
